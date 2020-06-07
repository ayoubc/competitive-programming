#include <bits/stdc++.h>

using namespace std;

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
		for(int i = 0; i < word.size(); i++) {
		  int c = word[i] - 'a';
		  if(cur->children[c] == nullptr) {
			cur->children[c] = new Trie();
		  }
		  cur->node_count++;
		  cur = cur->children[c];
		}
		cur->leaf = true;
	}

	Trie* traverse(string word) {
		Trie* cur = this;
		for (int i = 0; i < word.size(); i++){
			int c = word[i] - 'a';
			if(cur->children[c] == nullptr)
				return nullptr;

			cur = cur->children[c];
		}
		return cur;
	}

	bool search(string word) {
		Trie* cur = this->traverse(word);
		return cur == nullptr ? false : cur->leaf;
	}

    bool starts_with(string prefix) {
        Trie* cur = this->traverse(prefix);
		return cur == nullptr ? false : cur->node_count > 0;
    }
};

int main(){
	Trie* trie = new Trie();
	trie->insert("hello");
	trie->insert("world");
	trie->insert("cplusplus");
	cout<< (trie->search("hello") ? "yes" : "no") << endl;
	cout<< (trie->search("world") ? "yes" : "no") << endl;
	cout<< (trie->search("worl") ? "yes" : "no") << endl;
	cout<< (trie->starts_with("worl") ? "yes" : "no") << endl;
	cout<< (trie->starts_with("cplusp") ? "yes" : "no") << endl;
    cout<< (trie->starts_with("cplusps") ? "yes" : "no") << endl;
	return 0;
}
