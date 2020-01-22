#include <iostream>
#include<vector>
#include<algorithm>
#include<stdio.h>
using namespace std;

int main()
{
//	freopen("i.in","r",stdin);
    int t;
    int Ng,Nm,sold;
    cin>>t;
    for(int k=0;k<t;k++){
        printf("\n");
        int Godz = 0, MechaG = 0;
		scanf("%d %d",&Ng,&Nm);
        if(Ng==0||Nm==0){
            cout<<"uncertain"<<endl;
        }
        else{
            for(int i=0;i<Ng;i++){
                
                scanf("%d",&sold);
                Godz = max(Godz,sold);
            }
            for(int j=0;j<Nm;j++){
                scanf("%d",&sold);
                MechaG = max(MechaG,sold);
            }
            
            if(MechaG > Godz){
                printf("MechaGodzilla");
            }
            else{
            	printf("Godzilla");
            }
        }
    }
    return 0;
}

