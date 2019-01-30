#include <iostream>
#include<string>

using namespace std;
int indice_recherche(string c);
int main()
{
    int N;
    string suit;
    cin>>N>>suit;
    string name_cards="AKQJT987";
    int value_dominant[8] = {11,4,3,20,10,14,0,0};
    int value_not_dominant[8] = {11,4,3,2,10,0,0,0};
    int i=0,k;
    string card,new_card;
    int result=0;
    while(i<4*N){

        cin>>card;
        k=name_cards.find(card[0]);
        new_card=name_cards[k]+suit;
        if(card.compare(new_card)==0){
            result=result+value_dominant[k];
        }
        else{
            result=result+value_not_dominant[k];
        }
        i++;
    }
    cout<<result<<endl;
    return 0;
}

