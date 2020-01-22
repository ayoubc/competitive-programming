#include <bits/stdc++.h>
using namespace std;
vector<int> split(string s){
    vector<int> v;
    istringstream iss(s);
    do{
        string str;
        iss >> str;
        if(str!=""){
            stringstream ss;
            int n;
            ss << str, ss >> n;
            v.push_back(n);
        }
    }while(iss);
    return v;
}
bool isSorted(stack<int> s){
    int x = s.top();
    s.pop();
    while(!s.empty()){
        if(x>s.top()) return false;
        x = s.top();
        s.pop();
    }
    return true;
}
int main(){
    //freopen("i","r",stdin);
    //freopen("out","w",stdout);
    string s;
    while(getline(cin,s)){
        cout<<s<<endl;
        vector<int> v = split(s);
        vector<int> vs = v;
        sort(vs.rbegin(),vs.rend());
        stack<int> st;
        queue<int> q;
        vector<int> ans;
        int n = v.size();
        for(int i=v.size()-1;i>=0;i--) st.push(v[i]);
        for(int i=0;i<vs.size();++i){
            if(isSorted(st)){
                ans.push_back(0);
                break;
            }
            int x = vs[i],cnt=n;
            while(st.top()!=x){
                cnt--;
                q.push(st.top());
                st.pop();
            }
            q.push(st.top());
            st.pop();
            while(!q.empty()){
                st.push(q.front());
                q.pop();
            }
            if(cnt!=n) ans.push_back(cnt);
            cnt = n;
            x = st.top();
            st.pop();
            q.push(x);
            while(!st.empty() && x>st.top()){
                cnt--;
                q.push(st.top());
                st.pop();
            }
            while(!q.empty()){
                st.push(q.front());
                q.pop();
            }
            if(cnt!=n) ans.push_back(cnt);
        }
        /*for(int i=0;i<v.size();i++) printf("%d ",v[i]);
        printf("\n");*/
        for(int i=0;i<ans.size();i++) {
            if(i!=ans.size()-1) printf("%d ",ans[i]);
            else printf("%d\n",ans[i]);
        }
    }
    return 0;
}
