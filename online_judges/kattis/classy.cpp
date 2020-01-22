#include <bits/stdc++.h>

using namespace std;
struct P{
	string name;
	string clas;
};
bool cmp(P p1,P p2){
	if(p1.clas!=p2.clas) return p1.clas < p2.clas;
	return p1.name > p2.name;
}
string reverse(string s){
	string S = "";
	for(int i=s.size()-1;i>=0;i--){
		S+=s[i];
	}
	return S;
}
int main(){
//	freopen("i.in","r",stdin);
	int t,n,lmax,sz;
	string name,clas,s,str;
	cin >> t;
	while(t--){
		lmax = 0;
		cin >> n;
		vector<P> H(n);
		for(int i=0;i<n;i++){
			
			cin >> name >> clas >> str;
			name.replace(name.size()-1,1,"");
			H[i].name = name;
			s = "";
			int p = clas.find("-");
			while(p!=string::npos){
				clas.replace(p,1," ");
				p = clas.find("-");
			}
			istringstream iss(clas);
			do{
				string str;
				iss >> str;
				if(str=="upper") s+="3";
				if(str=="lower") s+="1";
				if(str=="middle") s+="2";
			}while(iss);
			lmax = max((int)s.size(),lmax);
			H[i].clas = s;
		}

		for(int i=0;i<n;i++){
			s = H[i].clas;
			s = reverse(s);
			sz = (int)s.size();
			for(int j=1;j<=lmax-sz;j++){
				s += "2";
			}
			H[i].clas = s;
		}
		sort(H.begin(),H.end(),cmp);
		for(int i=n-1;i>=0;i--){
//			cout<<H[i].name<<" "<<H[i].clas<<endl;
			cout<<H[i].name<<endl;
//			cout<<H[i].clas<<endl;
		}
		cout<<"==============================\n";
	}
	return 0;
}

