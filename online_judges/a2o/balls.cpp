#include<iostream>
#include <bits/stdc++.h>
#include <vector>
using namespace std;
int howmany(int p,vector<int> v){
    if(v.size()==0){
    	return 0;
	}
	int sum  =v[0],j=0;
    while(sum<p && j<v.size()){
    	if(j==v.size()-1){
    		return j+1;
		}
    	j++;
    	sum+= v[j];
	}
    return j;
}
int main(){
    int t,n,p,x;
    char l;
    //ifstream cin("I");
    cin>>t;
    for(int tt=0;tt<t;tt++){
        cin>>p>>n;
        vector<int> R,B,G;
        for(int i=0;i<n;i++){
            cin>>l>>x;
            if(l=='R') R.push_back(x);
            else if(l=='B') B.push_back(x);
            else if(l=='G') G.push_back(x);
        }
        sort(R.begin(),R.end());
        sort(B.begin(),B.end());
        sort(G.begin(),G.end());
        cout<<"Red balls = "<<howmany(p,R)<<endl;
        cout<<"Green balls = "<<howmany(p,G)<<endl;
        cout<<"Blue balls = "<<howmany(p,B)<<endl;
        //cout<<R.size()<<" "<<B.size()<<" "<<G.size()<<endl;
        cout<<endl;
    }
    return 0;
}
