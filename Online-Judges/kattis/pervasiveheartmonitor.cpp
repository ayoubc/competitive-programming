#include <bits/stdc++.h>

using namespace std;

int main(){
	string s,name;
	//ifstream cin("i.txt");
	cout.setf(ios::fixed);
	cout.precision(6);
	while(getline(cin,s)){
		name = "";
		double sum=0;
		int total = 0;
		istringstream iss(s);
		
		do{
			string str;
			iss >> str;
			if(str[0]>='0' && str[0]<='9'){
				double d;
				stringstream ss;
				ss << str, ss >> d;
				sum += d;
				total ++;
			}
			else{
				if(name=="") name += str;
				else name += " "+str;
			}
		}while(iss);
		
		cout<<sum/total<<" "<<name<<endl;
	}
	return 0;
}

