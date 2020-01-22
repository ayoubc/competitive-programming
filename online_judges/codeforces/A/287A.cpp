//The closer you think you're, the less you will actually see.
#include <bits/stdc++.h>

using namespace std;

int main(){
//	freopen("input","r",stdin);
//	freopen("output","w",stdout);
	char s[5][5];
	for(int i=0;i<4;i++){
		scanf("%s",&s[i]);
	}
	/*for(int i=0;i<4;i++){
		printf("%s\n",s[i]);
		
	}*/
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			int white=0,black=0;
			for(int k=i;k<=i+1;k++){
				for(int d=j;d<=j+1;d++){
					/*if(s[k][d]=='#')
						black ++;
					else if(s[k][d]=='.')
						white++;
					*/
					printf("%c",s[k][d]);
				}
				printf("\n");
			}

			/*if((white==3 && black==1) || (black==3 && white==1)||(black==4 && white==0)||(black==0 && white==4)){
				printf("YES\n");
				return 0;
			}*/
		}
	}
//	printf("NO\n");*/
	return 0;
}

