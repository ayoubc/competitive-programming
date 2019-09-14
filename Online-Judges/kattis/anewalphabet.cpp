#include <bits/stdc++.h>

using namespace std;
string str[26] = {"@", "8", "(", "|)", "3", "#", "6", "[-]", "|", "_|", "|<", "1", "[]\\/[]",
                "[]\\[]", "0", "|D", "(,)", "|Z", "$", "']['", "|_|", "\\/", "\\/\\/", "}{", "`/", "2"};

int getId(char c) {
    if(c>='a' && c<='z') return c - 'a';
    else if(c>='A' && c<='Z') return c - 'A';
    else return -1;
}
int main(){
    string s;
    getline(cin ,  s);
    string ans = "";
    for(int i=0;i<s.size();i++){
        int id = getId(s[i]);
        if(id == -1){
            ans += s[i];
        }
        else{
            ans += str[id];
        }
    }
    cout<<ans<<endl;
    return 0;
}
