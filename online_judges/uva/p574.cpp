#include <bits/stdc++.h>
using namespace std;
typedef vector<int> vi;
const int N = 13;
int a[N];
bool pick[N];
set<vi> V;
int sum,n;
void solve(int s,int i){
    if(i>n || s>sum) return;
    else if(s==sum){
        vector<int> v;
        for(int j=0;j<n;j++){
            if(pick[j]){
                v.push_back(a[j]);
            }
        }
        sort(v.rbegin(),v.rend());
        V.insert(v);
    }
    else{
        pick[i] = true;
        solve(s+a[i],i+1);
        pick[i] = false;
        solve(s,i+1);
    }
}
void printfV(){
    set<vi>::iterator it;
    vector<vi> G;
    for(it=V.begin();it!=V.end();it++){
        vector<int> v = *it;
        G.push_back(v);
    }
    for(int i=G.size()-1;i>=0;i--){
        for(int j=0;j<G[i].size();j++){
            if(j==G[i].size()-1) printf("%d\n",G[i][j]);
            else printf("%d+",G[i][j]);
        }
    }
}
int main(){
    //freopen("i","r",stdin);
    while(cin >> sum >> n){
        if(sum==0 && n==0) break;

        for(int i=0;i<n;i++) scanf("%d",&a[i]);
        //for(int i=0;i<n;i++) printf("%d ",a[i]);
        printf("Sums of %d:\n",sum);
        memset(pick,false,sizeof(pick));
        V.clear();
        solve(0,0);
        if(V.size()!=0) printfV();
        else printf("NONE\n");
    }
    return 0;
}
