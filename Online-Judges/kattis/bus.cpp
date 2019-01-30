#include <iostream>
#include <cmath>
using namespace std;

int main()
{
    int T,k;
    cin>>T;
    long n;
    for(int i=0;i<T;i++){
        cin>>k;
        n = pow(2,k)-1;
        cout<<n<<endl;
    }
    return 0;
}
