#include <bits/stdc++.h>
using namespace std;
const int N = 100007;

int D[N];

int s,c,k;
int main(){
    //freopen("i","r",stdin);
    scanf("%d%d%d",&s,&c,&k);
    for(int i=0;i<s;i++) scanf("%d",D+i);

    sort(D,D+s);

    int i=0,j=0,ans=0;
    while(i<s){
        j = i;
        while(j<s && abs(D[i]-D[j])<=k && j-i+1<=c){
            j++;
        }
        i = j;
        ans ++;
    }
    printf("%d\n",ans);
    return 0;
}
