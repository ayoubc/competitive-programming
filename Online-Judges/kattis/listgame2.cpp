#include <iostream>
#include<fstream>
#include <cmath>
using namespace std;
int is_prime(long p);
long long min_ans(long long e);
int main()
{
	ifstream in("sample.in");
	ofstream out("sample.out");
	int ca=0;
    long long int n,sum,X,prev,n_dist,m_dist,e;
    while(in>>X){
    	//cin>>X;
    	ca++;
    	sum = 0;
    	n_dist = 0;
    	m_dist = 0;
    	n = sqrt(X);
   		if(X%2==0){
    		prev = 0;
       		while(X%2==0){
       			prev++;
           		X = X/2;
       		}
       		if(prev==1){
       			sum++;
			}
			else{
				e = min_ans(prev); 
				if(prev-e>1){
					n_dist++;
				}
				if(prev-e==1){
					m_dist++;
				}
				sum += e;
			}
   		}
    	for(int i=3;i<=n;i=i+2){
    		if(X%i==0){
           		if(is_prime(i)==1){
            		prev =0;
               		while(X%i==0){
               			prev++;
                   		X = X/i;
               		}
               		if(prev==1){
               			sum++;
					}
					else{
						e = min_ans(prev); 
						if(prev-e>1){
							n_dist++;
						}
						if(prev-e==1){
							m_dist++;
						}
						sum += e;
					}	
           	 	}
       	 	}
   		}
   		sum = sum+(n_dist-1)+m_dist/2;
    	if(X==1){
       		out<</*"Case #"<<ca<<": "<<*/sum<<endl;
    	}
    	else{
   	     	out<</*"Case #"<<ca<<": "<<*/sum+1<<endl;
    	}
	}
    
    return 0;
}
int is_prime(long p){
    if (p==2){
        return 1;
    }
    else{
        long q = sqrt(p);
        for(long j=3;j<=q;j=j+2){
            if(p%j==0){
                return 0;
            }
        }
        return 1;
    }
}
long long min_ans(long long e){
	long long  s = 1;
	while(2*e>s*(s+1)){
		s++;
	}
	return s-1; 
}
