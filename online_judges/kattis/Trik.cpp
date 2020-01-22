#include <iostream>
#include<stdio.h>
#include<string>
using namespace std;

int main()
{
    int a = 1,b=0,c=0,n;
    string moves;
    cin>>moves;
    n = moves.size();
    for(int i=0;i<n;i++){
        if(moves[i] == 'A'){
            swap(a,b);
        }
        if(moves[i] == 'B'){
            swap(b,c);
        }
        if(moves[i] == 'C'){
            swap(a,c);
        }
    }
    if(a){
        cout<<"1"<<endl;
    }
    else if(b){
        cout<<"2"<<endl;
    }
    else if(c){
        cout<<"3"<<endl;
    }
    return 0;
}
/*#pragma comment (linker, "/ STACK: 1024000000,1024000000")
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <queue>
#include <stack>
#include <math.h>
#include <vector>
#include <map>
#include <set>
#include <bitset>
#include <complex>
#include <string>
#include <algorithm>
#include <iostream>
#define eps 1e-9
#define LL long long
#define PI acos (-1.0)
#define bitnum (a) __builtin_popcount (a)
using namespace std;
const int N = 55;
const int M = 100005;
const int inf = 1000000007;
const int mod = 10007;
char s [N];
int main ()
{
    int a = 1, b = 0, c = 0, i;
    scanf ("% s", s);
    for (i = 0; s[i]!= '\0'; i ++){
        if (s[i] == 'A')
            swap (a, b);
        else if (s[i] == 'B')
            swap (b, c);
        else
            swap (a, c);
    if (a)
        puts ("1");
    else if (b)
        puts ("2");
    else
        puts ("3");
    return 0;
}}*/
