#include <bits/stdc++.h>
#define pb push_back
using namespace std;
typedef vector<int> vi;


using namespace std;
vector<int>e[111];
int used[111],cnt,cnt2;

//to detecte cycles
// if cnt2 * 2==cnt then there is a cycle of lengh cnt2 vertex
// and if cnt2%2==1 then it is a cycle with odd number of vertices
void dfs(int x){
    used[x]=1;
    cnt+=e[x].size();
    cnt2++;
    for(int i=0;i<e[x].size();i++)
        if(used[e[x][i]]==0)dfs(e[x][i]);
}
int main(){
	//freopen("inp.in","r",stdin);
    int i,j,k,n,m,stop=0;
    scanf("%d%d",&n,&m);
    for(i=0;i<m;i++){
        int x,y;
        scanf("%d%d",&x,&y);
        e[x].pb(y);
        e[y].pb(x);
    }
    for(i=1;i<=n;i++){
        if(!used[i]){
            cnt=0;
            cnt2=0;
            dfs(i);
            if(cnt2%2==1&&cnt2*2==cnt){
                stop++;
            }
        }
    }
    printf("%d\n",stop+(n-stop)%2);
    return 0;
}

