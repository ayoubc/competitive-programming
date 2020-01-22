#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main()
{
    string frac,N;
    int p,cx;
    while(cin>>frac){
        cx = 0;
        p = frac.find("/");
        N = frac.substr(p+1);
        stringstream ss;
        int n;
        ss << N , ss >> n;
        //cout<<n<<endl;
        for(int x=n+1;x<=2*n;x++){
            if((n*x)%(x-n)==0 and n*x/(x-n)>=2*n){
                cx++;
            }
        }
        cout<<cx<<endl;
    }
    return 0;
}
