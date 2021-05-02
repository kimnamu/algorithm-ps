// 2048(Easy)
// https://www.acmicpc.net/problem/12100
#include <iostream>
#include <vector>
#include <algorithm>
#include <stack>
using namespace std;

int result = 0;

// 블록을 시계방향으로 회전시켜주는 함수
vector<vector<int> > turnRight(vector<vector<int> > board)
{
    int n = board.size();
    vector<vector<int> > ret(n, vector<int>(n));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            ret[j][n - 1 - i] = board[i][j];
        }
    }
    return ret;
}

vector<vector<int> > move(int k, vector<vector<int> > board)
{
    // 4방향에 대해 각각 코드를 짜주는것이 아닌,
    // 전체 block을 미리 회전 시켜 각 방향으로 합쳐주는 효과를 준다.
    for (int i = 0; i < k; i++)
    {
        board = turnRight(board);
    }
    // stack을 이용해 top block과 새로 push되는 block이 같으면 합쳐준다.
    for (int i = 0; i < board.size(); i++)
    {
        stack<int> block;
        for (int j = board.size() - 1; j >= 0; j--)
        {
            if (board[i][j] != 0)
            {
                if (block.size() == 0)
                    block.push(board[i][j]);
                else if (block.top() == board[i][j])
                {
                    block.pop();
                    // 한번 합쳐준 block은 다시 합쳐지면 안되므로 +1을 해주어 다시 합쳐지지 않도록 함.
                    // block 특성상 모두 짝수이기 때문에 가능한 방법이다.
                    block.push(board[i][j] * 2 + 1);
                }
                else
                {
                    block.push(board[i][j]);
                }
            }
            board[i][j] = 0;
        }
        while (block.size())
        {
            int b = block.top();
            // 합쳐져서 홀수로 입력된 block을 다시 원래값인 짝수로 변환해준다.
            if (b % 2 == 1)
                b -= 1;
            result = max(result, b);
            board[i][board.size() - block.size()] = b;
            block.pop();
        }
    }
    // 다시 원래 board 방향으로 돌려놓는다.
    if (k != 0)
        for (int i = 0; i < 4 - k; i++)
        {
            board = turnRight(board);
        }
    return board;
}

// 4가지 방향으로의 움직임에 대해 dfs를 활용하여 완전탐색을 해준다.
void dfs(vector<vector<int> > board, int cnt)
{
    if (cnt == 0)
        return;
    for (int i = 0; i < 4; i++)
        dfs(move(i, board), cnt - 1);
    return;
}

int main()
{
    int n;
    cin >> n;
    vector<vector<int> > board(n, vector<int>(n, 0));
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> board[i][j];
        }
    }
    dfs(board, 5);
    cout << result << endl;
    return 0;
}