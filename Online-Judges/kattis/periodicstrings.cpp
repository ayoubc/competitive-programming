#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
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
bool good(string s1,string s2,int k){
    int cnt=0,i=1,j=0;
    while(cnt<k){
        if(s1[(i+cnt)%k]!=s2[j+cnt]) return false;
        cnt++;
    }
    return true;
}
bool K_Periodic(string s,int k){
    vector<string> S;
    for(int i=0;i<s.size();i+=k){
        S.push_back(s.substr(i,k));
    }
    for(int i=1;i<S.size();i++){
        if(!good(S[i],S[i-1],k)) return false;
    }
    return true;
}
int main(){
    //freopen("i","r",stdin);
    string s;
    cin >> s;
    //cout<<s.size()<<endl;
    int n=s.size();
    vector<int> D = div(n);
    int ans;
    for(int i=0;i<D.size();i++){
        if(K_Periodic(s,D[i])){
            ans = D[i];
            break;
        }
    }
    printf("%d\n",ans);
    return 0;
}
