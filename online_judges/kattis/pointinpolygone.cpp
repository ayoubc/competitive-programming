#include <bits/stdc++.h>
using namespace std;
const double PI = acos(-1) , EPS = 1e-6;
string ANS[3] = {"in","on","out"};
struct point{
    int x,y;
    point() : x(0) , y(0) {}

    point(int _x,int _y) : x(_x) , y(_y) {}

    point operator - (const point P){
        return point(x - P.x, y - P.y);
    }
    bool operator < (const point P){
        if(x==P.x) return y<P.y;
        return x<P.x;
    }
    bool operator == (const point P){
        return x==P.x && y==P.y;
    }
};
double Fix(double x){
    return (x>1 ? 1 : (x<-1 ? -1 : x));
}
double crossP(point p1,point p2){
    return p1.x*p2.y - p1.y*p2.x;
}
double mod(point P){
    return sqrt(P.x * P.x + P.y * P.y);
}
double dotP(point p1,point p2){
    return p1.x * p2.x + p1.y * p2.y;
}
double angle(point p1,point p2,point p3){
    return acos(Fix(dotP(p1 -  p2 , p3 - p2)/(mod(p1 - p2)*mod(p3 - p2))));
}
int ccw(point B,point A ,point C){
    //angle BAC;
    int x = crossP(B-A,C-A);
    return (x>0 ? 1 : (x<0 ? -1 : 0));
}

bool segments_parallel(point a, point b, point c, point d){
    // if (a,b) || (c,d)
    return crossP(a-b,c-d)==0; // sin(x) = 0
}
bool onSegment(point p, point a, point b){
    // p belongs to [a,b] or not
    if (p==a) return true;
    if (p==b) return true;
    if (segments_parallel(p,a,p,b) && dotP(p-a,p-b) < 0) return true; // to check
    return false;
}

int PIP(vector<point> P,point p){
    double sum=0;
    int n = P.size();
    for(int i=0;i<n;i++){
        int j = (i+1)%n , sign = ccw(P[i],p,P[j]);
        if(onSegment(p,P[i],P[j])) return 1;
        double A = angle(P[i],p,P[j]);
        sum += A*sign;
    }
    int ans = (fabs(sum)>PI  ? 0 : 2);
    //int ans = (fabs(fabs(sum) - 2*PI) < EPS  ? 0 : 2); this also works but EPS must be 1e-6 or you'll get WA
    return ans;
}

int main(){
    //freopen("i.txt","r",stdin);
    int n,x,y,m;
    while(scanf("%d",&n)==1 && n!=0){
        vector<point> P;
        for(int i=0;i<n;i++){
            scanf("%d %d",&x,&y);
            P.push_back(point(x,y));
        }
        scanf("%d",&m);
        for(int i=0;i<m;i++){
            point p;
            scanf("%d%d",&p.x,&p.y);
            cout<<ANS[PIP(P,p)]<<endl;

        }
    }
    return 0;
}
