#include <bits/stdc++.h>

using namespace std;
int main()  {
    //ifstream cin("i.txt");
    int t;
    cin >> t;
    for(int j=1;j<=t;j++) {
        string N,A(""),B("");
        cin >> N;
        for(int i=0;i<N.size();i++){
            if(N[i]=='4'){
                A += '2';
                B += '2';
            }
            else{
                A += N[i];
                B += '0';
            }
        }
        int i=0;
        while(B[i]=='0'){
            i++;
        }
        B.replace(0,i,"");
        cout<<"Case #"<<j<<": "<<A<<" "<<B<<endl;
    }
    return 0;
}