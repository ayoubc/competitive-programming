#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("input","r",stdin);
	int n ;
	long long score,ans;
	scanf("%d",&n);
	int h[n];
	for(int i=0;i<n;i++){
		scanf("%d",&h[i]);
	}
	ans = h[0];
	score = 0;
	for(int i=0;i<n-1;i++){
		if(score+h[i] - h[i+1]<0){
			ans += h[i+1] - h[i] - score;
			score = 0;
		}
		else
			score += h[i] - h[i+1];
	}
	printf("%d\n",ans);
	return 0;
	
}

