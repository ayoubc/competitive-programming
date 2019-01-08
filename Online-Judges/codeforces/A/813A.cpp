#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pi;
const int N = 1001 , M = 1001;
int a[N];
pi period[M];
int main(){
    //freopen("i.txt","r",stdin);
    int n,m;
    scanf("%d",&n);
    for(int i=0;i<n;i++) scanf("%d",&a[i]);

    scanf("%d",&m);
    for(int i=0;i<m;i++) scanf("%d%d",&period[i].first , &period[i].second);
    sort(a,a+n);
    int t=0,cnt=n,cur=0;
    for(int i=0;i<n;i++){
        t += a[i];
        cur++;
        bool found = false;
        for(int j=0;j<m;j++){
            if(period[j].first<=t && t<=period[j].second){
                cnt-=cur;
                cur=0;
                found = true;
                break;
            }
        }
    }
    int ans;
    if(cnt==0) ans=t;
    else {
        for(int i=0;i<m;i++){
            if(period[i].first>=t){
                cnt -= cur;
                t = period[i].first;
                break;
            }
        }
        if(cnt==0) ans = t;
        else ans=-1;
    }
    printf("%d\n",ans);
    return 0;
}
