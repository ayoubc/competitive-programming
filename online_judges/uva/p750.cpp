#include <bits/stdc++.h>

using namespace std;
typedef vector<int> v;

int main()
{
    //freopen("i.txt","r",stdin);
    int t;
    scanf("%i",&t);
    while(t--){
        int a,b;
        vector<v> ans;
        vector<int> start(8);
        for(int i=0;i<8;i++){
            start[i] = i;
        }
        scanf("%d%d",&a,&b);
        a--,b--;
        do{
            if(start[b]==a){
                bool ok = true;
                for(int i=0;i<8;i++){
                    for(int j=i+1;j<8;j++){
                        if(start[i]==start[j] || abs(i-j)==abs(start[i]-start[j])) ok = false;
                    }
                }
                if(ok) ans.push_back(start);
            }
        }while(next_permutation(start.begin(),start.end()));
        sort(ans.begin(),ans.end());
        printf("SOLN       COLUMN\n");
        printf(" #      1 2 3 4 5 6 7 8\n\n");
        for(int i=0;i<ans.size();i++){
            printf("%2d      ",i+1);
            printf("%d",ans[i][0]+1);
            for(int j=1;j<8;j++) {
                //if(j==7) printf("%d\n",ans[i][j]+1);
                //else printf("%d ",ans[i][j]+1);
                printf(" %d",ans[i][j]+1);
            }
            printf("\n");
        }
        if(t)printf("\n");
    }
    //printf("%2d      ", cur++);

    return 0;
}
