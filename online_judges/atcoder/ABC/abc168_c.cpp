#include <bits/stdc++.h>

using namespace std;
double const PI = acos(-1);

int main(){
    //freopen("i.txt", "s", stdin);
    int a,b,h,m;
    cin >> a >> b >> h >> m;
    int x = h*60+m;
    double mang = (m * 360.0) / 60.0;
    double hang = (x  * 360.0) / (12 * 60.0);
    //cout << PI << endl;
    double ans = a*a + b*b - 2*a*b*cos((mang - hang) * PI / 180.0);
    printf("%.12f", sqrt(ans) );

	return 0;
}
