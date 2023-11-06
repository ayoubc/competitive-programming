class Solution {
    vector<int> pre;
public:
    Solution(vector<int>& w) {
        pre.push_back(w[0]);
        for(int i=1;i<w.size();i++){
            pre.push_back(pre.back() + w[i]);
        }
    }
    
    int pickIndex() {
        int total = pre.back();
        int x = rand()%total;
        return upper_bound(pre.begin(), pre.end(), x) - pre.begin();
    }
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(w);
 * int param_1 = obj->pickIndex();
 */