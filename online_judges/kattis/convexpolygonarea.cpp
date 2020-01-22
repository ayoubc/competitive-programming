#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> p;
const int M = 107;
int cross(p p1,p p2){
    return p1.first*p2.second - p1.second*p2.first;
}
p dif(p p1, p p2){
    p P;
    P.first = p1.first - p2.first;
    P.second = p1.second - p2.second;
    return P;
}
p a[M];
int main(){
    //freopen("i","r",stdin);
    int n,m;
    scanf("%d",&n);
    while(n--){
        scanf("%d",&m);
        for(int i=0;i<m;i++){
            scanf("%d%d",&a[i].first , &a[i].second);
        }
        int sum = 0;
        for(int i=1;i<m-1;i++){
            sum += cross(dif(a[i],a[0]),dif(a[i+1],a[0]));
        }
        double ans = sum*1.0/2.0;
        printf("%.1f\n",ans);
    }
    return 0;
}
