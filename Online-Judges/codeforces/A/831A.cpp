#include <bits/stdc++.h>

using namespace std;
int a[101];
int main() {
    //freopen("i.txt","r",stdin);
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++){
        scanf("%d",&a[i]);
    }
    int i=0,j=0,k=0;
    bool ok = true;
    while(i<n-1){
        if(a[i]<a[i+1]) i++;
        else{
            break;
        }
    }
    j = i;
    while(j<n-1){
        if(a[j]==a[j+1]) j++;
        else break;
    }
    k = j;
    while(k<n-1){
        if(a[k]>a[k+1]) k++;
        else{
            ok = false;
            break;
        }
    }
    if(ok) printf("YES\n");
    else printf("NO\n");
    return 0;
}