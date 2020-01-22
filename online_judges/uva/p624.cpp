#include <bits/stdc++.h>
using namespace std;
const int N = 21;
int a[N];
bool pick[N];
vector<int> v;
int sum,newSum,n;
void maxCan(int s,int i){
    if(s>sum) return;
    if(i==n){
        newSum = max(newSum,s);
    }
    else{
        pick[i] = true;
        maxCan(s+a[i],i+1);
        pick[i] = false;
        maxCan(s,i+1);
    }
}
void solve(int s,int i){
    if(i>n || s>newSum) return;
    else if(s==newSum){
        for(int j=0;j<n;j++){
            if(pick[j]){
                v.push_back(a[j]);
            }
        }
        return;
    }
    else{
        pick[i] = true;
        solve(s+a[i],i+1);
        pick[i] = false;
        solve(s,i+1);
    }
}

int main(){
    //freopen("i","r",stdin);
    while(scanf("%d%d",&sum,&n)==2){
        //cout<<sum<<" "<<n<<endl;
        for(int i=0;i<n;i++) scanf("%d",&a[i]);
        memset(pick,false,sizeof(pick));
        newSum = 0;
        maxCan(0,0);
        v.clear();
        for(int i=0;i<(1<<n);i++){
            int cur = 0;
            for(int j=0;j<n;j++){
                if(i&(1<<j)) cur += a[j];
            }
            if(cur==newSum){
                //cout<<cur<<endl;
                for(int j=0;j<n;j++){
                    if(i&(1<<j)){
                        v.push_back(a[j]);
                    }
                }
                break;
            }
        }
        for(int i=0;i<v.size();i++) printf("%d ",v[i]);
        printf("sum:%d\n",newSum);
    }
    return 0;
}
