#include <bits/stdc++.h>
using namespace std;
typedef vector<int> vi;
const int N = 100007;
vector<vi> g;
vector<int> dis;
string a[N];
void bfs(int s){
    dis[s] = 0;
    queue<int> q;
    q.push(s);
    while(!q.empty()){
        int v = q.front();
        q.pop();
        for(int i=0;i<g[v].size();i++){
            int u = g[v][i];
            if(dis[u]==-1){
                dis[u] = 1-dis[v];
                q.push(u);
            }
        }
    }
}
int main(){
    //freopen("i","r",stdin);
    int n,m;
    map<string,int> mp;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        cin >> a[i];
        mp[a[i]] = i;
    }
    scanf("%d",&m);
    g.clear();
    g.resize(n,vi());
    dis.resize(n,-1);
    string A,B;
    for(int i=0;i<m;i++){
        cin >> A >> B;
        g[mp[A]].push_back(mp[B]);
        g[mp[B]].push_back(mp[A]);
    }
    /*for(int i=0;i<n;i++){
        cout<<i<<" : ";
        for(int k=0;k<g[i].size();k++) cout<<g[i][k]<<" ";
        printf("\n");
    }*/
    vector<vi> V(2,vi());
    for(int i=0;i<n;i++){
        if(dis[i]==-1){
            bfs(i);
        }
    }
    bool ok = true;
    for(int i=0;i<n;i++){
        bool good = true;
        for(int j=0;j<g[i].size();j++){
            int u = g[i][j];
            if(dis[i]==dis[u]) {
                good = false;
                break;
            }
        }
        if(good) V[dis[i]].push_back(i);
        else {
            ok = false;
            break;
        }
    }
    if(ok){
        for(int i=0;i<V[0].size();i++) cout<<a[V[0][i]]<<" ";
        printf("\n");
        for(int i=0;i<V[1].size();i++) cout<<a[V[1][i]]<<" ";
        printf("\n");
    }
    else printf("impossible\n");
    return 0;
}
