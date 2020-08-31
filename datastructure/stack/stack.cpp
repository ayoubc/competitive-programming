#include <bits/stdc++.h>
#define Log(x) cout << x << endl
using namespace std;
const int MAX = 1e05+1;
template<class T>
class Stack {
    T arr[MAX];
    size_t sz;
public:
    Stack() {
        sz = 0;
    }

    void push(T x) {
        if(sz > MAX){
            Log("Stack Overflow");
            return;
        }
        sz++;
        arr[sz-1] = x;
    }

    void pop() {
        if(isEmpty()) {
            Log("Stack is empty");
            return;
        }
        sz--;
    }

    T top() {
        if(isEmpty()) {
            Log("stack is empty");
        }
        else{
            return arr[sz - 1];
        }
    }
    bool isEmpty() {
        return sz == 0;
    }
};
int main() {
    Stack<int> st;
    st.push(1);
    st.pop();
    st.push(2);
    st.push(3);
    st.push(4);
    st.pop();
    st.pop();
    st.pop();
    Log(st.top());
    return 0;
}