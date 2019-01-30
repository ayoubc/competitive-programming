#include <iostream>
#include<string>
#include<sstream>
#include<iomanip>
#include<cmath>
using namespace std;
double fac(int n);
int occurence(string S,char c);
int main()
{
    string word;
    int n,j;
    double res;
    while(cin>>word){
        n = word.size();
        string not_repet="";
        res = fac(n);
        for(int i=0;i<n;i++){
            if(occurence(not_repet,word[i])==0){
                not_repet = not_repet+word[i];
                j = occurence(word,word[i]);
                res = res/fac(j);
            }
        }
        /*stringstream ss;
        string sres;
        ss << res;
        ss >> sres;*/
        cout<<fixed<<setprecision(0)<<ceil(res)<<endl;
    }
    return 0;
}
double fac(int n){
    if(n==0||n==1){
        return 1;
    }
    return n*fac(n-1);
}
int occurence(string S,char c){
    int v = S.size();
    int i=0;
    if(v==0){
        return 0;
    }
    else{
        for(int k=0;k<v;k++){
            if(S[k]==c){
                i++;
            }
        }
        return i;
    }

}
