#include <bits/stdc++.h>

using namespace std;

template<typename T>
struct Tree {
    T value;
    Tree *right;
    Tree *left;
    Tree *parent;
};

template<typename T>
Tree<T> *search_tree(Tree<T> *l, T x) {
    if(l == nullptr) return nullptr;
    if(l->value == x) return l;
    if(x < l->value) return search_tree(l->left, x);
    else return search_tree(l->right, x);
}

template<typename T>
Tree<T> *find_min(Tree<T> *t) {
    Tree<T> *min;
    if(t == nullptr) return nullptr;
    min = t;
    while(min->left != nullptr) {
        min = min->left;
    }

    return min;
}

template<typename T>
Tree<T> *find_max(Tree<T> *t) {
    Tree<T> *max;
    if(t == nullptr) return nullptr;
    max = t;
    while(max->right != nullptr) {
        max = max->right;
    }

    return max;
}


int main () {



    return 0;
}
