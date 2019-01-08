#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 2*100001;
int a[N];
int main(){
    //freopen("i.txt","r",stdin);
    int n,s;
    scanf("%d%d",&n,&s);
    for(int i=0;i<n;i++) scanf("%d",&a[i]);
    sort(a,a+n);
    ll ans = 0;
    //cout<<a[n/2]<<endl;
    if(a[n/2]>=s){
        for(int i=n/2 ; i>=0 ;i--){
            if(a[i]>=s) ans += a[i] - s;
            else break;
        }
    }
    else{

        for(int i=n/2 ; i<n ;i++){
            //cout<<a[i]<<endl;
            if(a[i]<s) ans += s - a[i];
            else break;
        }
    }
    printf("%I64d\n",ans);
    return 0;
}
