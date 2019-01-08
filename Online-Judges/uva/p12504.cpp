#include <bits/stdc++.h>

using namespace std;
string trans(string s){
    s.replace(0,1,"");
    s.replace(s.size()-1,1,"");
    return s;
}

map<string,string> split(string s){
    map<string,string> mp;
    int i=0,j;
    while(i<s.size()){
        j = i;
        while(j<s.size() && s[j]!=':') j++;
        if(j==s.size()) break;
        string str = s.substr(i,j-i);
        int J = j+1;
        while(j<s.size()){
            if(s[j]==',') break;
            else j++;
        }
        string str2 = s.substr(J,j-J);
        mp[str] = str2;
        i = j+1;
    }
    return mp;
}
int main(){
    //freopen("i","r",stdin);
    int t;
    scanf("%d",&t);
    string olddic , newdic;
    while(t--){
        cin >> olddic;
        cin >> newdic;
        olddic = trans(olddic);
        newdic = trans(newdic);
        map<string,string> mpold = split(olddic);
        map<string,string> mpnew = split(newdic);
        map<string,string> :: iterator it;
        //for(it=mpnew.begin();it!=mpnew.end();it++) cout<<it->first<< " "<<it->second<<endl;
        vector<string> added,removed,changed;
        for(map<string,string> :: iterator it=mpold.begin();it!=mpold.end();it++){
            string key = it->first;
            //cout<<key<<endl;
            if(mpnew[key]=="") removed.push_back(key);
        }
        for(map<string,string> :: iterator it=mpnew.begin();it!=mpnew.end();it++){
            string key = it->first;
            if(mpold[key]=="") added.push_back(key);
        }
        for(map<string,string> :: iterator it=mpold.begin();it!=mpold.end();it++){
            string key = it->first;
            //cout<<key<<endl;
            string value = it->second;
            if(mpnew[key]!="" && mpnew[key] != value && value!=""){
                //cout<<key<<" "<<value<<endl;
                changed.push_back(key);
            }
        }
        //removed = add_remove(olddic,newdic);
        //added = add_remove(newdic,olddic);
        //for(int i=0;i<removed.size();i++) cout<<removed[i]<<endl;
        //for(int i=0;i<added.size();i++) cout<<added[i]<<endl;
        //changed = change(olddic,newdic);
        //for(int i=0;i<changed.size();i++) cout<<changed[i]<<endl;
        sort(removed.begin(),removed.end());
        sort(added.begin(),added.end());
        sort(changed.begin(),changed.end());
        bool ok = true;
        if(removed.size()!=0 || added.size()!=0 || changed.size()!=0) ok = false;

        if(ok) cout<<"No changes"<<endl;
        else{
            if(added.size()!=0){
                cout<<"+";
                for(int i=0;i<added.size();i++){
                    if(i==added.size()-1) cout<<added[i]<<endl;
                    else cout<<added[i]<<",";
                }
            }
            if(removed.size()!=0){
                cout<<"-";
                for(int i=0;i<removed.size();i++){
                    if(i==removed.size()-1) cout<<removed[i]<<endl;
                    else cout<<removed[i]<<",";
                }
            }
            if(changed.size()!=0){
                cout<<"*";
                for(int i=0;i<changed.size();i++){
                    if(i==changed.size()-1) cout<<changed[i]<<endl;
                    else cout<<changed[i]<<",";
                }
            }
        }
        printf("\n");
    }

    /*map<int,int> mp;
    mp[1]=12;
    mp[2] = 13;
    //if(mp[3]==0) printf("not found\n");
    for(map<int,int> :: iterator it=mp.begin();it!=mp.end();it++){
        cout<<it->first<<endl;
    }*/
    return 0;
}
