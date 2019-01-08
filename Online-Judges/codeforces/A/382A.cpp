//The closer you think you're, the less you will actually see.
#include <bits/stdc++.h>

using namespace std;

int main(){
//	freopen("inp.in","r",stdin);
	string s,s1,s2,w;
	int p,n,i,sz1,sz2,j;
	cin >> s;
	cin >> w;
	n = s.size()-1+w.size();
	//cout<<n<<endl;
	if(n%2!=0){
		printf("Impossible\n");
		return 0;
	}
	p = s.find("|");
	s1 = s.substr(0,p);
	
	s2 = s.substr(p+1);
//	cout<<s1<<endl;
//	cout<<s2<<endl;
	sz1 = s1.size();
	sz2 = s2.size();
	if(sz1>n/2 || sz2>n/2){
		printf("Impossible\n");
		return 0;
	}
	i = 0,j=1;
	while(i<w.size() && j<=n/2-sz1){
		s1 += w[i];
		i++;
		j++;
	}
	j = 1;
	while(i<w.size() && j<=n/2 - sz2){
		s2 += w[i];
		j++;
		i++; 
	}
	cout<<s1<<"|"<<s2<<endl;
	return 0;
}

