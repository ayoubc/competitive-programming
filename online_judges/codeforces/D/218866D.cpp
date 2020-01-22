#include <bits/stdc++.h>
using namespace std;
typedef long long ll; 

int main(){
//	freopen("i","r",stdin);
	int n;
	ll sum = 0;
	scanf("%d",&n);
	vector<ll> v(n);
	vector<ll> neg,pos;
	for(int i=0;i<n;i++){
		scanf("%I64d",&v[i]);
		if(v[i]>=0){
			sum += v[i];
			pos.push_back(v[i]);
		}
		else{
			neg.push_back(v[i]);
		}
	}
	sort(neg.rbegin(),neg.rend());
	sort(pos.begin(),pos.end());
//	cout<<sum<<endl;
	bool flagneg = false,flagpos = false;
	ll subneg,subpos;
//	sum1 = sum;
	if(sum%2==0){
		for(int i=0;i<neg.size();i++){
			if(neg[i]%2!=0){
				subneg = neg[i];
				flagneg = true;
				break;
			}
		}
		for(int i=0;i<pos.size();i++){
			if(pos[i]%2!=0){
				subpos = pos[i];
				flagpos = true;
				break;
			}
		}
		if(flagpos && flagneg){
			sum = max(sum+subneg,sum-subpos);
		}
		else{
			if(flagneg)
				sum += subneg;
			else if(flagpos)
				sum -= subpos;
		}
	}
	printf("%I64d\n",sum);
	return 0;
}

