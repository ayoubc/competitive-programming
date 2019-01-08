#include <bits/stdc++.h>

using namespace std;

int main(){
    //freopen("i","r",stdin);
    int n;
    while(cin >> n){
        if(n==0) break;

        priority_queue<int> pq;
        int x = 0,sum=0;
        for(int i=0;i<n;i++){
            scanf("%d",&x);
            pq.push(-x);
        }
        while(pq.size()>1){
            int a,b;
            a = -pq.top();
            pq.pop();
            b = -pq.top();
            pq.pop();
            sum += a+b;
            pq.push(-(a+b));
        }
        //sum -= pq.top();
        printf("%d\n",sum);
    }
    return 0;
}
