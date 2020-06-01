import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int t = in.nextInt();
        out.println(t);
        for (int i=0;i<t;i++) {
            Pair.direction = 'E';
            String path = in.next();
            ArrayList<Pair> coords = new ArrayList<>();
            coords.add(new Pair(1, 0));
            for(int j=0;j<path.length();j++){
                coords.add(coords.get(coords.size() - 1).getNextStep(path.charAt(j)));
            }
            int minX = 1000, maxX = -1000, maxY = -1000;
            for(Pair coord: coords) {
                minX = Math.min(coord.x, minX);
                maxX = Math.max(coord.x, maxX);
                maxY = Math.max(coord.y, maxY);
            }

            for (Pair coord: coords) {
                coord.x += -minX + 1;
            }
            int h = maxX - minX + 3;
            int w = (maxY + 2);
            char[][] maze = new char[h][w];
            for (int j=0;j<h;j++) {
                for (int k=0;k<w;k++) maze[j][k] = '#';
            }

            for (Pair coord: coords) {
                maze[coord.x][coord.y] = '.';
            }

            String ans = "";
            for (int j=0;j<h;j++) {
                for (int k=0;k<w;k++) ans += maze[j][k];
                if(j != h-1)ans += '\n';
            }
            out.println(h + " " + w);
            out.println(ans);
        }
        out.close();
    }
    static class Pair {
        public int x;
        public int y;
        public static char direction = 'E';
        public static char[] moves      = {'F', 'B', 'L', 'R'};
        public static char[] directions = {'E', 'W', 'N', 'S'};
        public static int[][][] map = {
                {{0,0,-1,1}, {1,-1,0,0}},//E
                {{0,0,1,-1}, {-1,1,0,0}},//W
                {{-1,1, 0,0}, {0,0, -1,1}},//N
                {{1,-1,0,0}, {0,0,1,-1}}//S
        };
        Pair(int  x, int y) {
            this.x = x;
            this.y = y;
        }
        Pair getNextStep(char move) {
            int dirIndex = 0;
            for(int i=0;i<4;i++) {
                if(this.directions[i] == this.direction) {
                    dirIndex = i;
                    break;
                }
            }
            int[][] dxy = this.map[dirIndex];

            int moveIndex = 0;
            for (int i=0;i<4;i++) {
                if (this.moves[i] == move) {
                    moveIndex = i;
                    break;
                }
            }
            this.nextDir(dirIndex, moveIndex);
            return new Pair(this.x + dxy[0][moveIndex], this.y + dxy[1][moveIndex]);
        }

        public void nextDir(int dirIndex, int moveIndex) {
            if(dirIndex <= 1 && moveIndex <= 1) {
                this.direction = this.directions[(dirIndex + moveIndex) % 2];
            }
            else if(dirIndex > 1 && moveIndex > 1) {
                this.direction = this.directions[((dirIndex + moveIndex) % 2 + 1)%2];
            }
            else {
                this.direction = this.directions[((dirIndex + moveIndex) % 2) + 2];
            }
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
