#include <bits/stdc++.h>

using namespace std;
const double EPS = 1e-9;
const int OO = 1e09;
struct point{
    int x,y;
    point(int _x,int _y) : x(_x) , y(_y) {}

    point operator - (const point &p){
        return point(x - p.x , y - p.y);
    }
    bool operator < (const point p){
        if(x==p.x) return y<p.y;
        return x<p.x;
    }
};
int cross(const point p1,const point p2){
    return p1.x * p2.y - p1.y * p2.x;
}

struct cmp{
    point a0;
    cmp(point x) : a0(x) {}
    bool operator() (point p1 , point p2){
        if(cross(p1 - a0 , p2 - a0)==0){
            if(p1.y==p2.y) return p1.x<p2.x;
            return p1.y<p2.y;
        }
        return cross(p1-a0,p2-a0)<0;
    }
};
vector<point> ConvexHull(vector<point> p){
    vector<point> ch;
    int sz = p.size();
    for(int i=0;i<sz;i++){
        while(ch.size()>1 && cross(ch[ch.size()-1] - p[i],ch[ch.size()-2] - p[i])<=0){
            ch.pop_back();
        }
        ch.push_back(p[i]);
    }
    vector<point> newCH;
    newCH.push_back(ch[0]);
    for(int i=ch.size()-1;i>0;i--) newCH.push_back(ch[i]);
    return newCH;
}
double area(vector<point> p){
    int sum = 0;
    for(int i=1;i<p.size()-1;i++){
        sum += cross(p[i] - p[0] , p[i+1] - p[0]);
    }
    double ans = abs(sum)*1.0/2;
    return ans;
}
int main(){
    //freopen("i","r",stdin);
    int n;
    while(scanf("%d",&n)==1){
        if(n==0) break;

        vector<point> P(n,point(0,0)),CH;

        point Min(OO,OO);
        for(int i=0;i<n;i++){
            scanf("%d%d",&P[i].x,&P[i].y);
            if(Min.y==P[i].y){
                if(Min.x>P[i].x) Min = P[i];
            }
            else if(Min.y>P[i].y){
                Min = P[i];
            }
        }
        sort(P.begin(),P.end(),cmp(Min));
        CH = ConvexHull(P);

        //for(int i=0;i<CH.size();i++) printf("%d %d\n",CH[i].x,CH[i].y);

       // printf("\n");
        printf("%.1f\n",area(CH));
    }
    return 0;
}
