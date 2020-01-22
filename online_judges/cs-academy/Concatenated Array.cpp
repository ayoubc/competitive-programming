#include <bits/stdc++.h>

using namespace std;
int firstone,lastone;
int leading_zeros(string s){
    int cnt =0,i=0;
    while(s[i]=='0' && i<s.size()){
        i++;
        cnt++;
    }
    firstone = i;
    return cnt;
}
int back_zeros(string s){
    int cnt = 0 ,i = s.size()-1;
    while(s[i]=='0' && i>=0){
        i--;
        cnt++;
    }
    lastone = i;
    return cnt;
}
int main() {
//	freopen("i.in","r",stdin);
    string s;
    long long n,k;
	int ans,F,B;
    cin >> n >> k;
    cin >> s;
    ans = 0;
//    lastone = -1;
    F = leading_zeros(s);
    B = back_zeros(s);
	if(lastone==-1) cout<<n*k<<endl;
	else{
		while(firstone<lastone){
    		if(s[firstone+1]=='0'){
    			int i = firstone+1,cnt = 0;
    			while(i<lastone && s[i]=='0'){
    				i++;
    				cnt++;
				}
				ans = max(ans,cnt);
				firstone = i;
			}
			else{
				firstone++;
			}
		}
//		cout<<F<<endl;
//		cout<<B<<endl;
//		cout<<ans<<endl;
		if(k==1){
			cout<<max(ans,max(F,B))<<endl;
		}
		else{
			cout<<max(ans,F+B)<<endl;
		}
	}
    
}
