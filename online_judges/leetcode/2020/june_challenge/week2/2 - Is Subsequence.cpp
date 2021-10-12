class Solution {
public:
    bool isSubsequence(string s, string t) {
        int lastOcc = -1;
        for (int i = 0; i<s.size(); i++) {
            lastOcc = t.find(s[i], lastOcc+1);
            if(lastOcc == string::npos) return false;
        }
        
        return true;
    }
};