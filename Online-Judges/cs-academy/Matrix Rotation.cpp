#include <bits/stdc++.h>

using namespace std;
typedef vector<int> vi;
void rotation90(vector<vi> a,vector<vi> &b,int n){
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			b[j][n-1-i] = a[i][j];
		}
	}
}
int main(){
	ifstream cin("i.in");
	int n;
	cin >> n;
	vector<vi> a(n,vi(n)),a9(n,vi(n)),a18(n,vi(n)),a27(n,vi(n));
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			cin >> a[i][j];
		}
		
	}
	rotation90(a,a9,n);
	rotation90(a9,a18,n);
	rotation90(a18,a27,n);
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			int b = a[i][j]|a9[i][j]|a18[i][j]|a27[i][j];
			cout<<b<<" ";
		}
		cout<<endl;
	}
	
	return 0;
}

