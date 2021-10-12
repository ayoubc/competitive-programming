#include <bits/stdc++.h>

using namespace std;


int ans = 0;
class Trie {
private:
	vector<Trie*> children;
	int node_count;
	bool leaf;

public:

	Trie(): children(26), node_count(0), leaf(false){
	};


	void insert(string word) {
		Trie* cur = this;
		int cnt = 0;
		for(int i = word.size()-1; i >= 0 ; i--) {
		  int c = word[i] - 'a';
		  if(cur->children[c] == NULL) {
			if (cur->node_count > 0) {
				ans = max(ans, cnt);
			}
			cur->children[c] = new Trie();
			cur->node_count++;
		  }
		  else cnt ++;
		  cur = cur->children[c];
		}
		cur->leaf = true;
	}
};

int main(){
	Trie* trie = new Trie();
	int n;
	cin >> n;
	for(int i= 0;i<n;i++){
		string s;
		cin >> s;
		trie->insert(s);
	}
	cout << ans << endl;
	return 0;
}
