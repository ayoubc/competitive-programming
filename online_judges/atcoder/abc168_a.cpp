#include <bits/stdc++.h>

using namespace std;

string ans[] = {"pon", "pon", "hon", "bon", "hon", "hon", "pon", "hon","pon", "hon"};

int main(){
    int n;
    cin >> n;
    cout << ans[n % 10] << endl;
	return 0;
}
