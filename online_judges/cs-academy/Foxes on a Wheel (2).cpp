#include <bits/stdc++.h>
using namespace std;

const int MAX_N = (int)1e5;

int n, k;
int type[MAX_N + 1];

int match(int i, int j) {
    return type[i] + type[j] == 3;
}

int main() {
    cin >> n >> k;
    
    for (int i = 0; i < k; ++i) {
        int val; cin >> val;
        type[val] = 1;
    }
    for (int i = 0; i < k; ++i) {
        int val; cin >> val;
        type[val] = 2;
    }
    
    int matched = 0;
    for (int i = 1; i < n; ++i) {
        if (match(i, i + 1)) {
            matched += 1;
            i += 1;
        }
    }
    
    int matched2 = match(1, n);
    for (int i = n - 1; i > 2; --i) {
        if (match(i, i - 1)) {
            matched2 += 1;
            i -= 1;
        }
    }
    
    cout << 2 * k - max(matched, matched2) << "\n";
}
