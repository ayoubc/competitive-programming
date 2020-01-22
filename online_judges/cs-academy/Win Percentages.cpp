#include <bits/stdc++.h>

using namespace std;
struct Result{
	int g,x,y;
	Result() {}
	Result(int g_,int x_,int y_):
		g(g_),x(x_),y(y_){}
};
Result gcd(int a,int b){
	if(b==0 )return Result(a,1,0);
	Result res = gcd(b,a%b);
	return Result(res.g,res.y,res.x - (a/b)* res.y);
}
int main()
{
	freopen("i.in","r",stdin);
    int g1,g2,p1,p2,x1,x2,k1,k2,b1,b2;
    scanf("%d %d %d %d",&g1,&p1,&g2,&p2);
    k1 = 100/p1 , k2 = 100/p2;
    for(int i=1;i<=g1;i++){
    	
    	if(i*100/g1 == p1) {
    		x1 = i;
    		break;
		}
	}
	for(int i=g2;i>=1;i--){
    
    	if(i*100/g2 == p2) {
    		x2 = i;
    		break;
		}
	}
	//cout<<x1<<" "<<x2<<endl;
	cout<< x2 - x1 <<endl;
    return 0;
}

