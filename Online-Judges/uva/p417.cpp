#include <bits/stdc++.h>

using namespace std;
string a[26] = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
                    "n","o","p","q","r","s","t","u","v","w","x","y","z"};
bool cmp(string s1,string s2){
    if(s1.size()==s2.size()){
        return s1<s2;
    }
    return s1.size()<s2.size();
}
vector<string> genAll(){
    vector<string> v;
    queue<string> q;
    for(int i=0;i<26;i++){
        q.push(a[i]);
    }
    while(!q.empty()){
        string s = q.front();
        q.pop();
        int n = s.size();
        if(n>5) continue;
        v.push_back(s);
        //cout<<s<<endl;
        for(int i=0;i<26;i++){
            char c = 'a'+i;
            if(s[n-1]<c) q.push(s+c);
        }
    }
    sort(v.begin(),v.end(),cmp);
    return v;
}


int main(){
    vector<string> all = genAll();
    //freopen("i","r",stdin);
    map<string,int> mp;
    for(int i=0;i<all.size();i++){
        mp[all[i]] = i+1;
    }
    //for(int i=0;i<all.size();++i)cout<<all[i]<<endl;
    //cout<<all.size()<<endl;
    //cout<<all[50];
    /*for(int i=0;i<26;i++){
        char c = 'a'+i;
        cout<<c<<endl;
    }*/
    string s;
    while(cin >> s){
        cout<<mp[s]<<endl;
    }
    return 0;
}
