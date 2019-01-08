#include <bits/stdc++.h>

using namespace std;

int main()
{
    //freopen("i.in","r",stdin);
    int n,ans = 0,sum;
    int a1,a2,a3;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        sum = 0;
        scanf("%d %d %d",&a1,&a2,&a3);
        sum = a1+a2+a3;
        if(sum>=2) ans++;
    }
    printf("%d\n",ans);
    return 0;
}
