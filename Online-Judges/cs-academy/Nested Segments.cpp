#include <bits/stdc++.h>

using namespace std;

int main(){
//	ifstream cin("i.in");
	int n;
	cin >> n;
	int l[n],r[n];
	for(int i=0;i<n;i++){
		cin >> l[i] >> r[i];
	}
	int cnt = 0;
	for(int i=0;i<n;i++){
		for(int j=i+1;j<n;j++){
//			if(i==j) continue;
			if(l[i]>l[j] && r[i]<r[j]){
				cnt++;
				break;
			}
		}
	}
	cout<<cnt<<endl;
	return 0;
}

