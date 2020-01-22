#include <bits/stdc++.h>

using namespace std;
map<char,int> v;
char alpha[27];
string message;
void compute(){
	for(char c = 'a';c<='z';c++){
		v[c] = c - 'a' +1;
	}
	alpha[0] = ' ';
	for(int i=1;i<=26;i++){
		alpha[i] = 'a'+i-1;
	}
}
void encryption(){
	int l = message.size();
	int u[l];
	u[0] = v[message[0]];
	for(int i=1;i<l;i++){
		u[i] = v[message[i]] + u[i-1];
	}
	for(int i=0;i<l;i++){
		printf("%c",alpha[u[i]%27]);
	}
	printf("\n");
}
void decreption(){
	int l = message.size();
	int d[l];
	d[0] = v[message[0]];
	for(int i=1;i<l;i++){
		d[i] = v[message[i]] - v[message[i-1]]; 
		d[i] = (d[i]+27)%27;
	}
	for(int i=0;i<l;i++){
		printf("%c",alpha[d[i]]);
	}
	printf("\n");
}
int main(){
	//freopen("i.in","r",stdin);
	compute();
	int n;
	char c;
	
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		cin>>c;
		cin.ignore();
		getline(cin,message);
		if(c == 'e'){
			encryption();
		}
		else{
			decreption();
		}
	}
	return 0;
}

