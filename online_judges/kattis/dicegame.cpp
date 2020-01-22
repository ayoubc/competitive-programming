#include <bits/stdc++.h>
using namespace std;

vector<int> f(int a1,int b1,int a2,int b2){
    vector<int> v;
    set<int> s;
    for(int i=a1;i<=b1;i++){
        for(int j=a2;j<=b2;j++){
            s.insert(i+j);
        }
    }
    for(set<int>::iterator it=s.begin();it!=s.end();it++) v.push_back(*it);
    return v;
}

int main(){
    //freopen("i.txt","r",stdin);
    //freopen("out.txt","w",stdout);
    int ea1,eb1,ea2,eb2,ga1,gb1,ga2,gb2;
    scanf("%d%d%d%d",&ga1,&gb1,&ga2,&gb2);
    scanf("%d%d%d%d",&ea1,&eb1,&ea2,&eb2);

    vector<int> ev = f(ea1,eb1,ea2,eb2), gv = f(ga1,gb1,ga2,gb2);
    int eres=0,gres=0;
    for(int i=0;i<gv.size();i++){
        gres += upper_bound(ev.begin(),ev.end(),gv[i]) - ev.begin();
    }
    for(int i=0;i<ev.size();i++){
        eres += upper_bound(gv.begin(),gv.end(),ev[i]) - gv.begin();
    }
    if(eres==gres) printf("Tie\n");
    else if(eres<gres) printf("Gunnar\n");
    else printf("Emma\n");
    //cout<<eres<<" "<<gres<<endl;
    return 0;
}
