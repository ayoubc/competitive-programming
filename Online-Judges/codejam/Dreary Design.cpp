#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>
#include <cmath>
using namespace std;
long long solve(long K,long V);
long long maxl(long long a,long long b,long long c);
long long minl(long long a,long long b,long long c);
int main(){
	ifstream in("Dreary Design.in");
	ofstream out("Dreary Design.ans");
	int T;
	long K,V;
	in>>T;
	for(int i=1;i<=T;i++){
		in>>K>>V;
		out<<"Case #"<<i<<": "<<solve(K,V)<<endl;
	}
	in.close();
	out.close();
	return 0;
}
long long solve(long K,long V){
	long long subtotal,total=0;
	for(long r=0;r<=V;r++){
		subtotal = 0;
		long  m1,m2,zero=0,minb,maxb;
		//m1 = max(zero,r-V);
		m2 = min(K,r+V);
		for(long y=0;y<=m2;y++){
			minb = maxl(r-V,y-V,zero);
			maxb = minl(r+V,y+V,K);
			subtotal += (maxb-minb+1);
		}
		if(r==V){
			total *= 2;
			total += subtotal * (K-2*V+1);
		}
		else{
			total += subtotal;
		}
	}
	return total;
}
long long maxl(long long a,long long b,long long c){
	if(a>b){
		if(a>c){
			return a;
		}
		else{
			return c;
		}
	}
	else{
		if(b>c){
			return b;
		}
		else{
			return c;
		}
	}
}
long long minl(long long a,long long b,long long c){
	if(a<b){
		if(a<c){
			return a;
		}
		else{
			return c;
		}
	}
	else{
		if(b<c){
			return b;
		}
		else{
			return c;
		}
	}
}
/*
def solve3(k, v):
  total = 0
  for r in range(0, v+1):
    subtotal = 0
    for g in range(max(r-v, 0), min(r+v, k)+1):
      minb = max(r-v, g-v, 0)
      maxb = min(r+v, g+v, k)
      subtotal += (maxb - minb + 1)
    if r == v:
      total *= 2 # take advantage of symmetry
      total += subtotal * (k - 2*v + 1)
    else:
      total += subtotal
  return total
*/
