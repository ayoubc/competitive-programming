#include<iostream>
#include<stdio.h>
#include<algorithm>
#include<vector>
using namespace std;

int main(){
    //and we will use the sample input 5 to verify.
    //as direction left of moving (0)
    int game[4][4];
    int Possible_valeur[] = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024,2048};
    vector <int> VP(Possible_valeur,Possible_valeur+11);
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            cin>>game[i][j];
        }
    }
    int some;
    //for each move we define a new vector
    vector <int> temp;
    int n,k,some;
    for(int i=0;i<4;i++){
        for(int j=0;j<=3;j++){
            if(game[i][j]!=0){
                temp.push_back(game[i][j]);
            }
        }
        n = temp.size();
        k = 0;
        while(k<n){
            some = temp[k]+temp[k+1];
            if(binary_search(VP.begin(),VP.end(),some)){
                game[i][0] = some;
            }
        }
    }
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            cout<<game[i][j]<<" ";
        }
        printf("\n");
    }
}
