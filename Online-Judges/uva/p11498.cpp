#include <iostream>

using namespace std;

int main()
{
    int K,N,M;
    while(cin>>K&&K!=0){
        cin>>N>>M;
        int *X = NULL;
        int *Y = NULL;
        X = new int[K];
        Y = new int[K];
        for(int i=0;i<K;i++){
            cin>>X[i]>>Y[i];
        }
        for(int j=0;j<K;j++){
            if(X[j]==N||Y[j]==M){
                cout<<"divisa"<<endl;
            }
            else if(X[j]>N&&Y[j]>M){
                cout<<"NE"<<endl;
            }
            else if(X[j]<N&&Y[j]<M){
                cout<<"SO"<<endl;
            }
            else if(X[j]>N&&Y[j]<M){
                cout<<"SE"<<endl;
            }
            else if(X[j]<N&&Y[j]>M){
                cout<<"NO"<<endl;
            }
        }
        delete[] X;
        delete[] Y;
    }
    return 0;
}
