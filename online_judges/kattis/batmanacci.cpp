#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
ll F[90];
/*const int N = 2;
ll M[N][N] = {{1,1},{1,0}};
struct matrix{
    ll M[N][N];
    matrix(){
        memset(M,0,sizeof(M));
    }
    matrix(ll _M[N][N]){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                M[i][j] = _M[i][j];
            }
        }
    }
    matrix operator * (matrix B){
        matrix C;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++) C.M[i][j] = C.M[i][j] + M[i][k]*B.M[k][j];
            }
        }
        return C;
    }
    void printM(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) printf("%d ",M[i][j]);
            printf("\n");
        }
    }
};
matrix power(matrix a,int n){
    if(n==1) return a;
    matrix b = power(a,n/2);
    b = b*b;
    if(n%2!=0) b = b*a;
    return b;
}
ll F(int n){
    if(n==1 || n==2) return 1;
    matrix A = matrix(M);
    matrix C = power(A,n-2);
    return C.M[0][0] + C.M[0][1];
}*/

char get(ll i,int n){
    if(n==1) return 'N';
    if(n==2) return 'A';
    ll L = F[n-2];
    if(i>L) return get(i-L,n-1);
    else return get(i,n-2);
}
int main(){
    //freopen("i","r",stdin);
    ll k;
    int n;

    F[1] = 1;
    F[2] = 1;
    for(int i=3;i<90;i++) F[i] = F[i-2]+F[i-1];
    //printf("%lld",F[89]);
    char ans;
    scanf("%d%lld",&n,&k);
    if(n>89) ans = get(k,89);
    else ans = get(k,n);
    printf("%c\n",ans);
    return 0;
}
