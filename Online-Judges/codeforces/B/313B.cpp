#include<bits/stdc++.h>

using namespace std;
const int N = 100007;
char s[N];
int ans[2][N];
int query(int i, int j) {
    return ans[0][j] + ans[1][j] - ans[0][i] - ans[1][i];
}
int main() {
    //freopen("i.txt","r",stdin);
    scanf("%s",&s);
    int n = strlen(s);
    int m;
    ans[0][0] = 0;
    ans[1][0] = 0;
    for(int i=1;i<n;i++){
        if(s[i-1]==s[i]){
            if(s[i]=='.'){
                ans[0][i] += ans[0][i-1]+1;
                ans[1][i] = ans[1][i-1];
            }
            else{
                ans[1][i] += ans[1][i-1]+1;
                ans[0][i] = ans[0][i-1];
            }
        }
        else{
            ans[1][i] = ans[1][i-1];
            ans[0][i] = ans[0][i-1];
        }
    }
    scanf("%d",&m);
    for(int i=0;i<m;i++){
        int l,r;
        scanf("%d%d",&l,&r);
        l--,r--;
        printf("%d\n",query(l, r));
    }
    /*for(int i=0;i<n;i++){
        printf("%d",ans[0][i]);
        if(i!=n-1) printf(" ");
        else printf("\n");
    }
    for(int i=0;i<n;i++){
        printf("%d",ans[1][i]);
        if(i!=n-1) printf(" ");
        else printf("\n");
    }*/
    return 0;
}