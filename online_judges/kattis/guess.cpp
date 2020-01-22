#include <bits/stdc++.h>
using namespace std;

int main(){
    int l=1 , r=1000;
    string res;
    while(l<=r){
        int mid = (l+r)/2;
        cout<<mid<<endl;
        cin >> res;
        if(res=="lower") r = mid-1;
        else if(res=="higher") l = mid+1;
        else break;
    }
    return 0;
}
