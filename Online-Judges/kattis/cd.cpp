#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    long N,M,c;
    long long ja,ji;
    while(cin>>N>>M and N!=0 and M!=0){
        c = 0;
        vector <long long> jack;
        vector <long long> jill;
        for(int i=0;i<N;i++){
            cin>>ja;
            jack.push_back(ja);
        }
        for(int j=0;j<M;j++){
            cin>>ji;
            jill.push_back(ji);
        }
        if(N>M){
            for(int m=0;m<M;m++){
                if(binary_search(jack.begin(),jack.end(),jill[m])){
                    c++;
                }
            }
        }
        else{
            for(int m=0;m<N;m++){
                if(binary_search(jill.begin(),jill.end(),jack[m])){
                    c++;
                }
            }
        }
        cout<<c<<endl;
    }
    return 0;
}
