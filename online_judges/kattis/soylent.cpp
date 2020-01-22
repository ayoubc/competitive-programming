#include <iostream>

using namespace std;

int main()
{
    int T,N;
    cin>>T;
    for(int k=0;k<T;k++){
        cin>>N;
        if(N%400==0){
            cout<<N/400<<endl;
        }
        else{
            cout<<N/400 +1<<endl;
        }
    }
    return 0;
}
