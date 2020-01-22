#include <bits/stdc++.h>

using namespace std;
typedef pair<int,int> pi;
/*struct point{
	int x;
	int y;
	pont(){}
	point(int x_,int y_):
		x(x_),y(y_){}
};*/
vector<pi> coor;
int main(){
	//freopen("i.in","r",stdin);
	int n,x,y,sum;
	while(scanf("%d",&n) && n){
		coor.clear();
		bool CCW = false;
		for(int i=0;i<n;i++){
			scanf("%d %d",&x,&y);
			coor.push_back(make_pair(x,y));
		}
		/*if(coor[0].first<=coor[1].first && coor[0].second<=coor[1].second){
			CCW = true;
		}*/
		sum = 0;
		for(int i=0;i<n;i++){
			int j = (i+1)%n;
			sum += (coor[i].first)*(coor[j].second) - (coor[j].first)*(coor[i].second);
		}
		if(sum>=0) printf("CCW %.1f\n",0.5*abs(sum));
		else printf("CW %.1f\n",0.5*abs(sum));
	}
	return 0;
}

