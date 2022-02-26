
import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args){
        char c = 'e';
        InputStream is;
        OutputStream outfile;
        try {
            is = new FileInputStream(".\\src\\" + c + ".txt");
            outfile = new FileOutputStream(".\\src\\" + c + "_out.txt");
        } catch (FileNotFoundException e) {
            is = System.in;
            outfile = System.out;
        }
        InputReader in = new InputReader(is);
        PrintWriter out = new PrintWriter(outfile);

        int n = in.nextInt();
        Client[] clients = new Client[n];

        for (int i=0;i<n;i++) {
            HashSet<String> likes = new HashSet<>();
            HashSet<String> dislikes = new HashSet<>();

            int l = in.nextInt();
            for (int j=0;j<l;j++) likes.add(in.next());
            int d = in.nextInt();
            for (int j=0;j<d;j++) dislikes.add(in.next());
            clients[i] = new Client(likes, dislikes, i);

        }

        HashSet<String> ans = solve6(clients);
        int maxScore = score(ans, clients);



        System.out.println(maxScore);
        StringBuilder sb = new StringBuilder();
        sb.append(ans.size() + " ");
        for (String ing: ans) sb.append(ing + " ");
        out.println(sb);
        out.close();
    }
    static void merge(HashSet<String> source, HashSet<String> des){
        for (String str: source) des.add(str);
    }

    static void mergeList(HashSet<Integer> source, HashSet<Integer> des) {
        for (Integer str: source) des.add(str);
    }

    static void update(HashMap<String, Integer> map, String key) {
        Integer occ = map.get(key);
        if (occ == null) map.put(key, 1);
        else map.put(key, occ+1);
    }

    static void updateList(HashMap<String, HashSet<Integer>> map, String key, int id) {
        HashSet<Integer> ids = map.get(key);
        if (ids == null) ids = new HashSet<>();
        ids.add(id);
        map.put(key, ids);
    }

    static HashSet<String> solve2(Client[] clients) {
        HashMap<String, Integer> liked = new HashMap<>();
        HashMap<String, Integer> disliked = new HashMap<>();

        for (Client client: clients) {

            for (String ing: client.likes) update(liked, ing);
            for (String ing: client.dislikes) update(disliked, ing);
        }
        HashSet<String> ans = new HashSet<>();
        for (Map.Entry<String, Integer> entry: liked.entrySet()){
            int v = entry.getValue();
            Integer x = disliked.get(entry.getKey());
            if (x == null) x = 0;
            v -= x;
            if (v >= 0) ans.add(entry.getKey());
        }
        return ans;
    }

    static HashSet<String> solve6(Client[] clients) {
        HashMap<String, HashSet<Integer>> liked = new HashMap<>();
        HashMap<String, HashSet<Integer>> disliked = new HashMap<>();

        for (Client client: clients) {

            for (String ing: client.likes) updateList(liked, ing, client.id);
            for (String ing: client.dislikes) updateList(disliked, ing, client.id);
        }

        List<String> ingredients = new ArrayList<>();

        for (Map.Entry<String, HashSet<Integer>> entry: liked.entrySet()){
            ingredients.add(entry.getKey());
        }

        Collections.sort(ingredients, (i1, i2) -> {
            HashSet<Client> ic1 = getRealLiked(i1, liked, clients, null);
            HashSet<Client> ic2 = getRealLiked(i2, liked, clients, null);
            if (ic1.size() == ic2.size()) return 0;
            if (ic1.size() > ic2.size()) return -1;
            return 1;
        });
        HashSet<String> ans = new HashSet<>();
        for (String ing: ingredients){
            HashSet<Client> ingClients = getRealLiked(ing, liked, clients, ans);


            int vl = ingClients.size();
            HashSet<Integer> x = disliked.get(ing);
            int vd = 0;
            if (x != null) vd = x.size();
            vl -= vd;
            if (vl >= 0) ans.add(ing);
        }
        return ans;
    }

    static HashSet<String> solve4(Client[] clients) {
        HashMap<String, HashSet<Integer>> liked = new HashMap<>();
        HashMap<String, HashSet<Integer>> disliked = new HashMap<>();

        for (Client client: clients) {

            for (String ing: client.likes) updateList(liked, ing, client.id);
            for (String ing: client.dislikes) updateList(disliked, ing, client.id);
        }

        List<String> ingredients = new ArrayList<>();

        for (Map.Entry<String, HashSet<Integer>> entry: liked.entrySet()){
            ingredients.add(entry.getKey());
        }

        int maxClients = 0;
        int index = -1;
        String ingredient = "";
        for (int i=0;i<ingredients.size();i++) {
            String ing = ingredients.get(i);
            HashSet<Client> ingClients = getRealLiked(ing, liked, clients, null);

            if (maxClients < ingClients.size()) {
                maxClients = ingClients.size();
                index = i;
                ingredient = ing;
            }
        }

        boolean[] vis = new boolean[ingredients.size()];

        HashSet<Integer> totalClients = new HashSet<>();
        mergeList(liked.get(ingredient), totalClients);

        HashSet<String> ans = new HashSet<>();
        for (Integer id: totalClients) {
            merge(clients[id].likes, ans);
        }

        vis[index] = true;
        while (true) {

            int nextIndex = -1;
            HashSet<Client> toAdd = null;
            for (int i=0;i<ingredients.size();i++) {
                if (vis[i]) continue;

                String curIng = ingredients.get(i);
                HashSet<Integer> dis = disliked.get(curIng);
                boolean ok = true;
                if (dis != null) {
                    for (Integer id: totalClients) {
                        if (dis.contains(id)) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (!ok) continue;

                HashSet<Client> tmpBest = getRealLiked(curIng, liked, clients, ans);

                if (toAdd == null || toAdd.size() < tmpBest.size()) {
                    toAdd = tmpBest;
                    nextIndex = i;
                }

            }
            if (nextIndex == -1) break;

            for (Client c: toAdd) {
                totalClients.add(c.id);
                merge(c.likes, ans);
            }
            vis[nextIndex] = true;
        }
        return ans;
    }

    static HashSet<String> solve5(Client[] clients) {
        HashMap<String, HashSet<Integer>> liked = new HashMap<>();
        HashMap<String, HashSet<Integer>> disliked = new HashMap<>();

        for (Client client: clients) {

            for (String ing: client.likes) updateList(liked, ing, client.id);
            for (String ing: client.dislikes) updateList(disliked, ing, client.id);
        }

        List<String> ingredients = new ArrayList<>();

        for (Map.Entry<String, HashSet<Integer>> entry: liked.entrySet()){
            ingredients.add(entry.getKey());
        }

        Collections.sort(ingredients, (i1, i2) -> {
            HashSet<Client> ic1 = getRealLiked(i1, liked, clients, null);
            HashSet<Client> ic2 = getRealLiked(i2, liked, clients, null);
            if (ic1.size() == ic2.size()) return 0;
            if (ic1.size() > ic2.size()) return -1;
            return 1;
        });

        HashSet<String> ans = new HashSet<>();
        for (String ing: ingredients) {
            HashSet<Client> ingClients = getRealLiked(ing, liked, clients, ans);
            if (ingClients.size() > 0) {
                for (Client c: ingClients) merge(c.likes, ans);
            }
        }
//        int maxScore = 0;
//        for (int i=0;i<1000;i++) {
//            Collections.shuffle(ingredients);
//            HashSet<String> tmpAns = new HashSet<>();
//            for (String ing: ingredients) {
//                HashSet<Client> ingClients = getRealLiked(ing, liked, clients, tmpAns);
//                if (ingClients.size() > 0) {
//                    for (Client c: ingClients) merge(c.likes, tmpAns);
//                }
//            }
//
//            int score = score(tmpAns, clients);
//            if (maxScore < score) {
//                maxScore = score;
//                ans = tmpAns;
//            }
//        }

        return ans;
    }

    static HashSet<Client> getRealLiked(String ing, HashMap<String, HashSet<Integer>> liked, Client[] clients, HashSet<String> ingsLiked) {

        HashSet<Integer> tmpC = liked.get(ing);

        Client[] ingClients = new Client[tmpC.size()];
        int i = 0;
        for (Integer id: tmpC) ingClients[i++] = clients[id];

        int n = tmpC.size();

        List<Client> best = new ArrayList<>();
        for (int b=0;b<(1 << n); b++) {
            List<Client> local = new ArrayList<>();
            HashSet<String> localIngs = new HashSet<>();
            boolean ok = true;
            for (int j=0;j<n;j++) {
                if (((1 << j) & b) != 0) {
                    if (ingClients[j].hasConflicts(localIngs)) {
                        ok = false;
                        break;
                    }
                    local.add(ingClients[j]);
                    merge(ingClients[j].likes, localIngs);
                }
            }

            if (ok) {
                if (best.size() < local.size()) {
                    boolean override = true;
                    if (ingsLiked != null) {
                        for (Client client: local) {
                            if (client.hasConflicts(ingsLiked)) {
                                override = false;
                                break;
                            }
                        }
                    }
                    if (override) best = local;
                }
            }
        }
        return new HashSet<>(best);
    }
    static HashSet<String> solve3(Client[] clients) {
        HashMap<String, Integer> liked = new HashMap<>();
        HashMap<String, Integer> disliked = new HashMap<>();

        for (Client client: clients) {

            for (String ing: client.likes) update(liked, ing);
            for (String ing: client.dislikes) update(disliked, ing);
        }

        Arrays.sort(clients, (c1, c2) -> {
            int s1 = c1.getScore(liked, disliked);
            int s2 = c2.getScore(liked, disliked);
            if (s1 > s2) return -1;
            if (s1 < s2) return 1;


            if (c1.likes.size() > c2.likes.size()) return -1;
            if (c1.likes.size() < c2.likes.size()) return 1;

            if (c1.dislikes.size() < c2.dislikes.size()) return -1;
            if (c1.dislikes.size() > c2.dislikes.size()) return 1;

            return 0;
        });

        return solve(clients);
    }

    static HashSet<String> solve(Client[] clients) {
        HashSet<String> ans = clients[0].likes;

        for (int i=1;i< clients.length;i++) {
            if (!clients[i].hasConflicts(ans)) {
                for (String ing: clients[i].likes) ans.add(ing);
            }
        }
        return ans;
    }

    static int score(HashSet<String> ings, Client[] clients) {
        int res = 0;
        for (Client client: clients) {
            if (!client.hasConflicts(ings) && client.containsAllLikes(ings)) res ++;
        }
        return res;
    }

    static int getValue(HashMap<String, Integer> map, String key) {
        Integer x = map.get(key);
        return x == null ? 0 : x;
    }

    static class Client implements Comparable {
        public int conflict;
        public int id;
        public HashSet<String> likes, dislikes;
        public Integer score;

        public Client(HashSet<String> likes, HashSet<String> dislikes, int id) {
            conflict = 0;
            this.id = id;
            this.likes = likes;
            this.dislikes = dislikes;
            score = null;
        }

        public Client(Client other) {
            conflict = 0;
            this.likes = other.likes;
            this.dislikes = other.dislikes;
        }

        public void computeConflicts(Client other) {
            for (String ing: likes) {
                if (other.dislikes.contains(ing)) {
                    conflict++;
                    return;
                }
            }
            for (String ing: dislikes) {
                if (other.likes.contains(ing)) {
                    other.conflict++;
                    return;
                }
            }
        }

        public boolean hasConflicts(HashSet<String> set) {
            for (String ing: dislikes) {
                if (set.contains(ing)) return true;
            }
            return false;
        }

        public boolean hasConflicts2(HashSet<String> set) {
            for (String ing: likes) {
                if (set.contains(ing)) return true;
            }
            return false;
        }

        public boolean containsAllLikes(HashSet<String> set) {
            for (String ing: likes) {
                if (!set.contains(ing)) return false;
            }
            return true;
        }

        public int getScore(HashMap<String, Integer> liked, HashMap<String, Integer> disliked) {
            if(score != null) return score;
            score = 0;
            for (String ing: likes) {
                score += getValue(liked, ing) - getValue(disliked, ing);
            }
            score = Math.max(score, 0);
            return score;
        }

        @Override
        public int compareTo(Object o) {
            Client other = (Client) o;
            if (conflict == other.conflict) {
                if (dislikes.size() == other.dislikes.size()) {
                    if (likes.size() == other.likes.size()) return 0;
                    else if (likes.size() > other.likes.size()) return -1;
                    return 1;
                }
                else if (dislikes.size() > other.dislikes.size()) return -1;
                return 1;
            }
            else if (conflict < other.conflict) return -1;
            return 1;
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
    }
}