#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int gcd(int a, int b) {
    if(b == 0) return a;
    return gcd(b, a%b);
}
int main(){
    //ifstream cin("i.txt");

    int t;
    cin >> t;
    for(int i=0;i<t;i++) {
        int a,b,d;
        cin >> a >> b >> d;

        if(d % gcd(a,b) == 0) cout << "Yes\n";
        else cout << "No\n";
    }
    return 0;

}
