
import java.io.*;
import java.util.*;


public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int mod = (1 << 31) - 1;
    static List<Integer>[] graph;

    static char[][] grid;

    static char currentLetter = 'a';
    static int MAX_PROJECTS_IN_PARALLEL = 150;
    static int PERCENTILE_PROJECTS_PARALLEL = 25;

    public static void main(String[] args){
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};


//        char[] chars = {'f'};
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

            MAX_PROJECTS_IN_PARALLEL = Math.min((P * PERCENTILE_PROJECTS_PARALLEL) / 100, MAX_PROJECTS_IN_PARALLEL);

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
                    if (p1.score == p2.score) {
                        if (p1.bestBefore == p2.bestBefore) {
                            if (p1.days == p2.days) {
                                if (p1.roles == p2.roles) return 0;
                                if (p1.roles < p2.roles) return -1;
                                return 1;
                            }
                            if (p1.days < p2.days) return -1;
                            return 1;
                        }
                        if (p1.bestBefore < p2.bestBefore) return -1;
                        return 1;
                    }
                    if (p1.score > p2.score) return -1;
                    return 1;
                }
                if (s1 > s2) return -1;
                return 1;
            });

            IStrategy Strategy = new Strategy3();

            List<Project> res = Strategy.solve(C, P, contributors, projects);

            out.println(res.size());
            for (Project p: res) {
                out.println(p.name);
                for (Contributor con: p.contributors) out.print(con.name + " ");
                out.println();
            }

            out.close();
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

        public void updateSkills() {
            for (int i=0;i<roles;i++) {
                Contributor con = contributors.get(i);
                Skill skill = con.getSkill(rolesSkills[i].name);
                if (skill.level <= rolesSkills[i].level) con.updateSkill(skill);
            }
        }

        public int getTotalScore() {

            if (totalScore == -1) {
                int levels = 0;
                for (Skill sk: rolesSkills) {
                    levels += sk.level;
                }

                totalScore = (score * 50 + days * 15 + bestBefore * 20 + levels * 6 + roles * 9) / 100;
            }
            return totalScore;
//            return bestBefore; // max score on e
//            return days;  // gives max score on f
//            return score - days + bestBefore;
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

    static interface IStrategy {
        public List<Project> solve(int C, int P, Contributor[] contributors, Project[] projects);
    }

    static class Strategy1 implements IStrategy {
        public List<Project> solve(int C, int P, Contributor[] contributors, Project[] projects) {

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

            return res;
        }
    }

    static class Strategy2 implements IStrategy {
        public List<Project> solve(int C, int P, Contributor[] contributors, Project[] projects) {
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
                    if (project.score >= days - project.bestBefore) q.add(project);
                }
                for (Contributor con: roles) con.release();
                days += project.days;
            }

            return res;
        }
    }

    static class Strategy3 implements IStrategy {
        public List<Project> solve(int C, int P, Contributor[] contributors, Project[] projects) {

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

            while (true) {
                if (q.isEmpty()) break;

                List<Project> parallelProjects = new ArrayList<>();

                List<Project> toRecycle = new ArrayList<>();

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
                            // search for mentors in the same team
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
                        // here we fullfill all roles of the project, now it can be done
                        project.contributors = roles;
                        parallelProjects.add(project);
                    }
                    else {
                        // release the contributors because the project is not fulfilled
                        for (Contributor c: roles) c.release();
                        toRecycle.add(project);
                    }

//                if (parallelProjects.size() >= MAX_PROJECTS_IN_PARALLEL) {
//                    System.out.println("Current Letter: " + currentLetter + "; Over Max");
//                    break;
//                }
                }

                if (parallelProjects.size() == 0) {
                    days ++;
                }

                int maxDays = 0;

                for (Project p: parallelProjects) {
                    p.updateSkills();
                    res.add(p);
                    maxDays = Math.max(p.days, maxDays);

                    for (Contributor c: p.contributors) c.release();
                }

                days += maxDays;

                for (Project p: toRecycle) {
                    if (p.score >= days - p.bestBefore) q.add(p);
                }

            }

            // printing the results
            return res;
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