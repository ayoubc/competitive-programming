#include <bits/stdc++.h>

using namespace std;
char s[1005];
int occ[26];
int main(){
    scanf("%s",&s);
    int n = strlen(s);
    for(int i=0;i<n;i++){
        occ[s[i]-'a'] ++;
    }
    int odd=0;
    for(int i=0;i<26;i++){
        if(occ[i]==0) continue;
        if(occ[i]%2!=0) odd++;
    }
    string ans;
    int it = 0;
    while(true){
        if(odd==1 && n%2!=0) break;
        if(odd==0 && n%2==0) break;
        it++;
        odd--;
        n--;
    }
    if(it%2==0) ans = "First";
    else ans = "Second";
    cout<<ans<<endl;
    return 0;
}
