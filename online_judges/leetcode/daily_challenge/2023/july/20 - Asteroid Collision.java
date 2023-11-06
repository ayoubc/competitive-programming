class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=0;i<asteroids.length;i++) {
            if (stack.isEmpty()) stack.push(asteroids[i]);
            else {
                boolean exploded = false;
                while(!stack.isEmpty()) {
                    int x = stack.peek();
                    if (x > 0 && asteroids[i] < 0) {
                        if (x < Math.abs(asteroids[i])) {
                            stack.pop();
                        }
                        else if (x > Math.abs(asteroids[i])) {
                            exploded = true;
                            break;
                        }
                        else {
                            stack.pop();
                            exploded = true;
                            break;
                        }
                    }
                    else break;
                }
                if (!exploded) stack.push(asteroids[i]);
            }
        }
        int[] res = new int[stack.size()];
        int i=stack.size()-1;
        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}