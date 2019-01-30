#include <bits/stdc++.h>
using namespace std;
const int N = 1007;
int id[N];
void __init(int a,int b){
    for(int i=a;i<=b;i++){
        id[i] = i;
    }
}
int root(int a){
    while(a!=id[a]){
        //id[a] = id[id[a]];
        a = id[a];
    }
    return a;
}
void Union(int a,int b){
    id[root(a)] = root(b);
}
vector<int> fact(int x,int p){
    vector<int> v;
    for(int i=2;i*i<=x;i++){
        if(x%i==0){
            if(i>=p) v.push_back(i);
            while(x%i==0) x/=i;
        }
    }
    if(x>1 && x>=p) v.push_back(x);
    return v;
}
int main(){
    //freopen("i","r",stdin);
    int A,B,P,C;
    scanf("%d",&C);
    for(int t=1;t<=C;t++){
        scanf("%d%d%d",&A,&B,&P);
        __init(A,B);
        for(int i=A;i<=B;i++){
            vector<int> v = fact(i,P);
            for(int j=i+1;j<=B;j++){
                for(int k=0;k<v.size();k++){
                    if(j%v[k]==0){
                        Union(i,j);
                        break;
                    }
                }
            }
        }
        int ans= 0;
        for(int i=A;i<=B;i++){
            if(i==id[i]) ans++;
        }
        printf("Case #%d: %d\n",t,ans);
    }

    /*vector<int> v = fact(30,3);
    for(int i=0;i<v.size();i++) cout<<v[i]<<endl;*/
    return 0;
}
