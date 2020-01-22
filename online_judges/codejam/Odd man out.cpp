#include <iostream>
#include<vector>
#include<algorithm>
#include <fstream>
using namespace std;

int main()
{
    int N,G;
    long C;
    ifstream file ("A-large-practice.in");
    //cin>>N;
    file>>N;
    for(int i=1;i<=N;i++){
        //cin>>G;
        file>>G;
        vector <long> guest;
        for(int k=0;k<G;k++){
            //cin>>C;
            file>>C;
            guest.push_back(C);
        }
        for(int j=0;j<G;j++){
            if(count(guest.begin(),guest.end(),guest[j])!=2){
                cout<<"Case #"<<i<<": "<<guest[j]<<endl;
                break;
            }
        }
    }
    return 0;
}



