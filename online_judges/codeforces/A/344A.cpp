#include <bits/stdc++.h>

using namespace std;

int main()
{
    //freopen("i.in","r",stdin);
    int n,ans=1;
    scanf("%d",&n);
    string s1,s2;
    cin >> s1;
    for(int i=1;i<n;i++){
        cin >> s2;
        if(s2[0]==s1[1]) ans++;
        s1 = s2;
    }
    printf("%d\n",ans);
    return 0;
}
