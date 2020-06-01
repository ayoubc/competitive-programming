
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder ans = new StringBuilder();

        int L, W;
        int tc = 1;
        while(true) {
            String[] line = sc.nextLine().split(" ");
            W = Integer.parseInt(line[0]);
            L = Integer.parseInt(line[1]);
            if (L == 0 && W == 0) break;
            String[] house = new String[L];
            for (int i=0;i<L;i++) {
                house[i] = sc.nextLine();
            }

            //System.out.println(L + " " + W);
            Pair door = new Pair(0, 0);
            for(int i=0;i<L;i++) {
                for (int j=0;j<W;j++) {
                    if (house[i].charAt(j) == '*'){
                        door = new Pair(i, j);
                        break;
                    }
                }
            }
            if (door.x == 0) Pair.direction = 'S';
            else if (door.x == L - 1) Pair.direction = 'N';
            else if (door.y == 0) Pair.direction = 'E';
            else Pair.direction = 'W';
            Pair exit = new Pair(door.x, door.y);

            while(true) {

                Pair fac = Pair.getFactors();
                int i = exit.x + fac.x;
                int j = exit .y + fac.y;
                if (fac.x != 0){
                    while (i>=0 && i<L) {
                        if ((house[i].charAt(j) == '/' || house[i].charAt(j) == '\\')){
                            //System.out.println(house[i].charAt(j));
                            break;
                        }
                        i += fac.x;
                    }
                }
                if (fac.y != 0){
                    while (j>=0 && j<W) {
                        if ((house[i].charAt(j) == '/' || house[i].charAt(j) == '\\')){
                            //System.out.println(house[i].charAt(j));
                            break;
                        }
                        j += fac.y;
                    }
                }
                if (i<0 || i>=L || j<0 || j>= W) {
                    i = Math.min(Math.max(i, 0), L-1);
                    j = Math.min(Math.max(j, 0), W-1);
                    exit.x = i;
                    exit.y = j;
                    break;
                }
                exit.x = i;
                exit.y = j;
                Pair.nextDir(house[i].charAt(j));
            }

            ans.append("HOUSE " + tc + "\n");
            String exitWall = "";
            for(int j=0;j<W;j++) {
                if(j == exit.y) exitWall += '&';
                else exitWall += house[exit.x].charAt(j);
            }
            house[exit.x] = exitWall;
            for(String str: house) ans.append(str + '\n');
            tc++;
        }
        System.out.println(ans);
        sc.close();
    }
    static class Pair {
        public int x;
        public int y;
        public static char direction = 'E';
        public static char[] directions = {'E', 'W', 'N', 'S'};
        public static int[][] factors = {
                {0,0,-1,1},
                {1,-1,0,0}
        };
        public static char[] mirrors = {'/', '\\'};
        public static char[][] mirrorDirections = {
                {'N', 'S', 'E', 'W'},
                {'S', 'N', 'W', 'E'}
        };
        Pair(int  x, int y) {
            this.x = x;
            this.y = y;
        }
        public static int findDir(){
            int dirIndex = 0;
            for(int i=0;i<4;i++) {
                if(directions[i] == direction){
                    dirIndex = i;
                    break;
                }
            }
            return dirIndex;
        }
        public static void nextDir(char mirror) {
            int mirrorIndex = 0;
            for(int i=0;i<2;i++) {
                if (mirrors[i] == mirror){
                    mirrorIndex = i;
                    break;
                }
            }
            int dirIndex = findDir();
            direction = mirrorDirections[mirrorIndex][dirIndex];
            int p = 0;
        }
        public static Pair getFactors() {
            int dirIndex = findDir();
            return new Pair(factors[0][dirIndex], factors[1][dirIndex]);
        }
    }

    static class A {
        private int[] a;
        A(int[] arr) {
            this.a = arr.clone();
        }

        public void setA(int index, int val) {
            this.a[index] = val;
        }

        public void print() {
            for (int x: this.a) System.out.print(x + ", ");
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

    }

}
