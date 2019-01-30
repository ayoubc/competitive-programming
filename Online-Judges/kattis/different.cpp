#include <iostream>
using namespace std;

int main()
{
    unsigned long long N1,N2;
    while(cin>>N1>>N2){
        if(N1>N2){
            cout<<N1-N2<<endl;
        }
        else{
            cout<<N2-N1<<endl;
        }
    }
    return 0;
}
