// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 알파벳
// https://www.acmicpc.net/problem/1987
// 힌트
// 1. DFS를 통해 가장 길게 만들수 있는 알파벳의 길이를 갱신한다.
// 2. 이때 한번 지나간 알파벳은 체크해주어 DFS탐색 위치에서 배재해준다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
using namespace std;

vector<vector<int> > table;
int R, C;
int dx_array[4] = {-1, 0, 1, 0};
int dy_array[4] = {0, -1, 0, 1};

vector<bool> alpha(26, true);
int answer = 1;
void DFS(int i, int j, int depth)
{
    answer = max(answer, depth);
    for (int k = 0; k < 4; k++)
    {
        int dx = i + dx_array[k];
        int dy = j + dy_array[k];
        if (0 <= dx && dx < R && 0 <= dy && dy < C && alpha[table[dx][dy]])
        {
            alpha[table[dx][dy]] = false;
            DFS(dx, dy, depth + 1);
            alpha[table[dx][dy]] = true;
        }
    }
}

int main()
{
    cin >> R >> C;
    table = vector<vector<int> >(R, vector<int>(C));
    for (int i = 0; i < R; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < s.size(); j++)
        {
            table[i][j] = s[j] - 'A';
        }
    }
    alpha[table[0][0]] = false;
    DFS(0, 0, 1);
    cout << answer << endl;
    return 0;
}