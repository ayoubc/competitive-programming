#include <iostream>
#include<cmath>
#include<stdio.h>
using namespace std;

int main()
{
    unsigned long long int a;
    cin>>a;
    double cote,per;
    cote = sqrt(a);
    per = 4*cote;
    printf("%.18f\n",per);
    return 0;
}
