#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int n;
	scanf("%d",&n);
	int before[n],after[n];
	
	for(int i=0;i<n;i++){
		scanf("%d %d",&before[i],&after[i]);
		
	}
	
	for(int i=0;i<n;i++){
		if(before[i]!=after[i]){
			printf("rated\n");
			return 0;
		}
	}
	for(int i=0;i<n-1;i++){
		if(before[i]<before[i+1]){
			printf("unrated\n");
			return 0;
		}
	}
	printf("maybe\n");
	return 0;
}

