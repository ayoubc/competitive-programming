#include <bits/stdc++.h>
using namespace std;
const int L = 2000001;
char s[L];
int main(){
    //freopen("i","r",stdin);
    int l;
    while(scanf("%d",&l)==1 && l!=0){
        scanf("%s",&s);
        //printf("%s\n",s);
        int d=1e09,r=1e09,ans = 1e09;
        for(int i=0;i<l;i++){
            if(s[i]=='Z') ans=0;
            else if(s[i]=='D') d=1;
            else if(s[i]=='R'){
                ans = min(ans,d);
                d = 1e09;
            }
            else d++;
        }
        for(int i=0;s[i]!='\0';i++){
            if(s[i]=='R') r=1;
            else if(s[i]=='D'){
                ans = min(ans,r);
                r = 1e09;
            }
            else r++;
        }
        printf("%d\n",ans);
    }
    return 0;
}
