#include <bits/stdc++.h>

using namespace std;
typedef pair<int,int> pi;
map<int, int> freq;

bool cmp(pi a, pi b){
    if(freq[a.first] == freq[b.first]) return a.second < b.second;
    return freq[a.first] > freq[b.first];
}
int main(){

    //ifstream cin("i.txt");
    int n, c;
    cin >> n >> c;
    vector<pi> v(n);
    map<int,int> minIndex;
    for(int i=0;i<n;i++) {
        cin >> v[i].first;
        freq[v[i].first]++;
        if(freq[v[i].first] == 1){
            v[i].second = i;
            minIndex[v[i].first] = i;
        }
        else{
            v[i].second = minIndex[v[i].first];
        }
    }
    sort(v.begin(), v.end(), cmp);
    for(int i=0;i<n;i++) cout<<v[i].first<< " ";

    return 0;
}
