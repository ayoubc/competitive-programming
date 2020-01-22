#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 101;
ll A[N][N];
ll query(int i,int j,int k,int l){
    return A[k][l] - A[i-1][l] - A[k][j-1] + A[i-1][j-1];
}
int main(){
    //freopen("i.txt","r",stdin);
    //freopen("out.txt","w",stdout);
    int t,n,m,K;
    scanf("%d",&t);
    for(int ii=1;ii<=t;ii++){
        scanf("%d%d%d",&n,&m,&K);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                scanf("%lld",&A[i][j]);
                if(i>0) A[i][j] += A[i-1][j];
                if(j>0) A[i][j] += A[i][j-1];
                if(i>0 && j>0) A[i][j] -= A[i-1][j-1];
            }
        }
        ll P=0;
        int S=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                for(int k=i;k<n;k++){
                    for(int l=j;l<m;l++){
                        ll cur = A[k][l];
                        if(i>0) cur -= A[i-1][l];
                        if(j>0) cur -= A[k][j-1];
                        if(i>0 && j>0) cur += A[i-1][j-1];
                        if(cur<=K){
                            if(S<(k-i+1)*(l-j+1)){
                                S = (k-i+1)*(l-j+1);
                                P = cur;
                            }
                            else if(S==(k-i+1)*(l-j+1)) P = min(P,cur);
                            //cout<<S<<" "<<P<<endl;
                        }
                    }
                }
            }
        }

        //int k=3,l=5,i=1,j=4;
        //cout<<query(i,j,k,l)<<endl;
        printf("Case #%d: %d %lld\n",ii,S,P);
        //if(ii!=t) printf("\n");
    }
    return 0;
}
