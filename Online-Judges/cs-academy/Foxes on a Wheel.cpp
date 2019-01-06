#include <bits/stdc++.h>

using namespace std;
int binary(vector<int> v,int val){
	int l,r,mid;
	l = 0;
	r = v.size()-1;
	while(l<r){
		mid = (l+r)/2;
		if(v[mid]==val)
			return mid;
		else if(v[mid]>val)
			l = mid+1;
		else r = mid-1; 
	}
	return -1;
}
int main(){
//	freopen("i.in","r",stdin);
	int n,k;
	cin >> n >> k;
	vector<int> h(k),f(k);
	vector<int> seen(n+1,false);
	for(int i=0;i<k;i++){
		cin >> f[i];
	}
	for(int i=0;i<k;i++){
		cin >> h[i];
	}
//	sort(f.begin(),f.end());
	sort(h.begin(),h.end());
	int ans = 0,j,J;
	for(int i=0;i<k;i++){
		j = binary(h,f[i]+1);
		J = binary(h,f[i]-1);
		if(j!=-1 && !seen[h[j]]){
			seen[h[j]] = true;
			ans ++;
		}
		else if(J!=-1 && !seen[h[J]]){
			seen[h[J]] = true;
			ans++;
		}
		
	}
	cout<<(k-ans)*2+ans-1<<endl;
	return 0;
}

