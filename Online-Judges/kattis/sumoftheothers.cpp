#include <bits/stdc++.h>

using namespace std;
vector<int> split(string str, char spliter) {
    if(spliter != ' '){
        replace(str.begin(), str.end(), spliter, ' ');
    }
    stringstream ss(str);
    int d;
    vector<int> v;
    while(ss >> d){
        v.push_back(d);
    }
    //for(int i=0;i<v.size();i++) cout<<v[i]<<" ";
    //cout<<endl;
    return v;
}
int main(){
    string line;
    while(getline(cin , line)){
        vector<int> v = split(line, ' ');
        int ans;
        for(int i=0;i<v.size();i++){
            int cur = 0;
            for(int j=0;j<v.size();j++){
                if(j!=i) cur += v[j];
            }
            if(cur == v[i]){
                ans  = v[i];
                break;
            }
        }
        cout<<ans<<endl;
    }
    return 0;
}
