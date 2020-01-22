#include <bits/stdc++.h>

using namespace std;
int vis[505][505];
int main(){
    //freopen("i","r",stdin);
    int w,h,x1,x2,y1,y2,n;
    while(cin >> w >> h >> n){
        if (w==0 && h==0 && n==0) break;

        memset(vis,0,sizeof(vis));
        for(int k=0;k<n;k++){
            cin >> x1 >> y1 >> x2 >> y2;
            for(int i=min(x1,x2);i<=max(x1,x2);i++){
                for(int j=min(y1,y2);j<=max(y1,y2);j++){
                    vis[i][j] = 1;
                }
            }
        }
        int ans = 0;
        for(int i=1;i<=w;i++)for(int j=1;j<=h;j++){
            ans += (vis[i][j]==0 ? 1:0);
        }
        if(ans==0) cout<<"There is no empty spots."<<endl;
        else if(ans==1) cout<<"There is one empty spot."<<endl;
        else cout<<"There are "<<ans<<" empty spots."<<endl;
    }
    return 0;
}
