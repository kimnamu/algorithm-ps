// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 섬의 개수
// https://www.acmicpc.net/problem/4963
// 힌트
// 1. 모든 섬의 위치를 순회하면서, 
//    한번도 방문한적 없는 새로운 섬의 번호가 나타나면
//    DFS를 활용하여 인접한 섬을 모두 순회한다.
// 2. 이때 인접한 모든 섬은 상하좌우 뿐만 아니라 대각선도 포함됨을 주의하자.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int m, n;
int answer;
vector<vector<int> > table;
vector<vector<bool> > check;

void DFS(int i, int j)
{
    if (check[i][j])
        check[i][j] = false;
    else
        return;
    for (int ii = -1; ii <= 1; ii++)
    {
        for (int jj = -1; jj <= 1; jj++)
        {
            if (ii == 0 && jj == 0)
                continue;
            if (0 <= i + ii && i + ii < n && 0 <= j + jj && j + jj < m)
            {
                DFS(i + ii, j + jj);
            }
        }
    }
}

int main()
{
    while (true)
    {
        cin >> m >> n;
        answer = 0;
        if (m == 0 && n == 0)
            break;
        table = vector<vector<int> >(n, vector<int>(m, false));
        check = vector<vector<bool> >(n, vector<bool>(m, false));
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                cin >> table[i][j];
                if (table[i][j] == 1)
                    check[i][j] = true;
                else
                    check[i][j] = false;
            }
        }
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (table[i][j] == 1 && check[i][j])
                {
                    answer += 1;
                    DFS(i, j);
                }
            }
        }
        cout << answer << endl;
    }
    return 0;
}