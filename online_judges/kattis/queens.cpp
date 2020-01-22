#include <bits/stdc++.h>
using namespace std;

struct Q{
    int x,y;
    Q(int _x,int _y) : x(_x),y(_y){};

};
bool good(Q q1,Q q2){
    return (q1.x!=q2.x) && (q1.y!=q2.y) && (abs(q1.x-q2.x)!=abs(q1.y-q2.y));
}
bool OK(vector<Q> v){
    for(int i=0;i<v.size();i++){
        for(int j=0;j<v.size();j++){
            if(i==j) continue;
            if(!good(v[i],v[j])) return false;
        }
    }
    return true;
}
int main(){
    //freopen("i","r",stdin);
    int n;
    scanf("%d",&n);
    vector<Q> v;
    int x,y;
    for(int i=0;i<n;i++){
        scanf("%d%d",&x,&y);
        v.push_back(Q(x,y));
    }
    cout<<(OK(v) ? "CORRECT" : "INCORRECT")<<endl;
    return 0;
}
