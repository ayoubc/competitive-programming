#include <iostream>

using namespace std;

int main()
{
    char chess[8][8];
    int etoile,queens=0;
    for(int i=0;i<8;i++){
        for(int j=0;j<=7;j++){
            cin>>chess[i][j];
            if(chess[i][j]=='*'){
                queens++;
            }
        }
    }
    if(queens==8){
        bool risque = false;
        for(int i=0;i<=7;i++){
            etoile = 0;
            for(int j=0;j<=7;j++){
                if(chess[i][j]=='*'){
                    etoile++;
                }
            }
            if(etoile!=1){
                cout<<"invalid"<<endl;
                risque = true;
                break;
            }
        }
        if(risque==false){
            for(int i=0;i<=7;i++){
                etoile = 0;
                for(int j=0;j<=7;j++){
                    if(chess[j][i]=='*'){
                        etoile++;
                    }
                }
                if(etoile!=1){
                    cout<<"invalid"<<endl;
                    risque = true;
                    break;
                }
            }
            if(risque==false){
               for(int k=0;k<=7;k++){
                etoile = 0;
                for(int i=0;i<=7-k;i++){
                    if(chess[i][i+k]=='*'){
                        etoile++;
                    }
                }
                if(etoile>1){
                    risque = true;
                    cout<<"invalid"<<endl;
                    break;
                }
                else{
                    etoile = 0;
                    for(int i=0;i<=7-k;i++){
                        if(chess[i+k][i]=='*'){
                            etoile++;
                        }
                    }
                    if(etoile>1){
                        risque = true;
                        cout<<"invalid"<<endl;
                        break;
                    }
                }
            }
            if(risque==false){
                for(int k=0;k<=7;k++){
                    etoile = 0;
                    for(int i=0;i<=7-k;i++){
                        if(chess[7-i-k][i]=='*'){
                            etoile++;
                        }
                    }
                    if(etoile>1){
                        risque = true;
                        cout<<"invalid"<<endl;
                        break;
                    }
                    else{
                        etoile = 0;
                        for(int i=0;i<=7-k;i++){
                            if(chess[i][7-i-k]=='*'){
                                etoile++;
                            }
                        }
                        if(etoile>1){
                            risque = true;
                            cout<<"invalid"<<endl;
                            break;
                        }
                    }
                }
                if(risque==false){
                    cout<<"valid"<<endl;
                }
            }
            }
        }
    }
    else{
        cout<<"invalid"<<endl;
    }
    return 0;
}
//solution accepted:
/*#include<iostream>
#include<vector>
using namespace std;
int main()
{

    char c[8][8];
    int q=0;
    vector<int>line;
    vector<int>col;
    vector<int>diagr;
    vector<int>diagl;
    for(int i=0;i<8;i++)
    {
        for(int j=0;j<8;j++)
        {
            cin>>c[i][j];
            if(c[i][j]=='*')
            {
                q++;
                line.push_back(i);
                col.push_back(j);
                diagr.push_back(i+j);
                diagl.push_back(i-j);
            }
        }
    }

    bool a=true;
    for(int i=0;i<line.size()-1;i++)
    {
        for(int k=i+1;k<line.size();k++)
        {
            if(line[i]==line[k] || col[i]==col[k] || diagl[i]==diagl[k] || diagr[i]==diagr[k])
            {
                a=false;
            }
        }
    }
    if(a==true && q==8)
        cout<<"valid"<<endl;
    else
        cout<<"invalid"<<endl;
    return 0;
}*/


