#include <iostream>
#include <stdio.h>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;
int main()
{
    int t,n,l;
    string number,n1;
    scanf("%d",&t);
    bool isConsistent;
    for(int i=0;i<t;i++){
        isConsistent = true;
        vector <string> phone;
        scanf("%d",&n);
        for(int j=0;j<n;j++){
            cin>>number;
            phone.push_back(number);
        }
        sort(phone.begin(),phone.end());
        for(int k=0;k<n-1;k++){
            if(phone[k+1].size()>=phone[k].size()){
                l = phone[k].size();
                n1 = phone[k+1].substr(0,l);
                if(phone[k]==n1){
                    isConsistent = false;
                    break;
                }
            }
        }
        if(isConsistent){
            printf("YES\n");
        }
        else{
            printf("NO\n");
        }
    }
    return 0;
}
