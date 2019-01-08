#include <bits/stdc++.h>
using namespace std;
char s[101];
bool isLow(char c){
    return c>='a' && c<='z';
}
bool isUpp(char c){
    return c>='A' && c<='Z';
}
bool isdigit(char c){
    return c>='0' && c<='9';
}
int main(){
    //freopen("i.txt","r",stdin);
    int t;
    scanf("%d",&t);
    while(t--){
        scanf("%s",&s);
        int n = strlen(s);
        int low=0,upp=0,dig=0;
        for(int i=0;i<n;i++){
            if(isLow(s[i])) low++;
            else if(isUpp(s[i])) upp++;
            else dig++;
        }
        int i,j,dis=10000;
        if(low==0 && dig==0){
            for(int k=0;k<n;k++){
                if(isUpp(s[k])){
                    for(int d=k+1;d<n;d++){
                        if(isUpp(s[d])){
                            if(d-k+1<dis){
                                dis = d-k+1;
                                i = k;
                                j = d;
                            }
                        }
                    }
                }
            }
            s[i] = 'a';
            s[j] = '1';
        }
        else if(upp==0 && dig==0){
            for(int k=0;k<n;k++){
                if(isLow(s[k])){
                    for(int d=k+1;d<n;d++){
                        if(isLow(s[d])){
                            if(d-k+1<dis){
                                dis = d-k+1;
                                i = k;
                                j = d;
                            }
                        }
                    }
                }
            }
            s[i] = 'A';
            s[j] = '1';
        }
        else if(upp==0 && low==0){
            for(int k=0;k<n;k++){
                if(isdigit(s[k])){
                    for(int d=k+1;d<n;d++){
                        if(isdigit(s[d])){
                            if(d-k+1<dis){
                                dis = d-k+1;
                                i = k;
                                j = d;
                            }
                        }
                    }
                }
            }
            s[i] = 'A';
            s[j] = 'a';
        }
        else if(low==0){
            for(int k=0;k<n;k++){
                if(dig>=2 && isdigit(s[k])){
                    s[k] = 'a';
                    break;
                }
                if(upp>=2 && isUpp(s[k])){
                    s[k] = 'a';
                    break;
                }
            }
        }
        else if(upp==0){
            for(int k=0;k<n;k++){
                if(dig>=2 && isdigit(s[k])){
                    s[k] = 'A';
                    break;
                }
                if(low>=2 && isLow(s[k])){
                    s[k] = 'A';
                    break;
                }
            }
        }
        else if(dig==0){
            for(int k=0;k<n;k++){
                if(upp>=2 && isUpp(s[k])){
                    s[k] = '1';
                    break;
                }
                if(low>=2 && isLow(s[k])){
                    s[k] = '1';
                    break;
                }
            }
        }
        printf("%s\n",s);
    }
    return 0;
}
