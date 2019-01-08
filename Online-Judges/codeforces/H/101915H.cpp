#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
typedef pair<ll,int> pi;
const int N = 1007;
int cnt[N];
int main(){
    //freopen("i.txt","r",stdin);
    int t;
    scanf("%d",&t);
    while(t--){
        int n,k;
        scanf("%d%d",&n,&k);
        vector<pi> v;
        for(int i=0;i<n;i++){
            ll x;
            for(int j=0;j<3;j++){
                scanf("%I64d",&x);
                v.push_back(make_pair(x,i));
            }
        }
        sort(v.begin(),v.end());

        for(int i=0;i<n;i++) cnt[i] = 3;
        int cur=0;
        ll ans=0;
        for(int i=0;i<v.size();i++){
            int j = v[i].second;
            if(cur==k) break;
            if(cnt[j]>=2){
                ans += v[i].first;
                //cout<<v[i].first<<endl;
                cnt[j]--;
                cur++;
            }
        }
        printf("%I64d\n",ans);
    }
    return 0;
}
