#include <bits/stdc++.h>

using namespace std;


const int N = 102;
int matrix[N][N];
int main(){
    int t;
    cin >> t;
    for(int k=1;k<=t;k++) {
        int n;
        cin >> n;
        int trace = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {

                cin >> matrix[i][j];
                trace += (i == j ? matrix[i][j] : 0);
            }
        }
        int row = 0;

        for(int i=0;i<n;i++) {
            set<int> srow;
            for(int j=0;j<n;j++) {
                if(srow.find(matrix[i][j]) != srow.end()){
                    row ++;
                    break;
                }
                srow.insert(matrix[i][j]);
            }
        }
        int col = 0;
        for(int i=0;i<n;i++) {
            set<int> scol;
            for(int j=0;j<n;j++) {
                if(scol.find(matrix[j][i]) != scol.end()){
                    col ++;
                    break;
                }
                scol.insert(matrix[j][i]);
            }
        }
        printf("Case #%d: %d %d %d\n", k ,trace, row, col);

    }
    return 0;
}
