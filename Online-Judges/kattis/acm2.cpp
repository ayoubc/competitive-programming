#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("i.in","r",stdin);
	int n,p;
	scanf("%d %d",&n,&p);
	int a[n];
	pair<int,int> pi[n];
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
		pi[i] = make_pair(a[i],i);
	}
	if(a[p]>300) printf("0 0\n");
	else{
		int penalty = a[p],time = a[p],cnt = 1;
		sort(pi,pi+n);
		int i = 0;
		while(i<n && time<300){
			if(pi[i].second==p) i++;
			else if(time + pi[i].first <= 300){
				time += pi[i].first;
				penalty += time;
				cnt++;
				i++;
			}
			else i++;
			
		}
		printf("%d %d\n",cnt,penalty);
	}
	return 0;
}

