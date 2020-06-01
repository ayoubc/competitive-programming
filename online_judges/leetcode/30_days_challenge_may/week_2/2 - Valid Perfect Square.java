class Solution {
    public boolean isPerfectSquare(int num) {
        if (num == 0) return false;
        int x = (int)squareRoot(num);
        //System.out.println(squareRoot(num));
        return x * x == num;
    }
    
    public double squareRoot(double number){
        double error = 0.00001;
        double s = number;

        while ((s - number / s) > error){
            s = (s + number / s) / 2;
        }
        return s;
    }
}