#include <bits/stdc++.h>

using namespace std;
const double g = 9.81;

template <typename T>
T square(T x) {
    return x * x;
}

bool safe(double y, double h1, double h2) {
    //cout<<y<<endl;
    return (y >= h1 + 1) && (y <= h2 - 1);
}
int main(){
    //freopen("i.txt","r",stdin);
    int n;;
    scanf("%d",&n);
    while(n--) {
        double v0,teta,x1,h1,h2;
        scanf("%lf %lf %lf %lf %lf", &v0, &teta, &x1, &h1, &h2);
        //cout<<v0<<" "<<teta<<endl;
        double y = x1*tan( teta *  M_PI/180.0) - (g * square(x1))/(2 * square(v0) * square(cos(teta *  M_PI/180.0)));
        cout << (safe(y, h1, h2) ? "Safe" : "Not Safe") <<endl;
    }
    return 0;
}
