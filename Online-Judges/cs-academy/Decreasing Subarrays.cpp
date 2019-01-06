#include<bits/stdc++.h>


using namespace std;


int main(){
	freopen("i.in","r",stdin);
	freopen("o.out","w",stdout);
	int n;
	scanf("%d",&n);
	int a[n],b[n];
	
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	int i=0,j=0,cnt;
	while(i<n){
		j=i;
		cnt=0;
		while(j<n){
			if(a[j]>a[j+1]){
				cnt++;
				j++;
				
			}
			else{
				j++;
				cnt++;
				break;
			}
			
		}
		//if(cnt==0) cnt=1;
		for(int k=i;k<j;k++) b[k] = cnt;
		i = j;
	}
	for(int i=0;i<n;i++) printf("%d ",b[i]);
}