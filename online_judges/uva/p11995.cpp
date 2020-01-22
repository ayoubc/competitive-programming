#include <bits/stdc++.h>

using namespace std;
bool moreOne(bool a,bool b,bool c){
    return (a&&b)||(a&&c)||(b&&c);
}
int main(){
    //freopen("i","r",stdin);
    int n;
    while(scanf("%d",&n)==1){
        priority_queue<int> pq;
        queue<int> q;
        stack<int> s;
        int x,k;
        bool PQ=true,Q=true,S=true;
        for(int i=0;i<n;i++){
            scanf("%d%d",&k,&x);
            if(k==1){
                if(PQ) pq.push(x);
                if(Q) q.push(x);
                if(S) s.push(x);
            }
            else{
                if(PQ){
                    if(pq.empty() || pq.top()!=x){
                        PQ = false;
                    }
                    else pq.pop();
                }
                if(Q){
                    if(q.empty() || q.front()!=x){
                        Q = false;
                    }
                    else q.pop();
                }
                if(S){
                    if(s.empty() || s.top()!=x){
                        S = false;
                    }
                    else s.pop();
                }
            }
        }
        if(!PQ && !Q && !S) printf("impossible\n");
        else if(moreOne(PQ,Q,S)) printf("not sure\n");
        else {
            if(Q) printf("queue\n");
            else if(PQ) printf("priority queue\n");
            else printf("stack\n");
        }
    }
    return 0;
}
