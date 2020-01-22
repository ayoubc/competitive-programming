#include <bits/stdc++.h>
using namespace std;
char s[105];
bool pick[11];
bool vis[105];
int n;
int getId(char c){
    return c - '0';
}
bool check(int d){
    int cur = 0 , p = 0;
    for(int i=0;i<n;i++){
        cur+=getId(s[i]);
        if(cur==d){
            cur = 0;
            p++;
        }
        else if(cur>d) return false;
    }
    if(cur!=0) return false;
    return p>1;
}
int main(){
    //freopen("i.txt","r",stdin);
    scanf("%d",&n);
    scanf("%s",s);
    int sum = 0;
    for(int i=0;i<n;i++) sum += getId(s[i]);
    for(int i=0;i<=sum;i++){
        if(check(i)) {
            printf("YES\n");
            return 0;
        }
    }
    printf("NO\n");
    return 0;
}
