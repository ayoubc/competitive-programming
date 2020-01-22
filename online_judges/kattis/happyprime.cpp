#include <iostream>
#include <string>
#include <sstream>
#include <stdio.h>
#include <fstream>
#include <cmath>
using namespace std;
int carre(int x);
int is_prime(long p);
int sum_squares(int number);
bool is_happy(int num);
int main(){
	//freopen("happy happy prime prime.in","r",stdin);
	//freopen("out.out","w",stdout);
    int P,K,m;
    scanf("%d\n",&P);
    for(int i=0;i<P;i++){
        scanf("%d %d\n",&K,&m);
        if(is_prime(m)==1){
            if(is_happy(m)){
                printf("%d %d YES\n",K,m);
            }
            else{
                printf("%d %d NO\n",K,m);
            }
        }
        else{
            printf("%d %d NO\n",K,m);
        }
    }
    return 0;
}
int is_prime(long p){
    if(p==1){
        return 0;
    }
    else if (p==2){
        return 1;
    }
    else if(p%2==0){
    	return 0;
	}
    else{
        long q = sqrt(p);
        for(long j=3;j<=q;j=j+2){
            if(p%j==0){
                return 0;
            }
        }
        return 1;
    }
}
int carre(int x){
    return x*x;
}
int sum_squares(int number){
    int sum=0,d;
    while(number!=0){
    	d = number%10;
    	number /= 10;
    	sum += carre(d);
	}
    return sum;
}
bool is_happy(int num){
    if(num==1){
        return true;
    }
    else if(num==4){
        return false;
    }
    else{
        int n = sum_squares(num);
        return is_happy(n);
    }
}
