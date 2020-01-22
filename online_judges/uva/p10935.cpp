#include <bits/stdc++.h>
using namespace std;

int main(){
//	freopen("i","r",stdin);
	int n;
	while(scanf("%d",&n)==1){
		if(n==0) break;
		if(n==1){
			printf("Discarded cards:\n");
			printf("Remaining card: 1\n");
		}
		else{
			queue<int> q;
			for(int i=1;i<=n;i++) q.push(i);
			vector<int> disc;
			while(q.size()!=1){
				disc.push_back(q.front());
				q.pop();
				int x = q.front();q.pop();
				q.push(x);
			}
			printf("Discarded cards: ");
			for(int i=0;i<disc.size();i++){
				if(i==disc.size()-1) printf("%d\n",disc[i]);
				else printf("%d, ",disc[i]);
			}
			printf("Remaining card: %d\n",q.front());
		}
	}
	return 0;
}

