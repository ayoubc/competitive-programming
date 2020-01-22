#include<bits/stdc++.h> 

using namespace std;
typedef vector<int> vi;
int a[10];
int main(){
	// freopen("i","r",stdin);
	int n,x;
	
	for(int i=0;i<10;i++){
		scanf("%d",&a[i]);
	}
	scanf("%d",&n);
	vector<vi> v(n,vi());
	for(int i=0;i<n;i++){
		for(int j=0;j<6;j++){
			scanf("%d",&x);
			v[i].push_back(x);
		}
	}
	for(int i=0;i<n;i++){
		int cnt = 0;
		for(int j=0;j<6;j++){
			for(int k=0;k<10;k++){
				if(v[i][j]==a[k])
					cnt++;
			}
		}
		if(cnt>=3){
			printf("Lucky\n");
		}
		else{
			printf("Unlucky\n");
		}
	}
} 