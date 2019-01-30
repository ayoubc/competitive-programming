#include <iostream>
#include <fstream>
using namespace std;

long long digit_sum (long long x) {
  	int res=0;
  	while (x > 0) { 
  		res += x%10; 
		x /= 10; 
	}
  	return res;
}

long long total_sum (long long x){
  int d = x%10;
  return x==0 ? 0 : d*(d-1)/2 + d*digit_sum(x/10) + 10*total_sum(x/10) + (x/10) * 45;
}

int main () {
  int t;
  //ifstream in("D.in");
  
  cin >> t;

  while (t--) {
    long long a,b;
    cin >> a >> b;
    cout << total_sum(b+1) - total_sum(a) << endl;
  }

  return 0;
}
