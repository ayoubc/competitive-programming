#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int toInt(string s) {
    stringstream ss;
    int d;
    ss << s;
    ss >> d;
    return d;
}

int main() {
    //freopen("i.txt","r",stdin);
    string in;
    priority_queue<int> a,b ;

    while(cin >> in) {
        if(in == "#") {
            int ans = -b.top();
            b.pop();
            if(a.size() != b.size()) {
                b.push(-a.top());
                a.pop();
            }
            cout << ans << endl;
        }
        else{
            int d = toInt(in);

            if(b.empty() || d > -b.top()){
                b.push(-d);
                if(b.size() > a.size()+1){
                    a.push(-b.top());
                    b.pop();
                }
            }
            else{
                a.push(d);
                if(a.size() > b.size()){
                    b.push(-a.top());
                    a.pop();
                }
            }
        }
    }
    return 0;
}
