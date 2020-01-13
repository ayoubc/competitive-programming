#include <bits/stdc++.h>

using namespace std;

int main()
{
    //ifstream cin("i.txt");
    int n, h, v;
    cin >> n >> h >> v;
    int ans = max(max(h*v, (n-h)*v), max(h * (n-v), (n-h)*(n-v)));
    cout<<ans * 4<<endl;
    return 0;
}
