#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
    int N,H,W,p,a,n;
    long B,Price;
    while(cin>>N>>B>>H>>W){
        vector <long> Prices;
        for(int k=0;k<H;k++){
            cin>>p;
            vector <int> beds;
            for(int j=0;j<W;j++){
                cin>>a;
                beds.push_back(a);
            }
            if(p*N<=B){
                for(int i=0;i<W;i++){
                    if(beds[i]>=N){
                        Prices.push_back(p*N);
                        break;
                    }
                }
            }
        }
        n = Prices.size();
        if(n!=0){
            sort(Prices.begin(),Prices.end());
            cout<<Prices[0]<<endl;
        }
        else{
            cout<<"stay home"<<endl;
        }
    }
    return 0;
}
