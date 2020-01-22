// this solution is base on geeksforgeeks web site
#include <bits/stdc++.h> 
using namespace std; 
typedef vector<int> vi;
#define UNASSIGNED 0 
#define N 9
class Sudoku {
private:

    int m_N;
    vector<vector<int>> m_grid;

private:

    bool safe_row(int row, int num) {
        for(int i=0;i<m_N;i++) {
            if(m_grid[row][i] == num) 
                return false;
        }
        return true;
    }

    bool safe_col(int col, int num) {
        for(int i=0;i<m_N;i++) {
            if(m_grid[i][col] == num) 
                return false;
        }
        return true;
    }

    bool safe_box(int sr,int sc, int num) {
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(m_grid[i+sr][j+sc] == num) 
                    return false;
            }
        }
        return true;
    }

    bool good_fit(int r, int c, int num) {
        return safe_row(r, num) && safe_col(c, num) && safe_box(r - r%3, c - c%3, num) && m_grid[r][c] == UNASSIGNED;
    }

    bool find_unsigned_cell(int& r, int& c) {
        for(r=0;r<m_N;r++) {
            for(c=0;c<m_N;c++) {
                if(m_grid[r][c] == UNASSIGNED)
                    return true;
            }
        }
        return false;
    }
public:

    Sudoku(vector<vector<int>> grid, int n) {
        m_N = n;
        m_grid = grid;
    }

    bool solve() {
        int r = 0,c = 0;
        if(!find_unsigned_cell(r, c))
            return true;
        
        for(int num=1;num<=9;num++) {
            if(good_fit(r, c, num)) {
                m_grid[r][c] = num;

                if(solve())
                    return true;
                
                m_grid[r][c] = UNASSIGNED;
            }
        }
        return false;
    }

    void print_grid() {
        for(int i=0;i<m_N;i++) {
            for(int j=0;j<m_N;j++) 
                cout<< m_grid[i][j]<< " ";
            cout << endl;
        }
    }
};

int main() {

    vector<vector<int>> grid = {
        {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
		{5, 2, 0, 0, 0, 0, 0, 0, 0}, 
		{0, 8, 7, 0, 0, 0, 0, 3, 1}, 
		{0, 0, 3, 0, 1, 0, 0, 8, 0}, 
		{9, 0, 0, 8, 6, 3, 0, 0, 5}, 
		{0, 5, 0, 0, 9, 0, 6, 0, 0}, 
		{1, 3, 0, 0, 0, 0, 2, 5, 0}, 
		{0, 0, 0, 0, 0, 0, 0, 7, 4}, 
		{0, 0, 5, 2, 0, 6, 3, 0, 0}
    }; 

    Sudoku sdk(grid, N);
    sdk.solve();
    sdk.print_grid();

	return 0;
} 