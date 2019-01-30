#include <bits/stdc++.h>
using namespace std;
struct student{
	string name;
	int rank;
	student(string _name,int _rank){
		rank = _rank, name = _name;
	}
	bool operator < (student s) const{
		if(s.name[0]==name[0]){
			if(s.name[1]==name[1]){
				return s.rank>rank;
			}
			return s.name[1]>name[1];
		}
		return s.name[0]>name[0];
	}
};
int main(){
//	freopen("i","r",stdin);
	int n;
	string name;
	while(scanf("%d",&n)==1){
		if(n==0)
			break;
			
		vector<student> v;
		for(int i=0;i<n;i++){
			cin >> name;
			v.push_back(student(name,i));
			
		}
		sort(v.begin(),v.end());
		for(int i=0;i<n;i++){
			cout<<v[i].name<<endl;
		}
		cout<<"\n";
	}
	return 0;
}

