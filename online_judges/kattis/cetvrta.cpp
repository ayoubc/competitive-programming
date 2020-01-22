#include <iostream>
#include<cmath>
using namespace std;

int main()
{
    int X_1,X_2,X_3,Y_1,Y_2,Y_3;
    cin>>X_1>>Y_1;
    cin>>X_2>>Y_2;
    cin>>X_3>>Y_3;
    if(Y_1==Y_2){
        if(X_3==X_2){
            cout<<X_1<<" "<<Y_3<<endl;
        }
        else{
            cout<<X_2<<" "<<Y_3<<endl;
        }
    }
    else if(X_2==X_1){
        if(Y_3==Y_2){
            cout<<X_3<<" "<<Y_1<<endl;
        }
        else{
            cout<<X_3<<" "<<Y_2<<endl;
        }
    }
    else{
        if(X_3==X_2){
            cout<<X_1<<" "<<Y_2<<endl;
        }
        else{
            cout<<X_2<<" "<<Y_1<<endl;
        }
    }
    return 0;
}
