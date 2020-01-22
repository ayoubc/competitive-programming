#include <iostream>

using namespace std;

int main()
{
    int n,distance;
    while(cin>>n){
        if(n==-1){
            break;
        }
        else{
            int *speed = NULL;
            speed = new int[n];
            int *total_time = NULL;
            total_time = new int[n];
            for(int i=0;i<n;i++){
                cin>>speed[i]>>total_time[i];
            }
            distance = speed[0]*total_time[0];
            for(int j=1;j<n;j++){
                distance = distance+speed[j]*(total_time[j]-total_time[j-1]);
            }
            cout<<distance<<" miles"<<endl;
            delete[] speed;
            delete[] total_time;
        }
    }
    return 0;
}
