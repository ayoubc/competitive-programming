#include <bits/stdc++.h>

using namespace std;
typedef pair<int, int> pi;
typedef pair<int, pi> pipi;
typedef long long ll;
typedef vector<pipi> vpi;

const int N = 200005;

int id[N], sz[N];
int n, d;
vector<vector<int> > x;

void __init() {
    for(int i=0;i<N;i++){
        id[i] = i;
        sz[i] = 1;
    }
}

int root(int i) {
    while(i != id[i]) {
        id[i] = id[id[i]];
        i = id[i];
    }
    return i;
}

void union_(int p, int q) {
    int i = root(p);
    int j = root(q);
    if (sz[i] <= sz[j]) {
        id[i] = j;
        sz[j] += sz[i];
    }

    else {
        id[j] = i;
        sz[i] += sz[j];
    }
}

int compute_dist(int a, int b) {
    int dist = 0;
    for(int i=0;i<d; i++){
        dist += abs(x[a][i] - x[b][i]);
    }
    return dist;
}

long long kruskal(vpi tree){
    ll max_cost = 0;
    for(int i=0;i<tree.size(); i++){
        int a = tree[i].second.first;
        int b = tree[i].second.second;
        int cost = tree[i].first;
        if(root(a) != root(b)) {
            max_cost -= cost;
            union_(a, b);
        }
    }
    return max_cost;
}

int main(){
    __init();
    cin >> n >> d;
    for(int i=0;i<n;i++){
        vector<int> v(d);
        for(int j=0;j<d;j++){
            cin >> v[j];
        }
        x.push_back(v);
    }

    vector<pipi> tree;
    for(int i=0;i<n;i++){
        for(int j=i+1; j<n;j++){
            int w = compute_dist(i, j);
            tree.push_back(make_pair(-w, make_pair(i, j)));
        }
    }
    sort(tree.begin(), tree.end());
    cout << kruskal(tree) << endl;
	return 0;
}
