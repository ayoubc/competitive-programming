#include <bits/stdc++.h>

using namespace std;
typedef unsigned long long ull;
int n;
vector<ull> Tree,a;
vector<int> bit;
int level(int node){
	int cnt = 0;
	while(node>1){
		node >>= 1;
		cnt++;
	}
	return cnt;
}
void build(int p,int s,int e){
	if(s==e){
		Tree[p] = a[s];
	}
	else{
		int mid = (s+e)/2;

		build(2*p,s,mid);
		build(2*p+1,mid+1,e);
		if(bit[level(p)]==1)
			Tree[p] = Tree[2*p] ^ Tree[2*p+1];
		else
			Tree[p] = Tree[2*p] | Tree[2*p+1];
		/*if(n&1)
			Tree[p] = level(p) & 1 ? Tree[2*p]^Tree[2*p+1] : Tree[2*p]|Tree[2*p+1];
		else
			Tree[p] = level(p) & 1 ? Tree[2*p]|Tree[2*p+1] : Tree[2*p]^Tree[2*p+1];*/
	}
	
}

void update(int p,int s,int e,int index,ull b ){
	if(s==e){
		a[index] = b; 
		Tree[p] = b;
	}
	else{
		int mid = (e+s)/2;
		
		if(index<=mid){
			update(2*p,s,mid,index,b);
		}
		else{
			update(2*p+1,mid+1,e,index,b);
			
		}
		if(bit[level(p)]==1)
			Tree[p] = Tree[2*p] ^ Tree[2*p+1];
		else
			Tree[p] = Tree[2*p] | Tree[2*p+1];
		/*if(n&1)
			Tree[p] = level(p) & 1 ? Tree[2*p]^Tree[2*p+1] : Tree[2*p]|Tree[2*p+1];
		else
			Tree[p] = level(p) & 1 ? Tree[2*p]|Tree[2*p+1] : Tree[2*p]^Tree[2*p+1];*/
			
	}
}
int main(){
//	ifstream cin("i.in");
//	freopen("i.in","r",stdin);
	int m,p,t;
//	cin>>t;
//	for(int j=1;j<=t;j++){
//		cin>>n>>m;
		scanf("%d %d",&n,&m);
		ull N = (1<<n),b;
		a.clear(),a.resize(N);
		bit.clear(), bit.resize(n+1);
		bit[n] = 1;
		for(int i=n-1;i>=0;i--){
			bit[i] = bit[i+1]^1;
		}
		
		Tree.clear(), Tree.resize(4*N);
		for(int i=0;i<N;i++){
//			cin>>a[i];
			scanf("%I64d",&a[i]);
		}
		build(1,0,N-1);
//		cout<<"Output "<<j<<":\n";
		while(m--){
//			cin>>p>>b;
			scanf("%d %I64d",&p,&b);
			p--;
			update(1,0,N-1,p,b);
//			cout<<Tree[1]<<endl;
			printf("%I64d\n",Tree[1]);

		}

	//}
	
	return 0;
}

