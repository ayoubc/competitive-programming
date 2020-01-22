#include <bits/stdc++.h>

using namespace std;

int main()
{
    //freopen("i.txt","r",stdin);
    int n,m;
    scanf("%d%d",&n,&m);
    vector<string> s(n), t(m);
    for(int i=0;i<n;i++) cin >> s[i];
    for(int i=0;i<m;i++) cin >> t[i];
    int q;
    scanf("%d",&q);
    while(q--) {
        int y;
        scanf("%d",&y);
        int i = (y%n == 0 ? n-1 : y%n - 1);
        int j = (y%m == 0 ? m-1 : y%m - 1);
        cout<<s[i]+t[j]<<endl;
    }
    return 0;
}
