#include<iostream>
#include<cmath>
using namespace std;
int main(){
	double x_1,y_1,x_2,y_2,p,distance_p,distance;
	while(cin>>x_1>>y_1>>x_2>>y_2>>p){
		distance_p = pow(fabs(x_1-x_2),p)+pow(fabs(y_1-y_2),p);
		distance = pow(distance_p,1/p);
		printf("%.10f\n",distance);
	}
	return 0;
}
