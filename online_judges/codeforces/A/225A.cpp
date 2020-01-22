#include <bits/stdc++.h>

using namespace std;
int find(set<int> s){
	for(int i=1;i<=6;i++){
		if(!(s.count(i)))
			return i;
	}
}
int main(){
//	freopen("inp.in","r",stdin);
	int n;
	int top,bottum;
	scanf("%d",&n);
	
	int r[n],l[n];
	scanf("%d",&top);
	for(int i=0;i<n;i++){
		scanf("%d%d",&r[i],&l[i]);
		
	}
	bottum = 7-top;
	for(int i=1;i<n;i++){
		set<int> st;
		st.insert(7-bottum);
		st.insert(r[i]),st.insert(7-r[i]);
		st.insert(l[i]),st.insert(7-l[i]);
		if(st.size()!=5){
			printf("NO\n");
			return 0;
		}
		bottum = find(st);
	}
	printf("YES\n");
	return 0;
}

