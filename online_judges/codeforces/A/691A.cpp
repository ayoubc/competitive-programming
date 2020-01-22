#include <iostream>

using namespace std;

int main()
{
    int n,a,c=0;
    cin>>n;
    if(n==1){
    	cin>>a;
    	if(a==0) cout<<"NO"<<endl;
        else cout<<"YES"<<endl;
    }
    else{
        for(int i=0;i<n;i++){
            cin>>a;
            if(a==0){
                c++;
            }
        }
        if(c==1){
            cout<<"YES"<<endl;
        }
        else{
            cout<<"NO"<<endl;
        }
    }

    return 0;
}
