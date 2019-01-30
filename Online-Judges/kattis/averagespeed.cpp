#include <bits/stdc++.h>
using namespace std;
string read;
int main(){
//	freopen("i","r",stdin);
	int hh,mm,ss,v = 0,s = -1,time = 0;
	string S;
	double d = 0.0;
	while(getline(cin,read)){
//		cout<<read<<endl;
		hh = (read[0] - '0')*10+(read[1] - '0');
		mm = (read[3] - '0')*10+(read[4] - '0');
		ss = (read[6] - '0')*10+(read[7] - '0');
		if(read.size()>=10){
			S = read.substr(9);
			d += v*(hh*3600+mm*60+ss - time)*1.0/3600;
			time = hh*3600+mm*60+ss;
			stringstream ss;
			ss << S , ss  >> v;
			
		}
		else{
			d += v*(hh*3600+mm*60+ss - time)*1.0/3600;
			time = hh*3600+mm*60+ss;

			cout<<read<<" ";
			printf("%.2f km\n",d);
		}
	}
	return 0;
}

