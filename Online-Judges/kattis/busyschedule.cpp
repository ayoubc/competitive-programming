#include <iostream>
#include<string>
#include<sstream>
#include<vector>
#include<algorithm>
#include<stdio.h>
using namespace std;

int main()
{
    int n;
    while(cin>>n&&n!=0){
        string heure,Z;
        vector <int> AM,PM;
        for(int i=0;i<n;i++){
            cin>>heure>>Z;
            if(Z.compare("a.m.")==0){
                 stringstream Sh,Sm;
                 string subh,subm;
                 int fh,HH,MM;
                 fh = heure.find(":");
                 subh = heure.substr(0,fh);
                 subm = heure.substr(fh+1);
                 Sh << subh,Sm << subm;
                 Sh >> HH ,Sm >> MM;
                 if(HH==12){
                    AM.push_back(MM);
                 }
                 else{
                    AM.push_back(HH*60+MM);
                 }
            }
            else if(Z.compare("p.m.")==0){
                 stringstream Sh,Sm;
                 string subh,subm;
                 int fh,HH,MM;
                 fh = heure.find(":");
                 subh = heure.substr(0,fh);
                 subm = heure.substr(fh+1);
                 Sh << subh,Sm << subm;
                 Sh >> HH ,Sm >> MM;
                 if(HH==12){
                    PM.push_back(MM);
                 }
                 else{
                    PM.push_back(HH*60+MM);
                 }
            }
        }
        sort(AM.begin(),AM.end());
        sort(PM.begin(),PM.end());
        for(int k=0;k<AM.size();k++){
            if(AM[k]<60){
                if(AM[k]<=9){
                    cout<<"12:0"<<AM[k]<<" a.m."<<endl;
                }
                else{
                    cout<<"12:"<<AM[k]<<" a.m."<<endl;
                }
            }
            else{
                if(AM[k]%60<=9){
                    cout<<AM[k]/60<<":0"<<AM[k]%60<<" a.m."<<endl;
                }
                else{
                    cout<<AM[k]/60<<":"<<AM[k]%60<<" a.m."<<endl;
                }
            }
        }
        for(int i=0;i<PM.size();i++){
            if(PM[i]<60){
                if(PM[i]<=9){
                    cout<<"12:0"<<PM[i]<<" p.m."<<endl;
                }
                else{
                    cout<<"12:"<<PM[i]<<" p.m."<<endl;
                }
            }
            else{
                if(PM[i]%60<=9){
                    cout<<PM[i]/60<<":0"<<PM[i]%60<<" p.m."<<endl;
                }
                else{
                    cout<<PM[i]/60<<":"<<PM[i]%60<<" p.m."<<endl;
                }
            }
        }
        printf("\n");
    }
    return 0;
}
