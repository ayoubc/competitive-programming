#include <iostream>
#include <cmath>
#include <stdio.h>
using namespace std;
long L[1000005];
long low(long long i);
int main()
{
    long i,low_order_zero;
    L[0] = 1;
    L[1] = 1;
    L[2] = 2;
    L[3] = 6;
    while(cin>>i and i!= 0){
        low_order_zero = low(i);
        cout<<low_order_zero%10<<endl;
    }
    return 0;
}
long  low(long long i){
    if(L[i]){
        return L[i];
    }
    else{
        long long M,m;
        M = low(i-1);
        m = i;
        while(m%10==0){
            m = m/10;
        }
        M = low(i-1)*m;
        while(M%10==0){
            M = M/10;
        }
        L[i] = M%1000000;
        return L[i];
    }
}
