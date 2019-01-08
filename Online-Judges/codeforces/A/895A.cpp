#include <bits/stdc++.h>

using namespace std;

int main()
{
    //fstream cin("i.in");
    int n,ans = 10000;
    int ans1,ans2;
    cin >> n;
    vector<int> v(n);
    for(int i=0;i<n;i++) cin>>v[i];


    for(int i=0;i<n;i++){
        ans1 = 0;
        for(int j=i;j<n;j++){
            ans1 += v[j];
            ans2  = 360-ans1;
            ans = min(ans,abs(ans1-ans2));
        }


        //cout<<ans1 <<" "<<ans2<<endl;
    }
    cout<<ans<<endl;
    return 0;
}
