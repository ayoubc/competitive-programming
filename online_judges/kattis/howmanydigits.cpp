#include <iostream>
#include<cmath>
#define M_PI 3.14159265358979323846
using namespace std;

int main()
{
    long long n;
    double N;
    while(cin>>n){
        if(n==0||n==1){
            cout<<1<<endl;
        }
        else{
            N = n*log10(n/exp(1)) + 0.5*log10(2*M_PI*n) + log10(1+1/(12*n));
            cout<<(long long)(N)+1 <<endl;
        }
    }
    return 0;
}
