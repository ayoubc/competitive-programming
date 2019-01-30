#include <iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main()
{
    int W,P;
    cin>>W>>P;
    int *optionel = NULL;
    optionel = new int[P+2];
    vector <int> with;
    optionel[0] = 0;
    optionel[P+1] = W;
    for(int k=1;k<=P;k++){
        cin>>optionel[k];
    }
    for(int i=1;i<P+2;i++){
        for(int j=0;j<i;j++){
            bool existe=false;
            int L=optionel[i]-optionel[j];
            for(int k=0;k<with.size();k++){
                if(with[k]==L){
                    existe = true;
                    break;
                }
            }
            if(!existe){
                with.push_back(L);
            }
        }
    }
    sort(with.begin(),with.end());
    for(int l=0;l<with.size();l++){
        cout<<with[l]<<" ";
    }
    return 0;
}
