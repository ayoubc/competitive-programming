#include <bits/stdc++.h>

using namespace std;
bool check(vector<string> v,int j,string s,int x,int y){
//bool check(vector<string> v,int x,int y){
	int X=0,Y=0,angle = 90;
	vector<string> V(v.size());
	for(int i=0;i<v.size();i++){
		if(i==j) V[i] = s;
		else V[i] = v[i];
	}
	for(int i=0;i<V.size();i++){
		angle = (angle+360)%360;
		if(V[i]=="Forward"){
			if(angle%360==0){
				X++;
			}
			else if(angle%360==90){
				Y++;
			}
			else if(angle%360==180){
				X--;
			}
			else if(angle%360==270){
				Y--;
			}
		}
		else if(V[i]=="Left"){
			angle += 90;
		}
		else{
			angle -= 90;
		}

	}
	return X==x && Y==y;
}
int main(){
	//ifstream cin("i.in");
	int x,y,n;
	cin>>x>>y;
	cin>>n;
	vector<string> v(n);
	for(int i=0;i<n;i++){
		cin>>v[i];
	}
	/*if(check(v,x,y)) cout<<"good\n";
	else cout<<"not good\n";*/
	for(int i=0;i<n;i++){
		if(v[i]=="Forward"){
			if(check(v,i,"Left",x,y)){
				cout<<i+1<<" Left\n";
				break;
			}
			else if(check(v,i,"Right",x,y)){
				cout<<i+1<<" Right\n";
				break;
			}
		}
		else if(v[i]=="Left"){
			if(check(v,i,"Forward",x,y)){
				cout<<i+1<<" Forward\n";
				break;
			}
			else if(check(v,i,"Right",x,y)){
				cout<<i+1<<" Right\n";
				break;
			}
		}
		else if(v[i]=="Right"){
			if(check(v,i,"Forward",x,y)){
				cout<<i+1<<" Forward\n";
				break;
			}
			else if(check(v,i,"Left",x,y)){
				cout<<i+1<<" Left\n";
				break;
			}
		}
	}
	return 0;
}

