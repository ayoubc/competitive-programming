#include<iostream>
#include<sstream>
#include<fstream>
#include<vector>
#include<algorithm>
#include<string>
#include<cmath>
using namespace std;
int carre(int x);
int main(){
	//freopen("A-large-practice.in","r",stdin);
	//freopen("A-large-practice.txt","w",stdout);
	//freopen("input2.txt","r",stdin);
	int N,x1,x2,x3,y1,y2,y3,side1,side2,side3,angle1,angle2,angle3;
	scanf("%d",&N);
	for(int i=1;i<=N;i++){
		scanf("%d %d %d %d %d %d",&x1,&y1,&x2,&y2,&x3,&y3);
		side1 = carre(x1-x2)+carre(y1-y2);
		side2 = carre(x1-x3)+carre(y1-y3);
		side3 = carre(x2-x3)+carre(y2-y3);
		printf("Case #%d: ",i);
		if((y1-y2)*(x2-x3)==(y2-y3)*(x1-x2)){
			printf("not a triangle\n");
		}
		else{
			if(side1==side2 ||side1==side3 ||side2==side3){
				printf("isosceles ");
				if(side1==side2+side3 ||side2==side1+side3 ||side3==side1+side2){
					printf("right triangle\n");
				}
				else if(side1>side2+side3 ||side2>side1+side3 ||side3>side1+side2){
					printf("obtuse triangle\n");
				}
				else printf("acute triangle\n");
			}
			else{
				printf("scalene ");
				if(side1==side2+side3 ||side2==side1+side3 ||side3==side1+side2){
					printf("right triangle\n");
				}
				else if(side1>side2+side3 ||side2>side1+side3 ||side3>side1+side2){
					printf("obtuse triangle\n");
				}
				else printf("acute triangle\n");
			}
		}
		//if it is not triangle;
	}
	return 0;
}
int carre(int x){
	return x*x;
}
