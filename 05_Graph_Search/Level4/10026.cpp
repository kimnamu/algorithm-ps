// 적록색약
// https://www.acmicpc.net/problem/10026
// 힌트
// 1. RGB의 서로 다른 색상들에대해 DFS를 활용하여 몇개의 군집으로 나뉘어져있는지 counting한다.
// 2. 적록색약이 R과 G의 구분이 없는 것이므로 모든 R을 G로 바꿔 준 후 1을 반복한다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int N;
vector<vector<char> > table;
vector<vector<bool> > check;

int dx_array[4] = {-1, 1, 0, 0};
int dy_array[4] = {0, 0, -1, 1};

void dfs(int i, int j)
{
    if (check[i][j])
    {
        check[i][j] = false;
    }
    else
    {
        return;
    }
    for (int k = 0; k < 4; k++)
    {
        int dx = i + dx_array[k];
        int dy = j + dy_array[k];
        if (0 <= dx && dx < N && 0 <= dy && dy < N && table[i][j] == table[dx][dy])
        {
            dfs(dx, dy);
        }
    }
}

void convertR2G()
{
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (table[i][j] == 'R')
                table[i][j] = 'G';
        }
    }
}
int main()
{
    cin >> N;
    table = vector<vector<char> >(N, vector<char>(N));
    for (int i = 0; i < N; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < s.size(); j++)
        {
            table[i][j] = s[j];
        }
    }

    int answer1 = 0;
    check = vector<vector<bool> >(N, vector<bool>(N, true));
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (check[i][j])
            {
                answer1 += 1;
                dfs(i, j);
            }
        }
    }

    convertR2G();

    int answer2 = 0;
    check = vector<vector<bool> >(N, vector<bool>(N, true));
    for (int i = 0; i < N; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (check[i][j])
            {
                answer2 += 1;
                dfs(i, j);
            }
        }
    }

    cout << answer1 << " " << answer2 << endl;
    return 0;
}