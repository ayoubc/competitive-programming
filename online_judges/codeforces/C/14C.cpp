#include<bits/stdc++.h>
using namespace std;
typedef pair<int,int> pi;
typedef pair<pi,pi> pii;
int main(){
	// freopen("i","r",stdin);
	int x1,y1,x2,y2,xmin,xmax,ymin,ymax;
	set<pii> st;
	set<pi> s;
	vector<int> x,y;
	bool ok = true;
	for(int i=0;i<4;i++){
		scanf("%d%d%d%d",&x1,&y1,&x2,&y2);
		x.push_back(x1),x.push_back(x2);
		y.push_back(y1),y.push_back(y2);
		s.insert(make_pair(x1,y1));
		s.insert(make_pair(x2,y2));
		st.insert(make_pair(make_pair(x1,y1),make_pair(x2,y2)));
		st.insert(make_pair(make_pair(x2,y2),make_pair(x1,y1)));
	}

	if(s.size()!=4) ok = false;
	sort(x.begin(),x.end());
	sort(y.begin(),y.end());
	xmin = x[0] , xmax = x[x.size()-1];
	ymin = y[0] , ymax = y[y.size()-1];
	if(st.count(make_pair(make_pair(xmin,ymin),make_pair(xmin,ymax)))==0 && st.count(make_pair(make_pair(xmin,ymax),make_pair(xmin,ymin)))==0) ok = false;
	if(st.count(make_pair(make_pair(xmin,ymin),make_pair(xmax,ymin)))==0 && st.count(make_pair(make_pair(xmax,ymin),make_pair(xmin,ymin)))==0) ok = false;
	if(st.count(make_pair(make_pair(xmax,ymin),make_pair(xmax,ymax)))==0 && st.count(make_pair(make_pair(xmax,ymax),make_pair(xmax,ymin)))==0) ok = false;
	if(st.count(make_pair(make_pair(xmin,ymax),make_pair(xmax,ymax)))==0 && st.count(make_pair(make_pair(xmax,ymax),make_pair(xmin,ymax)))==0) ok = false;
	if(xmin==xmax || ymin==ymax) ok = false;
	cout<<(ok?"YES":"NO")<<endl;
}