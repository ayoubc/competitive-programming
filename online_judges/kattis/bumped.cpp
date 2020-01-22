#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll OO = 1000000000000000007;
typedef pair<ll,ll> pi;
typedef vector<pi> vpi;

vector<vpi> g;
vector<ll> disFromS,disFromT;
vector<bool> vis;
void dijkstra(int s,vector<ll> &dis){
    dis[s] = 0;
    multiset<pi> pq;
    pq.insert(make_pair(0,s));
    while(!pq.empty()){
        pi p = *pq.begin();
        pq.erase(pq.begin());
        ll a = p.first , w,b = p.second,e;
        for(int i=0;i<g[b].size();i++){
            e = g[b][i].first , w = g[b][i].second;
            if(dis[e] > a+w){
                dis[e] = a+w;
                pq.insert(make_pair(dis[e],e));
            }
        }
    }
}
ll Min(ll a,ll b){
    return (a<b ? a:b);
}
int main(){
    freopen("i","r",stdin);
    int n,m,f,s,t,u,v;
    ll c;
    scanf("%d%d%d%d%d",&n,&m,&f,&s,&t);
    g.resize(n,vpi());
    for(int i=0;i<m;i++){
        scanf("%d%d%lld",&u,&v,&c);
        g[u].push_back(make_pair(v,c));
        g[v].push_back(make_pair(u,c));
    }
    vector<pi> flight;
    for(int i=0;i<f;i++){
        scanf("%d%d",&u,&v);
        flight.push_back(make_pair(u,v));
    }
    disFromS.resize(n,OO);
    disFromT.resize(n,OO);
    vis.resize(n,false);
    dijkstra(s,disFromS);
    vis.resize(n,false);
    dijkstra(t,disFromT);
    ll ans = OO;
    for(int i=0;i<f;i++){
        u = flight[i].first , v = flight[i].second;
        if(disFromS[u]!=OO && disFromT[v]!=OO){
            ans = Min(ans,disFromS[u]+disFromT[v]);
        }
    }
    ans = Min(ans,disFromS[t]);
    printf("%lld\n",ans);
    return 0;
}
