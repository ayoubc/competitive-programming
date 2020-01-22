#include <bits/stdc++.h>
using namespace std;
int occ[110];
char s[110];
int a[110];
bool pick[110];
int main(){
    //freopen("i.txt","r",stdin);
    int n;
    scanf("%d",&n);

    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
        occ[a[i]]++;
    }
    vector<int> nice;
    for(int i=0;i<n;i++){
        if(occ[a[i]]==1) nice.push_back(i);
    }
    bool ok = false;
    int N = nice.size();
    if(N==0){
        ok = true;
    }
    else if(N%2==0){
        ok = true;
    }
    else{
        for(int i=0;i<n;i++){
            if(occ[a[i]]>=3){
                nice.push_back(i);
                ok = true;
                break;
            }
        }
    }
    N = nice.size();
    for(int i=0;i<N/2;i++){
        s[nice[i]] = 'A';
        pick[nice[i]] = true;
    }
    for(int i=N/2;i<N;i++){
        s[nice[i]] = 'B';
        pick[nice[i]] = true;
    }
    for(int i=0;i<n;i++) {
        if(!pick[i]) s[i] = 'A';
    }
    if(ok) printf("YES\n%s\n",s);
    else printf("NO\n");
    return 0;
}
