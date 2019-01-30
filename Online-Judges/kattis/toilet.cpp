#include <bits/stdc++.h>
using namespace std;
char p[1001];
int main(){

    //freopen("i.txt","r",stdin);
    scanf("%s",&p);
    int n = strlen(p) ,ans1=0,ans2=0,ans3=0;
    for(int i=1;i<n;i++){
        if(p[i]!=p[i-1]) ans3++;
        if(i==1){
            if(p[0]=='U'){
                ans2++;
                if(p[1]=='D')ans1+=2;
            }
            else if(p[0]=='D'){
                ans1++;
                if (p[1]=='U')ans2+=2;
            }
        }
        else{
            if(p[i]=='U') ans2+=2;
            else ans1+=2;
        }
    }
    printf("%d\n%d\n%d",ans1,ans2,ans3);
    return 0;
}
