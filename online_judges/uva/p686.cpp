#include <iostream>
#include<cmath>
using namespace std;
bool is_prime_2(int p);
int main()
{
    int x,c;
    while(cin>>x&&x!=0){
        c = 0;
        for(int k=2;k<=x/2;k++){
            if(is_prime_2(k)){
                if(is_prime_2(x-k)){
                    c++;
                }
            }
        }
        cout<<c<<endl;
    }
    return 0;
}
bool is_prime_2(int p){
    if(p==2){
        return true;
    }
    else{
        if(p%2==0){
            return false;
        }
        else{
            int i=3;
            while(i<=sqrt(p)){
                if(p%i==0){
                    return false;
                }
                i = i+2;
            }
            return true;
        }
    }
}
