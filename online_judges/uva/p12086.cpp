#include <bits/stdc++.h>
using namespace std;
const int N = 200001;
int a[N];
int Tree[4*N];
void build(int p,int s,int e){
    if(s==e){
        Tree[p] = a[s];
    }
    else{
        int mid = (s+e)/2;
        build(2*p,s,mid);
        build(2*p+1,mid+1,e);
        Tree[p] = Tree[2*p] + Tree[2*p+1];
    }
}
void update(int p,int s,int e,int i,int val){
    if(s==e){
        a[i] = val;
        Tree[p] = val;
    }
    else{
        int mid = (s+e)/2;
        if(s<=i && i<=mid) update(2*p,s,mid,i,val);
        else update(2*p+1,mid+1,e,i,val);
        Tree[p] = Tree[2*p] + Tree[2*p+1];
    }
}
int query(int p,int s,int e,int i,int j){
    if(i<=s && j>=e) return Tree[p];

    else if(i>e || j<s) return 0;

    else{
        int mid = (s+e)/2;
        return query(2*p,s,mid,i,j)+query(2*p+1,mid+1,e,i,j);
    }
}

int main(){
    //freopen("i","r",stdin);
    //cin.sync_with_stdio(false);
    int n,cnt=1;
    while(scanf("%d",&n)==1){
        if(n==0) break;

        for(int i=0;i<n;i++) scanf("%d",&a[i]);
        build(1,0,n-1);
        string op;
        if(cnt!=1) printf("\n");
        printf("Case %d:\n",cnt);
        cnt++;
        while(cin >> op && op!="END"){
            if(op=="S"){
                int i,val;
                scanf("%d%d",&i,&val);
                i--;
                update(1,0,n-1,i,val);
            }
            else {
                int i,j;
                scanf("%d%d",&i,&j);
                i--,j--;
                printf("%d\n",query(1,0,n-1,i,j));
            }
        }
    }
    return 0;
}
