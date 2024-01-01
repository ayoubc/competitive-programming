class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int s = prices[0] + prices[1];
        if (s > money) return money;
        return money - s;
    }
}