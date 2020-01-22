#include <bits/stdc++.h>

#define mp make_pair
using namespace std;
typedef pair<int,int> pi;

typedef long long ll;
const int mod = (int)1e09 +7;
long  long Min(long long a,long long b){
	return (a<=b) ? a:b;
}


bool sameparity(ll n,ll m){
	return (n%2==0 && m%2==0) || (n%2==1 && m%2==1);
}
int main() {
//	freopen("i.in","r",stdin);
    int n,a;
    scanf("%d",&n);
    int players[3];
    players[2] = 3;
    bool ok = true;
    scanf("%d",&a);
    if(a==players[2]) ok = false;
    else if(a==1){
    	players[0] = 1;
    	players[1] = 3;
    	players[2] = 2;
	}
	else{
		players[1] = 3;
    	players[0] = 2;
    	players[2] = 1;
	}
    for(int i=1;i<n;i++){
    	scanf("%d",&a);
    	if(players[2]==a) ok = false;
    	if(a==players[0]){
    		swap(players[1],players[2]);
		}
		else if(a==players[1]){
			swap(players[0],players[1]);
			swap(players[1],players[2]);
		}
    }
    if(ok) printf("YES\n");
    else printf("NO\n");
    return 0;
}
