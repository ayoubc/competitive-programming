#include <bits/stdc++.h>

using namespace std;

int main() {
    int n,k,cnt=0;
    scanf("%d %d",&n,&k);
    int a[n];
    bool ok;
    for(int i=0;i<n;i++) scanf("%d",&a[i]);
    for(int i=0;i<n;i++){
        ok = true;
        for(int j=0;j<n;j++){
        	if(i==j) continue;
            if(abs(a[i]-a[j])<=k){
                ok = false;
                break;
            }
        }
        if(ok) cnt++;
    }
    printf("%d\n",cnt);
    return 0;
}