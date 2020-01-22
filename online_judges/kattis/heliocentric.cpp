#include <iostream>

using namespace std;

int main()
{
    int je,jm,cases=0,c;
    long long diff1,diff2;
    while(cin>>je>>jm){
        c = 0;
        cases++;
        while(je!=0 or jm!=0){
            c++;
            je = (je+1)%365;
            jm = (jm+1)%687;
        }
        cout<<"Case "<<cases<<": "<<c<<endl;
    }
    return 0;
}
