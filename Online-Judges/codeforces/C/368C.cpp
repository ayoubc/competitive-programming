#include<bits/stdc++.h>

using namespace std;
const int N = 100005;
char s[N];
int X[N],Y[N],Z[N];
bool ok(int n,int x,int y,int z){
	if(n<3)
		return true;
	return (x==y && y==z)||(x==y && x==z+1)||(x==z && x==y+1)||(z==y && z==x+1)||
	(x==y && z==x+1)||(x==z && y==z+1)||(y==z && x==y+1);
	
}
int main(){
	// freopen("i","r",stdin);
	int m,n,l,r,x,y,z;
	scanf("%s",&s);
	n = strlen(s);
	X[0] = (s[0]=='x');
	Y[0] = (s[0]=='y');
	Z[0] = (s[0]=='z');
	for(int i=1;i<n;i++){
		X[i] = X[i-1] + (s[i]=='x');
		Y[i] = Y[i-1] + (s[i]=='y');
		Z[i] = Z[i-1] + (s[i]=='z');
	}
	// cout<<X[n-1]<<endl;
	cin >> m;
	for(int i=0;i<m;i++){
		cin >> l >> r;
		l--,r--;
		if(l==0){
			x = X[r];
			y = Y[r];
			z = Z[r];
		}
		else{
			x = X[r] - X[l-1];
			y = Y[r] - Y[l-1];
			z = Z[r] - Z[l-1];	
		}
		if(ok(r-l+1,x,y,z)) printf("YES\n");
		else printf("NO\n");
	}
}