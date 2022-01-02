#include <iostream>

using namespace std;

const int OO = 1e18;
int n, m;
const int MAXN = 1001;
int grid[MAXN][MAXN];
bool vis[MAXN][MAXN];
int cnt;
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

bool valid(int i, int j, int s){
    return i >= 0 && i < n && j >= 0  && j < m && grid[i][j] == s && s && !vis[i][j];
}

void dfs(int i, int j, int curs) {
    vis[i][j] = true;
    cnt ++;
    for(int k=0;k<4;k++) {
        int I = dx[k] + i;
        int J = dy[k] + j;
        if(valid(I, J, curs)) dfs(I,J,curs);
    }
}


int main(){
    cin >> n >> m;
    for(int i=0;i<n;i++) {
        for (int j=0;j<m;j++) {
            cin >> grid[i][j];
        }
    }
    int lows = OO;
    int maxb = 0;
    for(int i=0;i<n;i++) {
        for (int j=0;j<m;j++) {
            if(!vis[i][j]) {
                cnt = 0;
                dfs(i, j, grid[i][j]);
                if(maxb == cnt) {
                    lows = min(lows, grid[i][j]);
                }
                else if (maxb < cnt) {
                    lows = grid[i][j];
                    maxb = cnt;
                }
            }
        }
    }

    cout << lows << " " << maxb << endl;
    return 0;
}
