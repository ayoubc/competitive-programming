#include <iostream>
#include<algorithm>
#include<vector>
#include<cmath>
using namespace std;

int main()
{
    unsigned long long N,M,bases;
    int k,max_zero,zeros;
    cin>>N;
    vector <int> zero;
    bases = sqrt(N);
    for(int i=2;i<=bases;i++){
        M=N;
        zeros = 0;
        while(M%i==0&&M!=0){
            zeros++;
            M=M/i;
        }
        zero.push_back(zeros);
    }
    max_zero = *max_element(zero.begin(),zero.end());
    if(max_zero==0){
        cout<<N<<endl;
    }
    else{
        for(int l=0;l<zero.size();l++){
            if(zero[l]==max_zero){
                k=l+2;
                break;
            }
        }
        cout<<k<<endl;
    }
    return 0;
}

