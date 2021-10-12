class Solution {
    static bool cmp(vector<int> a, vector<int> b){
        if (a[0] == b[0]) return a[1] < b[1];
        return a[0] < b[0];
    }
public:
    vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
        sort(people.begin(), people.end(), cmp);
        int n = people.size();
        vector<vector<int>>  ans(n, vector<int>());
        for(int i=0;i<n;i++){
            int k = people[i][1];
            for(int j=0;j<n;j++){
                if (k == 0 && ans[j].size() == 0){
                    ans[j] = people[i];
                    break;
                }
                if (ans[j].size() != 0 && ans[j][0]>=people[i][0]) k--;
                if (k != 0 && ans[j].size() == 0) k--;
            } 
        }
        return ans;
    }
};