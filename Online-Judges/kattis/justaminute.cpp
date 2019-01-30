#include <iostream>
#include<stdio.h>
using namespace std;

int main()
{
    int N,m,s;
    long long S=0,M=0;
    double average;
    cin>>N;
    for(int i=0;i<N;i++){
        cin>>m>>s;
        M = M+m*60;
        S = S+s;
    }
    average = (double)S/(double)M;
    if(average<=1){
        printf("measurement error\n");
    }
    else{
        printf("%.9f\n",average);
    }
    return 0;
}

