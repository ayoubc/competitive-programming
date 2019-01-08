#include <bits/stdc++.h>

using namespace std;

int main(){
    //freopen("i","r",stdin);
    //freopen("o","w",stdout);
    /*string s;
    while(cin >> s){
        string ans = "";
        int i=0;
        while(i<(int)s.size()){
            if(s[i]=='['){
                int j=i+1;
                string cur = "";
                while(j<s.size() && s[j]!='[' && s[j]!=']'){
                    cur += s[j];
                    j++;
                }
                ans = cur + ans;
                i = j;
            }
            else if(s[i]==']'){
                int j=i+1;
                string cur = "";
                while(j<s.size() && s[j]!='[' && s[j]!=']'){
                    cur += s[j];
                    j++;
                }
                ans = ans + cur;
                i = j;
            }
            else {
                ans += s[i];
                i++;
            }
        }
        cout<<ans<<endl;
    }*/
    string s;
    while(cin >> s){
        string cur = "";
        deque<string> dq;
        bool right = true;
        for(int i=0;i<s.size();i++){
            if(s[i]=='['){
                if(right) dq.push_back(cur);
                else dq.push_front(cur);
                right = false;
                cur = "";
            }
            else if(s[i]==']'){
                if(right) dq.push_back(cur);
                else dq.push_front(cur);
                right = true;
                cur = "";
            }
            else cur += s[i];
        }
        if(right) dq.push_back(cur);
        else dq.push_front(cur);
        while(!dq.empty()){
            cur = dq.front();dq.pop_front();
            cout<<cur;
        }
        cout<<endl;
    }
    return 0;
}
