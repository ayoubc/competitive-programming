#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
const ll mod = 1e09+7;
const int N = 3;
ll tab[N][N] = {{28,-175,300}, {1,0,0}, {0,1,0}};
ll firstTerms[N];
struct Matrix {
    ll M[N][N];
    Matrix(ll tab[N][N]){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) M[i][j] = tab[i][j];
        }
    }

    Matrix operator * (Matrix const &b) {
        Matrix c(M);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c.M[i][j] = 0;
                for (int k = 0; k < 3; k++){
                    c.M[i][j] = (c.M[i][j]%mod + (M[i][k]%mod * b.M[k][j]%mod)%mod + mod)%mod;
                }
            }
        }
        return c;
    }

    ll findNthTerm(){
        ll ans = 0;
        for(int i=0;i<N;i++){
            ans = (ans%mod + (M[0][i]%mod * firstTerms[N-1-i]%mod)%mod)%mod ;
        }
        ans = (ans + mod)%mod;
        return ans;
    }
    void printMatrix() {
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) printf("%lld ", M[i][j]);
            printf("\n");
        }
    }

};

Matrix power(Matrix a, ll n){
    if(n==1){
        return a;
    }
    Matrix b = power(a , n/2);
    b = b*b;
    if(n%2 != 0){
        b = b * a;
    }
    return b;
}
int main(){
    Matrix c(tab);
    int n = 10;
    c = power(c, n);
    c.printMatrix();
    return 0;
}
