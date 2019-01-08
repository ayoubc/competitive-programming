#include <iostream>
#include<vector>
#include<algorithm>
#include<stdio.h>
using namespace std;

int main()
{
    int t,pay,c=0;
    cin>>t;
    for(int i=0;i<t;i++){
        c++;
        vector <int> salaries;
        for(int j=0;j<3;j++){
            cin>>pay;
            salaries.push_back(pay);
        }
        sort(salaries.begin(),salaries.end());
        printf("Case %d: %d\n",c,salaries[1]);
    }
    return 0;
}
