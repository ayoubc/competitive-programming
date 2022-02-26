
import java.io.*;
import java.net.CookieHandler;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;
    static double[] oldBestPercent = {1.0, 0.69, 0.34, 0.076, 0.6, 0.09};

    static double[] bestPercent = {1.0, 0.69, 0.34, 0.076, 0.6, 0.09};
    static char currentLetter = 'a';

    public static void main(String[] args){
//        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};


        char[] chars = {'f'};
        for (char c : chars) {
            currentLetter = c;
            InputStream is;
            OutputStream outfile;
            try {
                is = new FileInputStream(".\\src\\input\\" + c + ".txt");
                outfile = new FileOutputStream(".\\src\\output\\" + c + "_out.txt");
            } catch (FileNotFoundException e) {
                is = System.in;
                outfile = System.out;
            }
            InputReader in = new InputReader(is);
            PrintWriter out = new PrintWriter(outfile);

            int C = in.nextInt();
            int P = in.nextInt();

            Contributor[] contributors = new Contributor[C];
            for (int i=0;i<C;i++){
                String name = in.next();
                int n = in.nextInt();
                Skill[] skills = new Skill[n];
                for (int j=0;j<n;j++) {
                    skills[j] = new Skill(in.next(), in.nextInt());
                }
                contributors[i] = new Contributor(name, skills);
            }

            Project[] projects = new Project[P];
            for (int i=0;i<P;i++){
                String name = in.next();
                int D = in.nextInt();
                int S = in.nextInt();
                int B = in.nextInt();
                int R = in.nextInt();

                Skill[] skills = new Skill[R];
                for (int j=0;j<R;j++) {
                    skills[j] = new Skill(in.next(), in.nextInt());
                }
                projects[i] = new Project(name, D, S, B, skills);
            }

            Arrays.sort(projects, (p1, p2) -> {
                int s1 = p1.getTotalScore();
                int s2 = p2.getTotalScore();
                if (s1 == s2) {
                    if (p1.score == p2.score) return 0;
                    if (p1.score > p2.score) return -1;
                    return 1;
                }
                if (s1 < s2) return -1;
                return 1;
            });

            solve2(C, P, contributors, projects, out);
            out.close();
        }
    }

    static void solve(int C, int P, Contributor[] contributors, Project[] projects, PrintWriter out) {

        List<Project> res = new ArrayList<>();
        int days = 0;
        for (int i=0;i<P; i++) {

            List<Contributor> roles = new ArrayList<>();
            for (int k=0;k<projects[i].roles;k++) {
                Skill role = projects[i].rolesSkills[k];

                boolean found = false;
                for (int j=0;j<C;j++) {
                    if (contributors[j].isTaken) continue;

                    Skill skill = contributors[j].getSkill(role.name);
                    if (skill != null && skill.level >= role.level) {
                        contributors[j].take();
                        roles.add(contributors[j]);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    for (int s=0;s<k;s++) {
                        Contributor con = roles.get(s);
                        Skill sk = con.getSkill(role.name);
                        if (sk != null && sk.level >= role.level) {
                            for (int j=0;j<C;j++) {
                                if (contributors[j].isTaken) continue;

                                Skill skill = contributors[j].getSkill(role.name);
                                if (skill != null && skill.level == role.level - 1) {
                                    contributors[j].take();
                                    roles.add(contributors[j]);
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if (found) break;
                    }
                }
                if (!found) break;
            }

            if (roles.size() == projects[i].roles) {
                projects[i].contributors = roles;
                projects[i].updateSkills();
                res.add(projects[i]);
            }
            for (Contributor con: roles) con.release();
            days += projects[i].days;
        }

        out.println(res.size());
        for (Project p: res) {
            out.println(p.name);
            for (Contributor con: p.contributors) out.print(con.name + " ");
            out.println();
        }
    }
    static void solve2(int C, int P, Contributor[] contributors, Project[] projects, PrintWriter out) {
        HashSet<String> allSkillsSet = new HashSet<>();
        HashMap<String, List<Contributor>> allSkillsMap = new HashMap<>();
        for (Contributor con: contributors) {
            for (Skill skill: con.skills) {
                allSkillsSet.add(skill.name);
                List<Contributor> tmp = allSkillsMap.get(skill.name);
                if (tmp == null) tmp = new ArrayList<>();

                tmp.add(con);
                allSkillsMap.put(skill.name, tmp);
            }
        }

        for (String name: allSkillsSet) {
            List<Contributor> tmp = allSkillsMap.get(name);
            Collections.sort(tmp, (c1, c2) -> {
                Skill s1 = c1.getSkill(name);
                Skill s2 = c2.getSkill(name);
                if (s1.level == s2.level) return 0;
                if (s1.level < s2.level) return -1;
                return 1;
            });
            allSkillsMap.put(name, tmp);
        }


        Queue<Project> q = new LinkedList<>();
        for (Project p: projects) q.add(p);

        List<Project> res = new ArrayList<>();
        int days = 0;

        int percent = (int) (bestPercent[currentLetter - 'a'] * P);

        while (!q.isEmpty()) {
            Project project = q.poll();

            List<Contributor> roles = new ArrayList<>();
            for (int k=0;k<project.roles;k++) {

                Skill role = project.rolesSkills[k];

                boolean found = false;
                List<Contributor> cons = allSkillsMap.get(role.name);
                for (Contributor con: cons) {
                    if (con.isTaken) continue;

                    Skill skill = con.getSkill(role.name);
                    if (skill.level >= role.level) {
                        con.take();
                        roles.add(con);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    for (int s=0;s<k;s++) {
                        Contributor rolCon = roles.get(s);
                        Skill sk = rolCon.getSkill(role.name);

                        if (sk != null && sk.level >= role.level) {
                            for (Contributor con: cons) {

                                if (con.isTaken) continue;

                                Skill skill = con.getSkill(role.name);
                                if (skill != null && skill.level >= role.level) {
                                    con.take();
                                    roles.add(con);
                                    found = true;
                                    break;
                                }

                            }
                        }
                        if (found) break;
                    }
                }
                if (!found) break;
            }

            if (roles.size() == project.roles) {
                project.contributors = roles;
                project.updateSkills();
                res.add(project);
            }
            else {
                if (res.size() < percent) q.add(project);
//                if (project.score >= days - project.bestBefore) q.add(project);

            }
            for (Contributor con: roles) con.release();
            days += project.days;
        }
        System.out.println(days);
        out.println(res.size());
        for (Project p: res) {
            out.println(p.name);
            for (Contributor con: p.contributors) out.print(con.name + " ");
            out.println();
        }
    }

    static class Contributor {
        String name;
        int numSkills;
        Skill[] skills;
        HashMap<String, Skill> skillMap;
        boolean isTaken = false;
        public Contributor(String name, Skill[] skills) {
            this.name = name;
            this.skills = skills;
            this.numSkills = skills.length;
            this.skillMap = new HashMap<>();
            for (Skill skill: skills) {
                skillMap.put(skill.name, skill);
            }
        }

        public void release() {
            isTaken = false;
        }
        public void take() {
            isTaken = true;
        }

        public Skill getSkill(String name) {
            return skillMap.get(name);
        }
        public void updateSkill(Skill skill) {
            skill.level ++;
        }
    }
    static class Project {
        String name;
        int days; //  the number of days it takes to complete the project,
        int score; //  the score awarded for project’s completion,
        int bestBefore; // the “best before” day for the project,
        int roles;  //  the number of roles in the project.
        Skill[] rolesSkills;

        int totalScore = -1;
        List<Contributor> contributors;
        public Project(String name, int days, int score, int bestBefore, Skill[] rolesSkills) {
            this.name = name;
            this.days = days;
            this.score = score;
            this.bestBefore = bestBefore;
            this.rolesSkills = rolesSkills;
            this.roles = rolesSkills.length;
            this.contributors = new ArrayList<>();
        }

        public void releaseContributors() {
            for (Contributor con: contributors) con.release();
            contributors = new ArrayList<>();
        }
        public boolean fulfilled() {
            return contributors.size() == roles;
        }

        public void updateSkills() {
            for (int i=0;i<roles;i++) {
                Contributor con = contributors.get(i);
                Skill skill = con.getSkill(rolesSkills[i].name);
                if (skill.level <= rolesSkills[i].level) con.updateSkill(skill);
            }
        }

        public int getTotalScore() {
//            if (totalScore == -1) {
//                totalScore = roles;
//                for (Skill sk: rolesSkills) {
//                    totalScore += sk.level;
//                }
//                totalScore -= score;
//                totalScore -= bestBefore;
//                totalScore += days;
//            }
//            return totalScore;
            return score - days + bestBefore;
        }
    }
    static class Skill {
        String name;
        int level;

        public Skill(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {return Double.parseDouble(next());}
    }
}