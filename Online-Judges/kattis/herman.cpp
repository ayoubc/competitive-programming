#include <iostream>
#include <stdio.h>
#include <cmath>
#define pi 3.1415926535897
using namespace std;

int main()
{
    int R;
    double S_euclide,S_taxicab;
    scanf("%d",&R);
    S_euclide = pi*pow(R,2);
    S_taxicab = 2*pow(R,2);
    printf("%.6f\n",S_euclide);
    printf("%.6f\n",S_taxicab);
    return 0;
}
