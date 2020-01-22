//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
int area = 31250;
typedef pair<int,int> pi;
int main(){
	int x,y;
	scanf("%d %d",&x,&y);
	double ansx,ansy;
	if(x!=0 && y!=0){
		if(250*y - area >=0){
			ansx = 250 - area*1.0/(y*1.0);
			ansy = 0;
		}
		else{
			ansx = 0;
			ansy = 250 - area*1.0/(x*1.0);
		}
	}
	else{
		if(x==0 && y==0){
			ansx = area*1.0/250.0;
			ansy = area*1.0/250.0;
		}
		else if(x==0 && y!=0 ){
			if(area <= 250 * y) {
				ansy = 0;
				ansx = (double)area/(double)y;
			}
			else {
				ansx = area*1.0 /(double)(250 - y);
				ansy = 125 - ansx*y/250.0;
			}
		}
		else if(x!=0 && y==0){
			if(area <= 250*x){
				ansy = (double)area/(double)x;
				ansx = 0;
			}
			else{
				ansy = area*1.0/(double)(250 - x);
				ansx = 125 - ansy*x/250.0;
			}
		}
	}
	printf("%.2f %.2f",ansx,ansy);
	return 0;
}

