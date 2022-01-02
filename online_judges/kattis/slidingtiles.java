
import java.util.*;

public class Solution {
    static String alpha = "abcdefghijklmnopqrstuvwxy".toUpperCase();
    static char[][] mat;
    static HashMap<Character,int[]> indexOfChar;
    static int n, len;
    static char banne = ' ';
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            n = in.nextInt();
            if(n==-1) return;
            len = n*2 + 5;
            mat = new char[len][len];
            indexOfChar = new HashMap<>();
            fill();
            for(int i=0; i<n; i++){
                char v = in.next().charAt(0);
                String dir = in.next();
                move(v,dir);
            }
            printRes();

        }
    }

    static void printRes(){
        int[] extrs = getEtrems();
        int l = extrs[0];
        int r = extrs[1];
        int t = extrs[2];
        int b = extrs[3];
        for(int i= t; i<b+1; i++){

            int rightMost = r;
            while(rightMost>=0 && mat[i][rightMost] == banne) rightMost --;
            for(int j= l; j<=rightMost; j++){
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void move(char v, String dir){
        int[] indexof = indexOfChar.get(v);
        int i = indexof[0];
        int j = indexof[1];

        int k = dir.equals("up") || dir.equals("down") ? i : j;
        int p = dir.equals("down") || dir.equals("right") ? 1: -1;
        char prev = mat[i][j];
        indexOfChar.remove(mat[i][j]);
        mat[i][j] = banne;

        while(k+p<len && k+p>-1){
            char next = ' ';
            if(dir.equals("left") || dir.equals("right")){
                next = mat[i][k+p];
                mat[i][k+p] = prev;
                prev = next;
                indexOfChar.put(mat[i][k+p], new int[]{i,k+p});
            }else{
                next = mat[k+p][j];
                mat[k+p][j] = prev;
                prev = next;
                indexOfChar.put(mat[k+p][j], new int[]{k+p,j});
            }
            k += p;
            if(next == banne) return;
        }
    }

    static int[] getEtrems(){
        int[] extrs = new int[]{len,0,len,0};
        Set<Map.Entry<Character, int[]>> vals = indexOfChar.entrySet();
        for(Map.Entry<Character, int[]> entry:vals){
            int[] p = entry.getValue();
            extrs[0] = Math.min(extrs[0], p[1]);
            extrs[1] = Math.max(extrs[1], p[1]);
            extrs[2] = Math.min(extrs[2], p[0]);
            extrs[3] = Math.max(extrs[3], p[0]);
        }
        return extrs;
    }

    static void fill(){
        for(int i=0;i<len; i++){
            Arrays.fill(mat[i],banne);
        }
        for(int i=0;i<5; i++){
            for(int j=0; j<5; j++){
                char ch = alpha.charAt(5*i+j);
                mat[n+i][n+j]= ch;
                indexOfChar.put(ch, new int[]{n+i, n+j});
            }
        }
    }
}