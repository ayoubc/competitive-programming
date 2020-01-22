#include <bits/stdc++.h>

using namespace std;

int main(){
    //freopen("i","r",stdin);
    int n;
    map<string,int> mp;
    scanf("%d",&n);
    string s;
    for(int i=0;i<n;i++){
        cin >> s;
        printf("%d\n",mp[s]);
        for(int j=0;j<s.size();j++){
            mp[s.substr(0,j+1)]++;
        }
    }
    return 0;
}
