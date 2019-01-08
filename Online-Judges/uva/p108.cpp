#include <bits/stdc++.h>
using namespace std;

const int N = 101 , OO = 1e09;
int m[N][N];
int main(){
    //freopen("i.txt","r",stdin);
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++)for(int j=0;j<n;j++){
        scanf("%d",&m[i][j]);
        if(i>0) m[i][j] += m[i-1][j];
        if(i>0) m[i][j] += m[i][j-1];
        if(i>0 && j>0) m[i][j] -= m[i-1][j-1];
    }
    int ans = -OO;
    for(int i=0;i<n;i++)
        for(int j=0;j<n;j++)
            for(int k=i;k<n;k++)
                for(int l=j;l<n;l++){
                    int cur = m[k][l];
                    if(i>0) cur -= m[i-1][l];
                    if(j>0) cur -= m[k][j-1];
                    if(i>0 && j>0) cur += m[i-1][j-1];

                    ans = max(cur,ans);
                }
    printf("%d\n",ans);
    return 0;
}
