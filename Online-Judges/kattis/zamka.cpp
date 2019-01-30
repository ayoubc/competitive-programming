#include <iostream>
#include<string>
#include<sstream>

using namespace std;

int main()
{
    int L,D,X,N,M,sum_digit,byte;
    cin>>L;
    cin>>D;
    cin>>X;
    for(int j=L;j<=D;j++){
        stringstream ss;
        string j_string;
        ss << j;
        ss >> j_string;
        sum_digit = 0;
        for(int k=0;k<j_string.size();k++){
            stringstream SS;
            SS << j_string[k];
            SS >> byte;
            sum_digit = sum_digit+byte;
        }
        if(sum_digit==X){
            N = j;
            break;
        }
    }
    for(int j=D;j>=L;j--){
        stringstream ss;
        string j_string;
        ss << j;
        ss >> j_string;
        sum_digit = 0;
        for(int k=0;k<j_string.size();k++){
            stringstream SS;
            SS << j_string[k];
            SS >> byte;
            sum_digit = sum_digit+byte;
        }
        if(sum_digit==X){
            M = j;
            break;
        }
    }
    cout<<N<<endl;
    cout<<M<<endl;
    return 0;
}


