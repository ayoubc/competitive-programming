#include <bits/stdc++.h>

using namespace std;
typedef pair<double,double> pd;
struct edge{
    double w;
    int  u,v;
    edge (int _u, int _v, double _w) { u = _u, v = _v, w = _w;}
    bool operator < (edge e) const { return w > e.w; }
};
typedef vector<edge> ve; 
double carre(double x){
    return x*x;
}
int main(){
//  freopen("i","r",stdin);
    int t,n,u,v;
    double w;
    string s;
    scanf("%d",&t);
    while(t--){
        
        scanf("%d",&n);
        vector<pd> V(n);
        for(int i=0;i<n;i++){
            cin >> V[i].first >> V[i].second;
        }
        //construct the graph;
        vector<ve> g(n,ve());
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                double dis = carre(V[i].first - V[j].first) + carre(V[i].second - V[j].second);
                g[i].push_back(edge(i,j,sqrt(dis)));
            }
        }
        priority_queue<edge> q;
        vector<bool> chosen(n,false);
        double sum = 0.0;
        chosen[0] = true;
        for (int i=0;i<g[0].size();i++) q.push(g[0][i]);
        while (!q.empty()){

            edge e = q.top(); q.pop();
            u = e.u;
            v = e.v;
            w = e.w;

            if (chosen[u] && chosen[v]) continue;
            if (chosen[u]){
                for (int i=0;i<g[v].size();i++) q.push(g[v][i]);
            }
            if (chosen[v]){
                for (int i=0;i<g[u].size();i++) q.push(g[u][i]);
            }

            chosen[u] = chosen[v] = true;
            sum += w;
        }
        printf("%.3f\n",sum);
    }
    
    return 0;
}


