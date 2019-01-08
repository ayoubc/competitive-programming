#include <bits/stdc++.h>
using namespace std;
int gcd(int a,int b){
    if(b==0) return a;
    return gcd(b,a%b);
}

inline int bsr(int l,int r,int d){
    int res = -1,mid;
    while(l<=r){
        mid = (l+r)/2;
        //cout<<mid<<endl;
        if(d%mid==0){
            res = mid;
            l = mid+1;
        }
        else if(d%mid<=d/mid) l=mid+1;
        else r = mid-1;
    }
    return res;
}
int main(){
    //freopen("i.txt","r",stdin);
    int a,b,d,l,r;
    scanf("%d%d",&a,&b);
    d = gcd(a,b);
    vector<int> div;
    for(int i=1;i*i<=d;i++){
        if(d%i==0) {
            div.push_back(i);
            if(i!=d/i) div.push_back(d/i);
        }
    }
    sort(div.rbegin(),div.rend());
    int n,res;
    scanf("%d",&n);
    while(n--){
        scanf("%d%d",&l,&r);
        res = -1;
        for(int i=0;i<div.size();i++){
            if(div[i]>=l && div[i]<=r) {
                res = div[i];
                break;
            }
        }
        printf("%d\n",res);
    }
    return 0;
}
