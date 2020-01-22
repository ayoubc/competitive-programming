#include <iostream>
#include<string>
using namespace std;
int cnt[10000];
int main(){
    //freopen("i","r",stdin);
    int n;
    while(true){
        cin >> n;
        if(n==0) {
            return 0;
        }
        for(int i=0;i<n;i++) cnt[0] = 0;

        int maxX = -1;
        for(int i=0;i<n;i++) {
            string s;
            cin >> s;
            for(int j=0;j<25;j++){
                if(s[j]=='X') cnt[i]++;
            }
            maxX = max(maxX,cnt[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans = ans + maxX - cnt[i];
        }
        cout<<ans<<endl;
        //printf("%d\n",ans);
    }
    return 0;
}
