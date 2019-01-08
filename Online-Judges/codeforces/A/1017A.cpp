#include <bits/stdc++.h>

using namespace std;
typedef pair<int,int> pi;
bool cmp(pi p1,pi p2){
    if(p1.first==p2.first)
        return p1.second<p2.second;
    return p1.first>p2.first;
}
int main(){
//    freopen("i","r",stdin);
    int n;
    scanf("%d",&n);
    vector<pi> v(n);
    for(int i=0;i<n;i++){
        int sum=0,x;
        for(int k=1;k<=4;k++){
            scanf("%d",&x);
            sum += x;
        }
        v[i] = make_pair(sum,i+1);
    }
    sort(v.begin(),v.end(),cmp);
    for(int i=0;i<n;i++){
    	if(v[i].second==1) {
    		cout<<i+1<<endl;
    		break;
		}
//        cout<<v[i].first<<" "<<v[i].second<<endl;
    }
    return 0;
}

