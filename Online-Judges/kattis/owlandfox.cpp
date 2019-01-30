#include <iostream>
#include <stdio.h>
#include <sstream>
using namespace std;
int main()
{
    long T,N,M;
    int j;
    //scanf("%I32d",&T);
    cin>>T;
    for(int i=1;i<=T;i++){
        //scanf("%I32d",&N);
        cin>>N;
        stringstream ss,SS,sS,Ss;
        int digit;
        string number,d;
        ss << N, ss >> number;
        j = number.size()-1;
        while(number[j]=='0' and j>=0){
            j--;
        }
        SS << number[j], SS >> digit;
        digit--;
        sS << digit , sS >> d;
        number.replace(j,1,d);
        Ss << number, Ss >> M;
        cout<<M<<endl;
    }
    return 0;
}

