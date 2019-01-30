//slowly but surly!
#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> pi;
pi a[26];
char s[105][105];

vector<pi> V;
bool sameLine(int i,int j,int k){
//	bool D = true,L,O;
//	vector<pi> v;
//	v.push_back(make_pair(V[i].first,V[i].second));
//	v.push_back(make_pair(V[j].first,V[j].second));
//	v.push_back(make_pair(V[k].first,V[k].second));
//	sort(v.begin(),v.end());
//	for(int d=0;d<3;d++){
//		for(int t=0;t<3;t++){
//			D = D && (abs(v[d].first - v[t].first) == abs(v[d].second - v[t].second));
//		}
//	}
//	O = (v[2].first - v[1].first == v[1].first - v[0].first) && (v[2].second - v[1].second == v[1].second - v[0].second);
//	L = (V[i].first==V[j].first && V[j].first==V[k].first)  || (V[i].second==V[j].second && V[j].second==V[k].second);
//	return D || O || L;
	return (V[j].first - V[i].first)*(V[k].second - V[i].second) - (V[k].first - V[i].first)*(V[j].second - V[i].second) == 0;
}
int main(){
//	freopen("i","r",stdin);
	int n;
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%s",&s[i]);
	}
//	for(int i=0;i<n;i++) printf("%s\n",s[i]);

	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			if(s[i][j]!='.'){	
				V.push_back(make_pair(i,j));			
			}
		}
	}
	
	sort(V.begin(),V.end());
	//for(int i=0;i<V.size();i++) cout<<V[i].first<<" "<<V[i].second<<endl;
	long long  ans = 0;
//	for(int i=0;i<V.size();i++){
//		for(int j=0;j<V.size();j++){
//			if(j!=i){
//				for(int k=0;k<V.size();k++){
//					if(k!=j && k!=i){
//						if(sameLine(i,j,k)) ans++;
//					}
//				}
//			}
//		}
//	}
	for(int i=0;i<V.size();i++){
		for(int j=i+1;j<V.size();j++){
			for(int k=j+1;k<V.size();k++){
				if(sameLine(i,j,k)) ans++;
			}
		}
	}
	printf("%lld\n",ans);
	return 0;
}

