#include <iostream>
#include<cmath>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
    long long N,i=1,p;
    vector <long long> D;
    cin>>N;
    p = sqrt(N);
    while(i<=p){
        if(N%i==0){
            D.push_back(i-1);
            if(i!=(N/i)){
                D.push_back(N/i -1);
            }
        }
        i++;
    }
    sort(D.begin(),D.end());
    for(int k=0;k<D.size();k++){
        cout<<D[k]<<" ";
    }
    return 0;
}
