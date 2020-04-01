#include <bits/stdc++.h>

using namespace std;

template<typename T>
class Heap {

public:
    Heap() {
        this->tree.clear();
        this->tree.push_back(0);
    };
    void push(T x) {
        this->tree.push_back(x);
        this->bubble_up(this->tree.size() - 1);
    };
    T pop() {
        if (this->is_empty()) {
            throw "Empty Tree";
        }
        T res = this->tree[1];
        this->tree[1] = this->tree[this->tree.size()-1];
        this->tree.pop_back();
        this->bubble_down(1);
        return res;
    };
    bool is_empty() {
        return this->tree.size() <= 1;
    }

    T top() {
        if (this->is_empty()) {
            throw "Empty Tree";
        }
        return this->tree[1];
    }
private:
    vector<T> tree;
    std::size_t parent(std::size_t index) {
        return index / 2;
    }
    std::size_t left_child(std::size_t index) {
        return 2 * index;
    }
    std::size_t right_child(std::size_t index) {
        return 2 * index + 1;
    }
    void bubble_up(std::size_t index){
        while(index > 1) {
            std::size_t par = this->parent(index);
            if(this->tree[index] > tree[par]) {
                swap(this->tree[index], tree[par]);
                index = par;
            }
            else break;
        }
    }
    void bubble_down(std::size_t index) {
        while (true) {
            std::size_t largest = index;
            std::size_t left = left_child(index);
            std::size_t right = right_child(index);
            if (left < this->tree.size() && this->tree[left] > this->tree[largest]) {
                largest = left;
            }
            if (right < this->tree.size() && this->tree[right] > this->tree[largest]) {
                largest = right;
            }
            if (largest == index) break;
            else {
                swap(this->tree[index], this->tree[largest]);
                index = largest;
            }
        }
    };
};

int main(){

    Heap<int> heap;
    heap.push(10);
    heap.push(101);

    heap.push(11);
    heap.push(12);
    heap.push(1);
    heap.push(0);
    heap.push(110);
    heap.push(1100);
    cout << heap.pop() << endl;
    cout << heap.top() << endl;
    return 0;
}
