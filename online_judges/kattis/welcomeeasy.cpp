#include <bits/stdc++.h>
using namespace std;
//welcome to code jam
int main(){
//	freopen("i","r",stdin);
	int t;
	long long ans;
	scanf("%d",&t);
//	cin >> t;
	string s;
	cin.ignore();
	for(int z=1;z<=t;z++){
		
		getline(cin,s);
		ans = 0;
		for(int a=0;a<s.size();a++){
			if(s[a]=='w'){
				for(int b=a+1;b<s.size();b++){
					if(s[b]=='e'){
						for(int c=b+1;c<s.size();c++){
							if(s[c]=='l'){
								for(int d=c+1;d<s.size();d++){
									if(s[d]=='c'){
										for(int e=d+1;e<s.size();e++){
											if(s[e]=='o'){
												for(int f=e+1;f<s.size();f++){
													if(s[f]=='m'){
														for(int g=f+1;g<s.size();g++){
															if(s[g]=='e'){
																for(int h=g+1;h<s.size();h++){
																	if(s[h]==' '){
																		for(int i=h+1;i<s.size();i++){
																			if(s[i]=='t'){
																				for(int j=i+1;j<s.size();j++){
																					if(s[j]=='o'){
																						for(int k=j+1;k<s.size();k++){
																							if(s[k]==' '){
																								for(int l=k+1;l<s.size();l++){
																									if(s[l]=='c'){
																										for(int m=l+1;m<s.size();m++){
																											if(s[m]=='o'){
																												for(int n=m+1;n<s.size();n++){
																													if(s[n]=='d'){
																														for(int o=n+1;o<s.size();o++){
																															if(s[o]=='e'){
																																for(int p=o+1;p<s.size();p++){
																																	if(s[p]==' '){
																																		for(int q=p+1;q<s.size();q++){
																																			if(s[q]=='j'){
																																				for(int r=q+1;r<s.size();r++){
																																					if(s[r]=='a'){
																																						for(int u=r+1;u<s.size();u++){
																																							if(s[u]=='m'){
																																								ans++;
																																								ans  %= 10000;
																																							}
																																						}
																																					}
																																				}
																																			}
																																		}
																																	}
																																}
																															}
																														}
																													}
																												}
																											}
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		stringstream ss;
		string str;
		ss << ans , ss >> str;
		int sz = str.size();
		for(int l=1;l<=4-sz;l++){
			str = "0"+str;
		}
		cout<<"Case #"<<z<<": "<<str<<endl;
//		cout<<s<<endl;
	}
	
	return 0;
}

