#include <bits/stdc++.h>
using namespace std;

int main(){
	
	int n;
	scanf("%d",&n);
	vector<int> v1,v2;
	v1.push_back(n);
	//v2.push_back(n-1);
	int i = n-1 , s1 = n, s2 = 0;
	while(i>0){
		if(abs(s1+i-s2)<abs(s1-s2-i)){
			v1.push_back(i);
			s1 += i;
		}
		else{
			v2.push_back(i);
			s2 += i;
		}
		i--;
	}
	printf("%d\n",abs(s1-s2));
	printf("%d ",v1.size());
	for(int j=0;j<v1.size();j++){
		printf("%d ",v1[j]);
	}
	return 0;
}

