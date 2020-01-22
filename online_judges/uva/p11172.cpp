#include <iostream>

using namespace std;

int main()
{
    int t;
    long long a,b;
    cin>>t;
    for(int k=0;k<t;k++){
        cin>>a>>b;
        if(a<b){
            cout<<"<"<<endl;
        }
        else if(a>b){
            cout<<">"<<endl;
        }
        else{
            cout<<"="<<endl;
        }
    }
    return 0;
}
