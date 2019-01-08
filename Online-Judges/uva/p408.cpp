#include <bits/stdc++.h>

using namespace std;

int lengh(int x){
	int cnt = 0;
	while(x){
		cnt ++;
		x /= 10;
	}
	return cnt;
}
void print(int x){
	int l = lengh(x);
	for(int i=1;i<=10-l;i++) printf(" ");
	printf("%d",x);
}
int main(){
	//freopen("i.in","r",stdin);
	int mod,steep;
	
	while(scanf("%d %d",&steep,&mod)==2){
		set<int> st;
		st.insert(0);
		int last = 0,newnum;
		for(int i=1;i<=mod;i++){
			newnum = (last+steep)%mod;
			st.insert(newnum);
			last = newnum;
		}
		bool ok = true;
		for(int i=0;i<mod;i++){
			if(!(st.count(i))){
				ok = false;
				break;
			}
		}
		print(steep);
		print(mod);
		
		if(!ok){
			printf("    Bad Choice\n");
		}
		else {
			printf("    Good Choice\n");
		}
		/*for(set<int>::iterator it=st.begin();it!=st.end();it++){
			printf("%d ",*it);
		}*/
		printf("\n");
	}
	return 0;
}

