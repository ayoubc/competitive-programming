#include <bits/stdc++.h>

using namespace std;
typedef pair<int,int> pi;
const int N = 50001;
char str[N];
int main() {
    //freopen("i.txt","r",stdin);
    int t;
    scanf("%d",&t);
    for(int tc=1;tc<=t;tc++) {
        int N;
        scanf("%d",&N);
        scanf("%s",str);
        for(int i=0;i<2*(N-1);i++){
            if(str[i]=='S') str[i] = 'E';
            else str[i] = 'S';
        }
        printf("Case #%d: %s\n",tc,str);
    }
    return 0;
}