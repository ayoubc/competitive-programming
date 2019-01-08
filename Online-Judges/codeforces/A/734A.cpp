#include <bits/stdc++.h>

using namespace std;

int main()
{
    //freopen("i.in","r",stdin);
    int n;
    scanf("%d",&n);
    char s;
    int a = 0,d = 0;
    for(int i=1;i<=n;i++){
        cin>>s;
        if(s=='A') a++;
        else if(s=='D') d++;
    }
    //cout<<a<<" "<<d<<endl;
    if(a==d) printf("Friendship\n");
    else if(a>d) printf("Anton\n");
    else printf("Danik\n");
    return 0;
}
