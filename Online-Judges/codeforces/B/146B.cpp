#include <bits/stdc++.h>

using namespace std;
string toString(int c) {
    stringstream ss;
    string str;
    ss << c;
    ss >> str;
    return str;
}
int toInt(string s) {
    if(s=="") return 0;
    stringstream ss;
    int c;
    ss << s;
    ss >> c;
    return c;
}
int mask(int c) {
    string str = toString(c);
    string s = "";
    for(int i=0;i<str.size();i++){
        if(str[i]== '4' || str[i] == '7') s += str[i];
    }
    return toInt(s);
}
int main() {
    int a,b;
    scanf("%d%d",&a,&b);
    int c = a+1;
    while(mask(c)!=b){
        c++;
    }
    printf("%d\n",c);
    return 0;
}