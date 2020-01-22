#include <bits/stdc++.h>

using namespace std;
struct person{
	string fn;
	string ln;
	person(){};
	person(string _fn,string _ln):
		fn(_fn),ln(_ln){};
};
bool cmp(person p1,person p2){
	if(p1.ln==p2.ln) return p1.fn < p2.fn;
	return p1.ln < p2.ln;
}
int main(){
	ios_base::sync_with_stdio(0);
	//ifstream cin("i.txt");
	string s1,s2;
	map<string,int> mfn;
	//map<string,int> mln;
	vector<person> v;
	while(cin>>s1>>s2){
		mfn[s1]++;
		//mln[s2]++;
		v.push_back(person(s1,s2));
	}
	sort(v.begin(),v.end(),cmp);
	for(int i=0;i<v.size();i++){
		s1 = v[i].fn;
		s2 = v[i].ln;
		if(mfn[s1]>=2) cout<<s1<<" "<<s2<<"\n";
		else{
			cout<<s1<<"\n";
			
		}
	}
	return 0;
}

