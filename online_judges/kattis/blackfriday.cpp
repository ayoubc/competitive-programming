#include <iostream>
#include<sstream>
#include<string>
#include<algorithm>
using namespace std;

int main()
{
    int n,outcame_max;
    cin>>n;
    string sequence ="",not_repete="",outcame;
    for(int k=0;k<n;k++){
        cin>>outcame;
        sequence = sequence+outcame;
    }
    for(int i=0;i<n;i++){
        bool repeted =false;
        for(int j=0;j<n;j++){
            if(i!=j){
                if(sequence[i]==sequence[j]){
                    repeted = true;
                    break;
                }
            }
        }
        if(repeted ==false){
            not_repete = not_repete+sequence[i];
        }
    }
    if(not_repete.compare("")==0){
        cout<<"none"<<endl;
    }
    else{
        int l = not_repete.size();
        int *tab = NULL;
        tab = new int[l];
        for(int m=0;m<l;m++){
            stringstream ss;
            int m_int;
            ss << not_repete[m];
            ss >> m_int;
            tab[m] = m_int;
        }
        outcame_max = *max_element(tab,tab+l);
        stringstream SS;
        string o_str;
        SS << outcame_max;
        SS >> o_str;
        cout<<sequence.find(o_str)+1<<endl;
        delete[] tab;
    }

    return 0;
}
