#include <bits/stdc++.h>
using namespace std;
const int N = 105;
int M[N][N];
int main(){
//	freopen("i","r",stdin);
	int n;
	while(scanf("%d",&n)==1){
		if(n==0) break;
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++) scanf("%d",&M[i][j]);
		}
		vector<int> row,column;
		for(int i=0;i<n;i++){
			int sum = 0;
			for(int j=0;j<n;j++) sum += M[i][j];
			if(sum%2!=0) row.push_back(i);
		}
		for(int j=0;j<n;j++){
			int sum = 0;
			for(int i=0;i<n;i++) sum += M[i][j];
			if(sum%2!=0) column.push_back(j);
		}
		if(row.size()==0 && column.size()==0) printf("OK\n");
		else if(row.size()==1 && column.size()==1) printf("Change bit (%d,%d)\n",row[0]+1,column[0]+1);
		else printf("Corrupt\n");
	}
	return 0;
}

