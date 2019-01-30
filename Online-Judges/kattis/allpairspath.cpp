#include <bits/stdc++.h>
using namespace std;
const int OO = 1000000000;
int n,m,q,u,v,w;
int dis[155][155];
int main(){
    // freopen("i","r",stdin);
    while(scanf("%d %d %d",&n,&m,&q)==3){
        if(n==0 && m==0 && q==0) break;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) dis[i][j] = 0;
                else dis[i][j] = OO ;
            }
        }
        for(int i=0;i<m;i++){
            scanf("%d %d %d",&u,&v,&w);
            dis[u][v] = min(w,dis[u][v]);
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dis[i][k] < OO && dis[k][j] < OO){
                        dis[i][j] = min(dis[i][j],dis[i][k]+dis[k][j]);
                    }
                }
            }
        }
        //detecting negative cycles;
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                for (int k=0;dis[i][j]!=-OO && k<n;k++){
                     if (dis[k][k]<0 && dis[i][k]!=OO && dis[k][j]!=OO ){
                        dis[i][j] = -OO;
                     }
                }
            }
        }
        while(q--){
            scanf("%d %d",&u,&v);
            if(dis[u][v] == OO) printf("Impossible\n");
            else if(dis[u][v] == -OO) printf("-Infinity\n");
            else printf("%d\n",dis[u][v]);
        }
        printf("\n");
    }
    

    return 0;
}
