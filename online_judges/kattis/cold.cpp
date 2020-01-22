#include <iostream>

using namespace std;

int main()
{
    int n,cold_days=0;
    cin>>n;
    long temperature;
    for(int i=0;i<n;i++){
        cin>>temperature;
        if(temperature<0){
            cold_days++;
        }
    }
    cout<<cold_days<<endl;
    return 0;
}
