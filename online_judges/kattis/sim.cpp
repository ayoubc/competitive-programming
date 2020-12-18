#include<bits/stdc++.h>

using namespace  std;

bool isValid(char c){
    return c!='<' && c!='[' && c!=']';
}

string solve(string text){
    deque<vector<char> > ans;
    vector<char> acc_front;
    vector<char> acc_back;
    string insert_in = "back";
    for(int i=0;i < text.size(); i++){
        char c = text[i];
        if (isValid(c)) {
            if (insert_in == "back") acc_back.push_back(c);
            else acc_front.push_back(c);
        }

        else if (c == '<') {
            if(insert_in == "back"){
                if (acc_back.size() > 0) acc_back.pop_back();
                else if (ans.size() > 0){
                    vector<char> tmp = ans.back();
                    ans.pop_back();
                    tmp.pop_back();
                    if(tmp.size() > 0){
                        ans.push_back(tmp);
                    }
                }
            }
            else{
                if (acc_front.size() > 0) acc_front.pop_back();
            }
        }
        else {
            if (c == ']') insert_in = "back";
            else insert_in = "front";
            if (acc_back.size() > 0) ans.push_back(acc_back);
            if (acc_front.size() > 0) ans.push_front(acc_front);
            acc_back.clear();
            acc_front.clear();
        }

    }

    if (acc_back.size() > 0) ans.push_back(acc_back);
    if (acc_front.size() > 0) ans.push_front(acc_front);

    string res = "";
    for(vector<char> v: ans){
        for(int i=0;i<v.size();i++){
            res += v[i];
        }
    }
    return res;

}
int main() {
    int t; cin >> t;
    cin.ignore();
    for(int tc=0;tc<t;tc++){
        string text;
        getline(cin, text);
        cout << solve(text) << endl;
    }
    return 0;
}
