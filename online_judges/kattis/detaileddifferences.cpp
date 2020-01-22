#include <iostream>
#include<stdio.h>
using namespace std;

int main()
{
    int n;
    string W1,W2,diff;
    cin>>n;
    for( int l=0;l<n;l++){
        diff = "";
        cin>>W1;
        cin>>W2;
        for(int i=0;i<W1.size();i++){
            if(W1[i]==W2[i]){
                diff =diff+".";
            }
            else{
                diff = diff+"*";
            }
        }
        cout<<W1<<endl;
        cout<<W2<<endl;
        cout<<diff<<endl;
        printf("\n");
    }
    return 0;
}
