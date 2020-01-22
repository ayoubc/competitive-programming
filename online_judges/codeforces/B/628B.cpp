#include <iostream>
#include<stdio.h>
#include <string.h>
#include <sstream>
#include <stdlib.h>
using namespace std;

int main()
{
    char s[300005],sub[3];
    long l;
    long long a=0;
    scanf("%s",&s);
    l = strlen(s);
    for(int i=0;i<l;i++){
    	if(s[i]=='0'||s[i]=='4'||s[i]=='8'){
    		a++;
		}
	}
	for(int i=0;i<l-1;i++){
		sub[0] = s[i], sub[1] = s[i+1];
		stringstream ss;
		int d;
		ss << sub, ss >> d;
		if(d%4==0){
			a += i+1;
		}
	}
    printf("%I64d\n",a);
    return 0;
}
