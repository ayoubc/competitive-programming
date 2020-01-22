#include <bits/stdc++.h>

using namespace std;

int main(){
	//freopen("inp.in","r",stdin);
	ios_base::sync_with_stdio(false);
	int n,ans = 0;
	cin >> n;
	string s;
	for(int i=0;i<n;i++){
		cin >> s;
		if(s=="Tetrahedron")
			ans += 4;
		else if(s=="Cube")
			ans += 6;
		else if(s=="Octahedron")
			ans += 8;
		else if(s=="Dodecahedron")
			ans += 12;
		else if(s=="Icosahedron")
			ans += 20;
			
		
	}
	printf("%d\n",ans);
	return 0;
}

