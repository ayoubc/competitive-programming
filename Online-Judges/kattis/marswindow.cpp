#include <iostream>

using namespace std;

int main(){
    //ifstream cin("i.txt");
    int y;
    cin >> y;
    int r = ((y - 2018 + 1)*12 - 4)%26;
    //cout<<r<<endl;
    cout<<(r<12 ? "yes": "no")<<endl;
    return 0;
}
