#include <bits/stdc++.h>
using namespace std;
typedef vector<int> vi;
const int N = 1000005;
char s[N] , ss[105];
int getId(char c){
    if(c>='a') return c-'a'+26;
    return c-'A';
}
int main(){
    //freopen("i.txt","r",stdin);
    scanf("%s",&s);
    int n = strlen(s);
    vector<vi> ids(52,vi());
    for(int i=0;i<n;i++){
        ids[getId(s[i])].push_back(i);
    }
    int q,prev,S;
    scanf("%d",&q);
    for(int tc=1;tc<=q;tc++){
        scanf("%s",&ss);
        int m = strlen(ss);
        if(ids[getId(ss[0])].size()==0) printf("Not matched\n");
        else{
            S = prev = ids[getId(ss[0])][0];
            bool ok = true;
            for(int j=1;j<m;j++){
                int cur = getId(ss[j]) , k = ids[cur].size();
                int index = upper_bound(ids[cur].begin(),ids[cur].end(),prev) - ids[cur].begin();
                if(index==k){
                    ok = false;
                    break;
                }
                else{
                    prev = ids[cur][index];
                }
            }
            if(ok) printf("Matched %d %d\n",S,prev);
            else printf("Not matched\n");
        }
        //if(tc!=q) printf("\n");
    }
    return 0;
}
