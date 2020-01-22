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
    for(int i=0;i<v.size();i++) cout<<v[i]<<" ";
    cout<<endl;
    return v;
}
int main(){
    string str("1:-2:3:4:5:6:8");
    split(str, ':');
    str = "1;-2;3;4;5;6;8";
    split(str, ';');
    str = "1 -2 3 4 5 6 8";
    split(str, ' ');
    return 0;
}
