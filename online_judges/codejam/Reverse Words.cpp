#include<iostream>
#include<fstream>
#include<vector>
#include<string>
#include<cmath>

using namespace std;

int main(){
	ifstream in("Reverse Words.in");
	ofstream out("Reverse Words.ans");
	int N,p;
	string phrase,reverse,str;
	in>>N;
	in.ignore();
	for(int i=1;i<=N;i++){
		reverse = "";
		getline(in,phrase);
		p = phrase.find(" ");
		while(p!=string::npos){
			str = phrase.substr(0,p);
			str = " "+str;
			reverse = str+reverse;
			phrase.replace(0,p+1,"");
			p = phrase.find(" ");
		}
		reverse = phrase+reverse;
		out<<"Case #"<<i<<": "<<reverse<<endl;
	}
	return 0;
}

