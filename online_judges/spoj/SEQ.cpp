//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
const int N = 11;
typedef long long int ll;
const ll MOD  = 1000000000;
ll c[N],b[N],tab[N][N];
struct Matrix{
	int dim;
	ll M[N][N];
	Matrix(int _dim,ll tab[N][N]){
		dim = _dim;
		for(int i=0;i<dim;i++){
			for(int j=0;j<dim;j++){
				M[i][j] = tab[i][j];
			}
		}
	}
	//matrice null
	Matrix(){
		memset(M,0,sizeof(M));
	}
	Matrix unity(){
		Matrix C;
		C.dim = dim;
		for(int i=0;i<dim;i++){
			for(int j=0;j<dim;j++){
				if(i==j) C.M[i][j] = 1;
				else C.M[i][j] = 0;
			} 
		}
		return C;
	}
	Matrix operator* (Matrix B){
		Matrix C;
		C.dim = B.dim;
		for(int i=0;i<B.dim;i++){
			for(int j=0;j<B.dim;j++){
				for(int k=0;k<B.dim;k++){
					//C.M[i][j] = (C.M[i][j]%MOD + ((M[i][k]%MOD) * (B.M[k][j]%MOD))%MOD)%MOD;
					//C.M[i][j] %= MOD;
					C.M[i][j] = (C.M[i][j] + (M[i][k] * B.M[k][j])%MOD)%MOD;
				}
			}
		}
		return C;
	}
	void printMatrix(){
		for(int i=0;i<dim;i++){
			for(int j=0;j<dim;j++){
				printf("%lld ",M[i][j]);
			}
			printf("\n");
		}
	}
};
Matrix power(Matrix A,int n){
	if(n==0) return A.unity();
	if(n==1) return A;
	Matrix B = power(A,n/2);
	B = B*B;
	if(n%2!=0) B = A*B;
	return B;
}
int main(){
//	freopen("i","r",stdin);
	int t;
	int n;
	scanf("%d",&t);
	while(t--){
		int k;
		scanf("%d",&k);
		for(int i=0;i<k;i++) scanf("%lld",&b[i]);
		for(int i=0;i<k;i++) scanf("%lld",&c[i]);
		scanf("%d",&n);
		for(int j=0;j<k;j++) tab[0][j] = c[j];
		for(int i=1;i<k;i++){
			for(int j=0;j<k-1;j++){
				if(i==j+1) tab[i][j] = 1;
				else tab[i][j] = 0;
			}
		}
		for(int i=1;i<k;i++) tab[i][k-1] = 0;
		/*
		for(int i=0;i<k;i++){
			for(int j=0;j<k;j++){
				printf("%d ",tab[i][j]);
			}
			printf("\n");
		}
		*/
		Matrix A(k,tab);
		Matrix C = power(A,n-1);
//		C.printMatrix();
		ll  ans = 0;
		for(int j=0;j<k;j++){
			ans = (ans + (C.M[k-1][j] * b[k-1-j])%MOD)%MOD;
			//ans = (ans%MOD + ((C.M[k-1][j]%MOD) * (b[k-1-j]%MOD))%MOD)%MOD;
		}
		printf("%lld\n",ans);
	}
	return 0;
}

