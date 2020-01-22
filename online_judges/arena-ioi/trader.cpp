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

    ll finNthTerm(){
        ll ans = 0;
        for(int i=0;i<N;i++){
            ans = (ans%mod + (M[0][i]%mod * firstTerms[N-1-i]%mod)%mod)%mod ;
        }
        ans = (ans + mod)%mod;
        return ans;
    }
    void printM() {
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
    //freopen("i.txt","r",stdin);
    int q;
    scanf("%d", &q);
    while(q--) {
        ll n;
        ll ans;
        for(int i=N-1;i>=0;i--) scanf("%lld", &firstTerms[i]);
        scanf("%lld", &n);
        /*for(int i=N-1;i>=0;i--) printf("%lld ", firstTerms[i]);
        printf("%lld\n", n);*/
        if(n<=3){
            ans = firstTerms[n-1];
        }
        else {
            Matrix c(tab);
            c = power(c, n-3);
            ans = c.finNthTerm();
            //c.printM();
        }
        printf("%lld\n", ans);
    }
    return 0;
}
