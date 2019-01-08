#include <bits/stdc++.h>

using namespace std;

int main()
{
    //freopen("i.in","r",stdin);

    int a[5][5];
    for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
            scanf("%d",&a[i][j]);
        }
    }

    for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
            if(a[i][j]==1){
                printf("%d",abs(2-i) +abs(2-j));
                return 0;
            }
        }
    }

    return 0;
}
