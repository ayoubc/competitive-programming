#include <bits/stdc++.h>

using namespace std;

int square(int x) {
    return x * x;
}

int main(){
    //freopen("i.txt", "r", stdin);
    int t;
    cin >> t;
    while(t--) {
        int a,b;
        cin >> a >> b;
        int A = square(a + b);
        int B = square(max(2*a, b));
        int C = square(max(a, 2*b));
        int ans = min(min( A, B), C);
        cout << ans << endl;
    }
	return 0;
}
