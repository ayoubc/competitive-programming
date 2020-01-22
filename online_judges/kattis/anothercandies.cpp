#include<iostream>

using namespace std;

int main(){

    int T,N;
    cin>>T;
    for(int i=0;i<T;i++)
    {
        cout<<endl;
        cin>>N;
        long long s=0;
        for(int j=0;j<N;j++)
        {
            long long b;
            cin>>b;
            s=s+b%N;
        }
        if(s%N==0)
        {
            cout<<"YES"<<endl;
        }
        else
        {
            cout<<"NO"<<endl;
        }
    }
    return 0;
}
