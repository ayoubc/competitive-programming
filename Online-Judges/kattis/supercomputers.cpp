#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
    long int N,K,l,r,i,ones;
    char query;
    cin>>N>>K;
    string memory(N,'0');
    vector <long int> one;
    for(int j=0;j<K;j++){
        cin>>query;
        if(query=='F'){
            cin>>i;
            if(memory[i-1]=='0'){
                memory.replace(i-1,1,"1");
                one.push_back(i-1);
            }
            else{
                memory.replace(i-1,1,"0");
                vector<long>::iterator iter = find(one.begin(),one.end(),i-1);
                if(iter!=one.end()){
                    one.erase(iter);
                }

            }
        }
        else if(query=='C'){
            ones = 0;
            cin>>l>>r;
            long lengh = one.size();
            for(int p=0;p<lengh;p++){
                if(one[p]>=l-1 and one[p]<r){
                    ones++;
                }
            }
            cout<<ones<<endl;
        }
    }
    return 0;
}
