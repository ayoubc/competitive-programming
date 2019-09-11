/*
* Author: ayub23
* created at : 11/09/2019
* tutorial: youtube channel  ==> Tushar Roy
* The problem:
*           Given a set of categories of coins C and an amount of money S, the goal is to
            to give change for S but to use a minimum number of coins. Suppose each category of coin has an infinite
            number of pieces.
*/

#include <bits/stdc++.h>
using namespace std;
const int OO = 1e09;
/*
const int S = 10;
const int N = 2;
int coins[N] = {1, 5};
*/
const int S = 13;
const int N = 4;
int coins[N] = {7, 2, 3, 6};


int T[S+1];
int last_coin[S+1];

void solve() {
    T[0] = 0;
    last_coin[0] = -1;
    for(int i=1;i<=S;i++){
        T[i] = OO;
        last_coin[i] = -1;
    }
    for(int i=0;i<N;i++){
        for(int j=0;j<=S;j++){
            if(j >= coins[i]){
                if(T[j] > 1 + T[j - coins[i]]){
                    T[j] = 1 + T[j - coins[i]];
                    last_coin[j] = coins[i];
                }
            }
        }
    }
    /*for(int j=0;j<=S;j++){
        cout<<T[j]<<" ";
    }
    cout<<"\n";
    for(int j=0;j<=S;j++){
        cout<<last_coin[j]<<" ";
    }
    cout<<"\n";*/
}

void printSet() {
    if(last_coin[S] == -1) {
        printf("There is no solution");
    }
    else{
        int total = S;
        printf("Minimum number of coins: %d\n", T[S]);
        printf("The chosen coins: \n");
        while(total>0){
            printf("%d ", last_coin[total]);
            total -= last_coin[total];
        }
    }
    printf("\n");
}
int main(){
    solve();
    printSet();
    return 0;
}
