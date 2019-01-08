#include <bits/stdc++.h>

using namespace std;
typedef pair<int,int> pi;
int toInt(string s){
    stringstream ss;
    int n;
    ss << s; ss >> n;
    return n;
}
vector<string> split(string s){
    vector<string> v;
    istringstream iss(s);
    do{
        string str;
        iss >> str;
        if(str!="") v.push_back(str);
    }while(iss);
    return v;
}
const int N = 3005;
int queries[N];
int main(){
    //freopen("i","r",stdin);
    string line;
    int  qId,period,k;
    priority_queue<pi> pq;
    while(getline(cin,line)){
        vector<string> all = split(line);
        if(all.size()==3){
            qId = toInt(all[1]);
            queries[qId] = toInt(all[2]);
            pq.push(make_pair(-queries[qId],-qId));
        }
        else{
            if(all[0]!="#"){
                k = toInt(all[0]);
                break;
            }
        }
    }
    while(k--){
        pi p = pq.top();pq.pop();
        qId = p.second;
        period = p.first;
        cout<<-qId<<endl;
        pq.push(make_pair(period-queries[-qId],qId));
    }
    return 0;
}
