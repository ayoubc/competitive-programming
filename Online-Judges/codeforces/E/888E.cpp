#include <bits/stdc++.h>
#define all(c) c.begin(),c.end()

using namespace std;
const int MXN = 36;
int n,m , a[MXN];
set<int> s1,s2;
int main(){
    //freopen("i.txt","r",stdin);
    scanf("%d%d",&n,&m);
    for(int i=0;i<n;i++) scanf("%d",a+i);

    int h = n/2;
    for(int i=0;i<(1<<h);i++){
        int sum = 0;
        for(int j=0;j<h;j++){
            if(i&(1<<j)) sum = (sum%m + a[j]%m)%m;
        }
        s1.insert(sum);
    }
    int H = n - h;
    for(int i=0;i<(1<<H);i++){
        int sum = 0;
        for(int j=0;j<H;j++){
            if(i&(1<<j)) sum = (sum%m + a[j+h]%m)%m;
        }
        s2.insert(sum);
    }
    /*for(set<int>::iterator it=s1.begin();it!=s1.end();it++){
        printf("%d ",*it);
    }
    printf("\n");
    for(set<int>::iterator it=s2.begin();it!=s2.end();it++){
        printf("%d ",*it);
    }
    printf("\n");*/
    int ans=0;
    for(set<int>::iterator it=s1.begin();it!=s1.end();it++){
        int x = *it,res=0;
        set<int>::iterator ii = s2.lower_bound(m-1-x);
        if(ii==s2.end() || *ii!=m-1-x){
            ii--;
        }
        res = *ii;
        //printf("%d %d\n",x,res);
        ans = max(ans,res+x);
        /*for(set<int>::iterator iit=s2.begin();iit!=s2.end();iit++){
            ans = max(ans,(*it+*iit)%m);
        }*/
    }
    printf("%d\n",ans);
    return 0;
}
