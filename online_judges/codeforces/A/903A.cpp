#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    scanf("%d",&n);
    while(n--){
        int x;
        scanf("%d",&x);
        bool ok = false;
        for(int a=0;a<=x;a++){
            for(int b=0;b<=x;b++){
                if(a*3+b*7==x){
                    ok = true;
                    break;
                }
            }
        }
        if(ok) puts("YES");
        else puts("NO");
    }
    return 0;
}
