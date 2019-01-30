#include <stdlib.h>
#include <stdio.h>

long long F[90];

char get(long long i,int n){
    if(n==1) return 'N';
    if(n==2) return 'A';
    long long L = F[n-2];
    if(i>L) return get(i-L,n-1);
    else return get(i,n-2);
}
int min(int a,int b){
	return (a<b ? a:b);
}
int main(){
    long long k;
    int n;

    F[1] = 1;
    F[2] = 1;
    int i;
    for(i=3;i<90;i++) F[i] = F[i-2]+F[i-1];
    //printf("%lld",F[89]);
    char ans;
    scanf("%d%lld",&n,&k);
    ans = get(k,min(n,89));
    printf("%c\n",ans);
    return 0;
}
