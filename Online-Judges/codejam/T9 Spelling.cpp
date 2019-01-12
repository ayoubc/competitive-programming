#include<iostream>
#include<fstream>
#include<vector>
#include<string>
#include<cmath>

using namespace std;

int main(){
	ifstream in("C-large-practice.in");
	ofstream out("C-large-practice.ans");
	int N,n;
	string line,numbers;
	in >> N;
	in.ignore();
	for(int i=1;i<=N;i++){
		numbers = "";
		getline(in,line);
		n = line.size();
		for(int j=0;j<n;j++){
			if(j==n-1){
				if(line[j]=='a'){
					numbers += "2";
				}
				if(line[j]=='b'){
					numbers += "22";
				}
				if(line[j]=='c'){
					numbers += "222";
				}
				if(line[j]=='d'){
					numbers += "3";
				}
				if(line[j]=='e'){
					numbers += "33";
				}
				if(line[j]=='f'){
					numbers += "333";
				}
				if(line[j]=='g'){
					numbers += "4";	
				}
				if(line[j]=='h'){
					numbers += "44";
				}
				if(line[j]=='i'){
					numbers += "444";	
				}
				if(line[j]=='j'){
					numbers += "5";	
				}
				if(line[j]=='k'){
					numbers += "55";
				}
				if(line[j]=='l'){
					numbers += "555";
				}
				if(line[j]=='m'){
					numbers += "6";
				}
				if(line[j]=='n'){
					numbers += "66";
				}
				if(line[j]=='o'){
					numbers += "666";
				}
				if(line[j]=='p'){
					numbers += "7";
				}
				if(line[j]=='q'){
					numbers += "77";
				}
				if(line[j]=='r'){
					numbers += "777";
				}
				if(line[j]=='s'){
					numbers += "7777";
				}
				if(line[j]=='t'){
					numbers += "8";
				}
				if(line[j]=='u'){
					numbers += "88";
				}
				if(line[j]=='v'){
					numbers += "888";
				}
				if(line[j]=='w'){
					numbers += "9";
				}
				if(line[j]=='x'){
					numbers += "99";
				}
				if(line[j]=='y'){
					numbers += "999";
				}
				if(line[j]=='z'){
					numbers += "9999";
				}
				if(line[j]==' '){
					numbers += "0";
				}
			}
			else{
				if(line[j]=='a'){
				if(line[j+1]=='b' or line[j+1]==line[j] or line[j+1]=='c'){
					numbers += "2 ";
				}
				else{
					numbers += "2";
				}
			}
			if(line[j]=='b'){
				if(line[j+1]=='a' or line[j+1]==line[j] or line[j+1]=='c'){
					numbers += "22 ";
				}
				else{
					numbers += "22";
				}
			}
			if(line[j]=='c'){
				if(line[j+1]=='b' or line[j+1]==line[j] or line[j+1]=='a'){
					numbers += "222 ";
				}
				else{
					numbers += "222";
				}
			}
			if(line[j]=='d'){
				if(line[j+1]=='e' or line[j+1]==line[j] or line[j+1]=='f'){
					numbers += "3 ";
				}
				else{
					numbers += "3";
				}
			}
			if(line[j]=='e'){
				if(line[j+1]=='d' or line[j+1]==line[j] or line[j+1]=='f'){
					numbers += "33 ";
				}
				else{
					numbers += "33";
				}
			}
			if(line[j]=='f'){
				if(line[j+1]=='e' or line[j+1]==line[j] or line[j+1]=='d'){
					numbers += "333 ";
				}
				else{
					numbers += "333";
				}
			}
			if(line[j]=='g'){
				if(line[j+1]=='h' or line[j+1]==line[j] or line[j+1]=='i'){
					numbers += "4 ";
				}
				else{
					numbers += "4";
				}
			}
			if(line[j]=='h'){
				if(line[j+1]=='g' or line[j+1]==line[j] or line[j+1]=='i'){
					numbers += "44 ";
				}
				else{
					numbers += "44";
				}
			}
			if(line[j]=='i'){
				if(line[j+1]=='h' or line[j+1]==line[j] or line[j+1]=='g'){
					numbers += "444 ";
				}
				else{
					numbers += "444";
				}
			}
			if(line[j]=='j'){
				if(line[j+1]=='k' or line[j+1]==line[j] or line[j+1]=='l'){
					numbers += "5 ";
				}
				else{
					numbers += "5";
				}
			}
			if(line[j]=='k'){
				if(line[j+1]=='j' or line[j+1]==line[j] or line[j+1]=='l'){
					numbers += "55 ";
				}
				else{
					numbers += "55";
				}
			}
			if(line[j]=='l'){
				if(line[j+1]=='k' or line[j+1]==line[j] or line[j+1]=='j'){
					numbers += "555 ";
				}
				else{
					numbers += "555";
				}
			}
			if(line[j]=='m'){
				if(line[j+1]=='n' or line[j+1]==line[j] or line[j+1]=='o'){
					numbers += "6 ";
				}
				else{
					numbers += "6";
				}
			}
			if(line[j]=='n'){
				if(line[j+1]=='m' or line[j+1]==line[j] or line[j+1]=='o'){
					numbers += "66 ";
				}
				else{
					numbers += "66";
				}
			}
			if(line[j]=='o'){
				if(line[j+1]=='m' or line[j+1]==line[j] or line[j+1]=='n'){
					numbers += "666 ";
				}
				else{
					numbers += "666";
				}
			}
			if(line[j]=='p'){
				if(line[j+1]=='q' or line[j+1]==line[j] or line[j+1]=='r' or line[j+1]=='s'){
					numbers += "7 ";
				}
				else{
					numbers += "7";
				}
			}
			if(line[j]=='q'){
				if(line[j+1]=='p' or line[j+1]==line[j] or line[j+1]=='r' or line[j+1]=='s'){
					numbers += "77 ";
				}
				else{
					numbers += "77";
				}
			}
			if(line[j]=='r'){
				if(line[j+1]=='p' or line[j+1]==line[j] or line[j+1]=='q' or line[j+1]=='s'){
					numbers += "777 ";
				}
				else{
					numbers += "777";
				}
			}
			if(line[j]=='s'){
				if(line[j+1]=='p' or line[j+1]==line[j] or line[j+1]=='q' or line[j+1]=='r'){
					numbers += "7777 ";
				}
				else{
					numbers += "7777";
				}
			}
			if(line[j]=='t'){
				if(line[j+1]=='u' or line[j+1]==line[j] or line[j+1]=='v'){
					numbers += "8 ";
				}
				else{
					numbers += "8";
				}
			}
			if(line[j]=='u'){
				if(line[j+1]=='t' or line[j+1]==line[j] or line[j+1]=='v'){
					numbers += "88 ";
				}
				else{
					numbers += "88";
				}
			}
			if(line[j]=='v'){
				if(line[j+1]=='u' or line[j+1]==line[j] or line[j+1]=='t'){
					numbers += "888 ";
				}
				else{
					numbers += "888";
				}
			}
			if(line[j]=='w'){
				if(line[j+1]=='x' or line[j+1]==line[j] or line[j+1]=='y' or line[j+1]=='z'){
					numbers += "9 ";
				}
				else{
					numbers += "9";
				}
			}
			if(line[j]=='x'){
				if(line[j+1]=='w' or line[j+1]==line[j] or line[j+1]=='y' or line[j+1]=='z'){
					numbers += "99 ";
				}
				else{
					numbers += "99";
				}
			}
			if(line[j]=='y'){
				if(line[j+1]=='w' or line[j+1]==line[j] or line[j+1]=='x' or line[j+1]=='z'){
					numbers += "999 ";
				}
				else{
					numbers += "999";
				}
			}
			if(line[j]=='z'){
				if(line[j+1]=='w' or line[j+1]==line[j] or line[j+1]=='x' or line[j+1]=='y'){
					numbers += "9999 ";
				}
				else{
					numbers += "9999";
				}
			}
			if(line[j]==' '){
				if(line[j+1]==line[j]){
					numbers += "0 ";
				}
				else{
					numbers += "0";
				}
			}
			}
			
		}
		out<<"Case #"<<i<<": "<<numbers<<endl;
	}
	in.close();
	out.close();
	return 0;
}

