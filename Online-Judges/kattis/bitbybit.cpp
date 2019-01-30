#include <iostream>
#include <string>
#include <stdio.h>
using namespace std;

int main()
{
    int n,i,j;
    while(scanf("%d",&n) and n!=0){
        string memory(32,'?'),instruction;
        for(int k=0;k<n;k++){
            cin>>instruction;
            if(instruction=="SET"){
                cin>>i;
                memory.replace(31-i,1,"1");
            }
            else if(instruction=="CLEAR"){
                cin>>i;
                memory.replace(31-i,1,"0");
            }
            else if(instruction=="AND"){
                cin>>i>>j;
                if(memory[31-i]==memory[31-j]){
                    if(memory[31-i]=='0'){
                        memory.replace(31-i,1,"0");
                    }
                    else if(memory[31-i]=='1'){
                        memory.replace(31-i,1,"1");
                    }
                    else{
                        memory.replace(31-i,1,"?");
                    }
                }
                else{
                    if(memory[31-i]=='0' or memory[31-j]=='0'){
                        memory.replace(31-i,1,"0");
                    }
                    else{
                        memory.replace(31-i,1,"?");
                    }
                }
                //cout<<memory<<endl;
            }
            else if(instruction=="OR"){
                cin>>i>>j;
                if(memory[31-i]==memory[31-j]){
                    if(memory[31-i]=='0'){
                        memory.replace(31-i,1,"0");
                    }
                    else if(memory[31-i]=='1'){
                        memory.replace(31-i,1,"1");
                    }
                    else{
                        memory.replace(31-i,1,"?");
                    }
                }
                else{
                    if(memory[31-i]=='1' or memory[31-j]=='1'){
                        memory.replace(31-i,1,"1");
                    }
                    else if(memory[31-i]=='?' or memory[31-j]=='?'){
                        memory.replace(31-i,1,"?");
                    }
                }
                //cout<<memory<<endl;
            }
        }
        cout<<memory<<endl;
    }

    return 0;
}
