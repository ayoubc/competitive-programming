#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int n;
	scanf("%d",&n);
	vector<int> v(n);
	for(int i=0;i<n;i++){
		scanf("%d",&v[i]);
		
	}
	int sereja = 0, dima = 0,turn = 0,i = 0,j = n-1;
	while(i<j){
		if(turn==0){
			if(v[i]>v[j]){
				sereja += v[i];
				i++;
			}
			else{
				sereja += v[j];
				j--;
			}
			turn = 1;
		}
		else{
			if(v[i]>v[j]){
				dima += v[i];
				i++;
			}
			else{
				dima += v[j];
				j--;
			}
			turn = 0;
		}
	}
	if(turn == 0) sereja += v[i];
	else dima += v[i];
	printf("%d %d\n",sereja,dima);
	return 0;
}

