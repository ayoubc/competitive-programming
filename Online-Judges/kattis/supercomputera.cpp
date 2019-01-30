#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 1000005;

int BIT[N],a[N];
int n;
void update(int x,int val){
    int k;
    while(x<=n){
        BIT[x] += val;
        k = x&-x;
        x += k;
    }
}
int sum(int x){
    int ans = 0;
    int k;
    while(x>=1){
        ans += BIT[x];
        k = x&-x;
        x -= k;
    }
    return ans;
}
int main(){
    //freopen("i","r",stdin);
    int k,l,r,i;
    scanf("%d%d",&n,&k);
    memset(a,0,sizeof(a));
    memset(BIT,0,sizeof(BIT));
    char c;
    while(k--){
        cin >> c;
        if(c=='F'){
            cin >> i;
            if(a[i]==0){
                a[i] = 1;
                update(i,1);
            }
            else{
                a[i] = 0;
                update(i,-1);
            }
        }
        else {
            cin >> l >> r;
            int ans = (l==1 ? sum(r) : sum(r)-sum(l-1));
            printf("%d\n",ans);
        }
    }
    return 0;
}
