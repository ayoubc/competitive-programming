/*
* Author: ayub23
* created at : 09/09/2019
* tutorial: youtube channel  ==> Tushar Roy
* The problem:
*           Given a knapsack of total capacity S, and a list o items.
*           each item i, has a value Vi and a Weight Wi, what is the
*           what is the set of items that can give us the maximum value
*           (sum of values of items in the set), such that their sum weight
*           does not exeed S.
*
*/

#include <bits/stdc++.h>

using namespace std;
const int S = 7;
const int N = 4;
const int w[N] = {1, 3, 4, 5};
const int v[N] = {1, 4, 5, 7};

int main() {
	int dp[N][S+1];
	for(int j=0;j<=S;j++){
		if(j>=w[0]){
			dp[0][j] = v[0];
		}
		else{
			dp[0][j] = 0;
		}
	}
	for(int i=1;i<N;i++){
		for(int j=0;j<=S;j++){
			if(j<w[i]){
				dp[i][j] = dp[i-1][j];
			}
			else{
				dp[i][j] = max(dp[i-1][j], v[i]+dp[i-1][j-w[i]]);
			}
		}
	}
	/*for(int i=0;i<N;i++){
		for(int j=0;j<=S;j++){
			cout<<dp[i][j]<<" ";
		}
		cout<<"\n";
	}*/
	printf("Maximum Value: %d\n\n", dp[N-1][S]);
	int I = N-1, J = S;
	vector<int> subset;
	while(I>0 && J>=0){
		if(dp[I][J] != dp[I-1][J]){
			subset.push_back(w[I]);
			J -= w[I];
		}
		I--;
	}
	printf("The subset of chosen items:\n");
	for(int i=0;i<subset.size();i++){
		printf("%d ", subset[i]);
	}
	printf("\n");
}
