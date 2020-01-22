#include <bits/stdc++.h>
using namespace std;
const int N = 1000007;
int a[N];
int main(){
    //freopen("i","r",stdin);
    int n;
    scanf("%d",&n);
    for(int i=0;i<n;i++) scanf("%d",a+i);
    vector<int> GIS;
    GIS.push_back(a[0]);
    int cur = GIS[0];
    for(int i=1;i<n;i++){
        if(a[i]>cur){
            cur = a[i];
            GIS.push_back(a[i]);
        }
    }
    printf("%d\n",GIS.size());
    for(int i=0;i<GIS.size();i++) printf("%d ",GIS[i]);

    return 0;
}
