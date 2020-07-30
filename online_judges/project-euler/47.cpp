#include <bits/stdc++.h>

using namespace std;
const int N = 1e06+7;
int fact(int x) {
    int cnt = 0;
    for(int i=2;i<=x;i++){
        if (x % i == 0) {
            cnt ++;
            while(x % i == 0) {
                x /= i;
            }
        }
    }
    if(x > 1) cnt++;
    return cnt;
}

int main(){
    clock_t s_time, e_time;

    s_time = clock();

    int consecutive = 4;
    int cnt = 0;
    for(int i=2;i<=N;i++){
        if (cnt == 4) {
            cout << i - cnt << endl;
            break;
        }
        if(fact(i) == consecutive) cnt++;
        else cnt = 0;
    }

    e_time = clock();
    cout << ((double) (e_time - s_time)) / CLOCKS_PER_SEC<< "s"<< endl;
	return 0;
}
