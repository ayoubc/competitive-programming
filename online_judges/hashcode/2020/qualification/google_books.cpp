#include <bits/stdc++.h>

using namespace std;

const int MAXB = 1e05 + 3;

int scores[MAXB];
struct Book {
    int id, score;

    bool operator< (Book const &b) {
        if(b.score == score) {
            return b.id > id;
        }
        return b.score > score;
    }
};

struct Library {
    int id, n, t, m;
    int total_score;
    int scanf_from;
    vector<Book> books;
    vector<Book> scaned_books;
    Library() : scanf_from(0) {}

    bool has_unscanned_book() {
        for(int i=0;i<books.size();i++){
            if(scores[books[i].id] != -1){
                return true;
            }
        }
        return false;
    }


    /*bool operator< (Library const &l) {

        if(l.total_score * t == total_score * l.t) {
            return l.id > id;
        }
        return l.total_score * t < total_score * l.t;
    }*/
    bool operator< (Library const &l) {

        if(l.t == t) {
            return l.id > id;
        }
        return l.t > t;
    }
};

int get_score(vector<Book> v_b)  {
    int sum = 0;
    for(int i=0;i<v_b.size();i++){
        sum += scores[v_b[i].id];
    }
    return sum;
}

int main() {

    char file_int[10] = "a.txt";
    char file_out[10] = "a_out.txt";
    for(char c='a'; c<='f'; c++){
        file_int[0] = c;
        file_out[0] = c;
        freopen(file_int, "r", stdin);
        freopen(file_out, "w", stdout);

        int B, L, D;

        scanf("%d %d %d", &B, &L, &D);
        vector<Library> libraries(L);
        for(int i=0;i<B;i++)scanf("%d",&scores[i]);

        for(int i=0;i<L;i++) {
            libraries[i].id = i;
            scanf("%d%d%d", &libraries[i].n, &libraries[i].t, &libraries[i].m);
            vector<Book> v(libraries[i].n);
            for(int j=0;j<libraries[i].n;j++) {
                scanf("%d",&v[j].id);
                v[j].score = scores[v[j].id];
            }
            sort(v.begin(), v.end());
            libraries[i].books = v;
            libraries[i].total_score = get_score(v);
        }

        sort(libraries.begin(), libraries.end());

        int limit = 0;
        int total_days = 0;
        for(int i=0;i<L;i++) {
            if(total_days + libraries[i].t > D){
                limit = i-1;
                break;
            }
            else{
                if(libraries[i].has_unscanned_book()){
                    total_days += libraries[i].t;
                    for(int j=0;j<i;j++){
                        int k = libraries[j].scanf_from;
                        while(k < min(libraries[j].m * libraries[i].t, (int)libraries[j].books.size())){
                            if(scores[libraries[j].books[k].id] != -1){
                                libraries[j].scaned_books.push_back(libraries[j].books[k]);
                                scores[libraries[j].books[k].id] = -1;
                            }
                            k++;
                        }
                        libraries[j].scanf_from = k;
                    }
                }

            }
        }

        if(total_days + libraries[L-1].t <= D){
            limit = L-1;
            total_days += libraries[L-1].t;
            for(int k=0;k<libraries[L-1].books.size(); k++){
                if(scores[libraries[L-1].books[k].id] != -1){
                    libraries[L-1].scaned_books.push_back(libraries[L-1].books[k]);
                    scores[libraries[L-1].books[k].id] = -1;
                }
            }
        }

        vector<Library> v;
        for(int i=0;i<=limit;i++) {
            if(libraries[i].scaned_books.size() > 0){
                v.push_back(libraries[i]);
            }
        }
        cout << v.size() << endl;
        for(int i=0;i<v.size();i++) {
            cout << v[i].id << " " << v[i].scaned_books.size() << endl;
            for(int j=0;j<v[i].scaned_books.size();j++) {
                cout << v[i].scaned_books[j].id;
                if(j != v[i].scaned_books.size() - 1) printf(" ");

            }
            if(i != v.size() - 1) printf("\n");
        }
    }
    return 0;
}
