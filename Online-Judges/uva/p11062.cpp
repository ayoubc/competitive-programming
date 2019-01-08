#include <bits/stdc++.h>

using namespace std;
bool letter(char c){
    return (c>='a' && c<='z')||(c>='A' && c<='Z');
}
string word(string s){
    string S = "";
    for(int i=0;i<s.size();i++){
        if(s[i]=='-') S += s[i];
        else if(letter(s[i])) S += tolower(s[i]);
    }
    return S;
}
set<string> split(string s){
    set<string> v;
    /*istringstream iss(s);
    do{
        string str;
        iss >> str;
        if(str!="") v.insert(word(str));
    }while(iss);*/
    string w="";
    for(int i=0;i<s.size();i++){
        char c = tolower(s[i]);
        if(letter(c) || c=='-') w+=c;
        else{
            if(w.size()!=0) v.insert(w);
            w = "";
        }
    }
    return v;
}

int main(){
    //freopen("i","r",stdin);
    string text="";
    string line;
    while(getline(cin,line)){
        if(text=="") text += line;
        else if(text[text.size()-1]=='-'){
            text.replace(text.size()-1,1,"");
            text += line;
        }
        else{
            text += " "+line;
        }
    }
    set<string> dic = split(text);
    //cout<<dic.size()<<endl;
    set<string>::iterator it;
    for(it=dic.begin();it!=dic.end();it++){
        cout<<*it<<endl;
    }

    return 0;
}
