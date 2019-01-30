#include <bits/stdc++.h>
using namespace std;
typedef long long ll;

ll dic(vector<int> v){
    ll x=0;
    int n = v.size();
    for(int i=n-1;i>=0;i--){
        if(v[i]==1) x |= (1<<(n-1-i));
    }
    return x;
}
bool pal(vector<int> v){
    int n= v.size();
    for(int i=0;i<v.size();i++){
        if(v[i]!=v[n-1-i]) return false;
    }
    return true;
}
set<int> s;
vector<ll> all;
void getAll(){
    for(int i=1;i<(1<<15);i++){
        vector<int> v(15,0);
        for(int j=0;j<15;j++){
            if(i&(1<<j)) v[j] = 1;
        }
        int j=0;
        while(v[j]==0) j++;
        vector<int> V;
        for(int k=j;k<v.size();k++) V.push_back(v[k]);
        if(pal(V)) s.insert(dic(V));
        vector<int> sem1 = V,sem2 = V;
        for(int j=V.size()-1;j>=0;j--) sem1.push_back(V[j]);
        for(int j=V.size()-2;j>=0;j--) sem2.push_back(V[j]);
        ll x = dic(sem1), y = dic(sem2);
        if(x>0) s.insert(x);
        if(y>0) s.insert(y);
    }
    for(set<int>::iterator it=s.begin();it!=s.end();it++){
        all.push_back(*it);
    }
}

int main(){
    //freopen("out","w",stdout);
    getAll();
    //cout<<s.size()<<endl;
    //for(int i=0;i<all.size();i++) cout<<all[i]<<endl;
    int m;
    scanf("%d",&m);
    printf("%lld\n",all[m-1]);
    return 0;
}
