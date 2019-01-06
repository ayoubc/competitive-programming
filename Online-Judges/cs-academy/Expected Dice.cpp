#include <bits/stdc++.h>

using namespace std;

int main() {
//	freopen("i.in","r",stdin);
    int a[6],b[6];
    for(int i=0;i<6;i++){
        cin >> a[i];
    }
    for(int i=0;i<6;i++){
        cin >> b[i];
    }
    map<int,int> mp;
    for(int i=0;i<6;i++){
        for(int j=0;j<6;j++){
            mp[a[i]+b[j]]++;
        }
    }
    int k = -1,ans = 0;
    map<int,int>::iterator it;
    for(it=mp.begin();it!=mp.end();it++){
        if(k<it->second){
            ans = it->first;
            k = it->second;
        }
        else if(k==it->second){
        	ans = min(ans,it->first);
		}
    }
    cout<<ans<<endl;
    return 0;
}
