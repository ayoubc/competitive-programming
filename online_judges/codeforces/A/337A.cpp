#include <bits/stdc++.h>

using namespace std;
int f[55];
int main()
{
    freopen("i.txt","r",stdin);
    int n,m;
    scanf("%i %i",&n,&m);
    for(int i=0;i<m;i++) scanf("%i",&f[i]);
    sort(f,f+m);
    int i=0,j = n-1;
    int ans=f[j] - f[i];
    //cout<<ans<<endl;
    while(j<m-1){
        i++;
        j++;
        //cout<<f[j]-f[i]<<endl;
        ans = min(ans,f[j]-f[i]);
    }
    printf("%i\n",ans);
    return 0;
}
