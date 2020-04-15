#include <iostream>

using namespace std;

int main(){

    int t;
    cin >> t;
    while(t--) {

        int n;
        cin >> n;
        int ans;
        if (n == 1) ans = 0;
        else if (n %2 == 0) ans = n/2 - 1;
        else ans = n/2;

        cout << ans << endl;
    }
    return 0;
}
