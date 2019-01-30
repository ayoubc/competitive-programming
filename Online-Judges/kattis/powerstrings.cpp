#include <bits/stdc++.h>
using namespace std;
vector<int> div(int n){
    vector<int> v;
    for(int i=1;i*i<=n;i++){
        if(n%i==0){
            v.push_back(i);
            if(i!=n/i) v.push_back(n/i);
        }
    }
    sort(v.begin(),v.end());
    return v;
}
bool Good(int cnt,string s){
    vector<string> v;
    int n = s.size(),k = n/cnt;
    for(int i=0;i<n;i+=k){
        v.push_back(s.substr(i,k));
    }
    string str = v[0];
    for(int i=1;i<v.size();i++){
        if(v[0]!=v[i]){
            return false;
        }
    }
    return true;
}
int occ[26];
int main(){
    //freopen("i","r",stdin);
    string s;
    while(cin >> s){
        if(s==".") break;
        int n = s.size();
        map<char,int> mp;
        for(int i=0;i<n;i++) mp[s[i]]++;
        int cnt = mp.begin()->second;
        vector<int> D = div(cnt);
        int ans;
        for(int i=D.size()-1;i>=0;i--){
            if(Good(D[i],s)){
                ans = D[i];
                break;
            }
        }
        /*bool ok = true;

        for(map<char,int>::iterator it=mp.begin();it!=mp.end();it++){
            if(it->second!=cnt){
                ok = false;
                break;
            }
        }
        if(n%cnt!=0) ok = false;
        if(!ok) ans = 1;
        else{

        }*/
        printf("%d\n",ans);
    }
    return 0;
}
