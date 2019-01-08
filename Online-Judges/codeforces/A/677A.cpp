#include <bits/stdc++.h>

using namespace std;

int main()
{
    //freopen("i.in","r",stdin);
    int n,h,a,sum = 0;
    scanf("%d %d",&n,&h);
    for(int i=0;i<n;i++){
        scanf("%d",&a);
        if(a>h) sum+=2;
        else sum += 1;

    }
    printf("%d\n",sum);
    return 0;
}
