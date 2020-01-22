#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main()
{
    string str,s1,s2;
    int x,y,f;
    cin>>str;
    f = str.find(",");
    s1 = str.substr(0,f);
    s2 = str.substr(f+1);
    stringstream ss,SS;
    ss<<s1,ss>>x;
    SS<<s2,SS>>y;
    cout<<x-y<<endl;
    return 0;
}
