#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int main(){
    //freopen("i","r",stdin);
    int n;
    scanf("%d",&n);
    string a,b;
    cin >> a;
    cin >> b;
    ll z = 0,o = 0,Zero=0,One=0;
    for(int i=0;i<n;i++){
        if(a[i]=='1') o++;
        else z++;

        if(a[i]=='0' && b[i]=='0') Zero++;
        else if(a[i]=='1' && b[i]=='0') One++;
    }
    ll ans = Zero*o + One*z - Zero*One;
    printf("%I64d\n",ans);
    return 0;
}
