#include <stdio.h>

int arr[50005],sum[50005],mod[1000005];
int main(){
    // freopen("i","r",stdin);
    int c,n,d,i;
    scanf("%d",&c);
    while(c--){
        scanf("%d %d",&d,&n);
        for(i=0;i<d;i++)
            mod[i] = 0;
        mod[0]++;
        for(i=0;i<n;i++){
            scanf("%d",&arr[i]);
            if(i==0) sum[i] = arr[i]%d;
            else sum[i] = (arr[i]+sum[i-1])%d;
            mod[sum[i]]++;
        }
        int cnt = 0;
        for(i=0;i<d;i++){
            cnt += mod[i]*(mod[i]-1)/2;
            // cout<<mod[i]<<" ";
        }
        // cout<<"\n";
        printf("%d\n",cnt);
    }
    
    return 0;
}