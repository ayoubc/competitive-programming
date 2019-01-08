#include<bits/stdc++.h>
using namespace std;

int gcd(int a,int b){
	if(b==0) return a;
	return gcd(b,a%b);
}


int gcd(vector<int> v){
	int res = v[0];
	for(int i=1;i<v.size();i++)
		res = gcd(v[i],res);
	return res;
}


int main(){
	// freopen("i.in","r",stdin);
	int m;
	scanf("%d",&m);
	vector<int> v(m);
	for(int i=0;i<m;i++) scanf("%d",&v[i]);


	if(v[0]!=gcd(v)) printf("-1\n");
	else{
		printf("%d\n",2*m-1);
		printf("%d ",v[0]);
		for(int i=1;i<m;i++) printf("%d %d ",v[0],v[i]);
		printf("\n");
	}



}
