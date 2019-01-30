#include <iostream>
#include <cmath>
#include <stdio.h>
using namespace std;

int main()
{
    long int p,sum,n;
    while(cin>>p){
        sum = 0;
        n = sqrt(p);
        for(int i=1;i<=n;i++){
            if(p%i==0){
                sum=sum+i;
                if(i!=p/i){
                    sum=sum+p/i;
                }
            }
        }
        sum = sum-p;
        if(sum==p){
            //cout<<sum<<endl;
            cout<<p<<" perfect"<<endl;
        }
        else if(p-sum>=-2 and p-sum<=2){
            //cout<<sum<<endl;
            cout<<p<<" almost perfect"<<endl;
        }
        else{
            //cout<<sum<<endl;
            cout<<p<<" not perfect"<<endl;
        }
    }
    return 0;
}
