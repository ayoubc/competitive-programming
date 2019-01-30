#include <bits/stdc++.h>
using namespace std;
const int N = 55;
int L[N];
int main(){
    //freopen("i","r",stdin);
    string s;
    cin >> s;
    int n = s.size();
   for(int i=0;i<n;i++) L[i] = 1;
    for(int i=0;i<n;i++){
        for(int j=0;j<i;j++){
            if(s[j]<s[i]) L[i] = max(L[i],1+L[j]);
        }
    }
    int ans = 0;
    for(int i=0;i<n;i++) ans = max(ans,L[i]);
    printf("%d\n",26-ans);
    return 0;
}
