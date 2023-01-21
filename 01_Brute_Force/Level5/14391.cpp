// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 종이 조각
// https://www.acmicpc.net/problem/14391
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <cstring>
using namespace std;

int board[4][4];
bool visited[4][4];
int n, m, score;
int answer = 0;

void dfs(int r, int c)
{
    // 1. 한칸짜리로 종이 조각내기
    if (visited[r][c])
    {
        if (r == n - 1 && c == m - 1)
        {
            answer = max(answer, score);
            return;
        }

        if (c + 1 < m)
            dfs(r, c + 1);
        else if (r + 1 < n)
            dfs(r + 1, 0);
        return;
    }
    else
    {
        score += board[r][c];
        visited[r][c] = true;
        if (r == n - 1 && c == m - 1)
        {
            answer = max(answer, score);
            score -= board[r][c];
            visited[r][c] = false;
            return;
        }
        if (c + 1 < m)
            dfs(r, c + 1);
        else if (r + 1 < n)
            dfs(r + 1, 0);

        score -= board[r][c];
        visited[r][c] = false;
    }


    // 2. 가로로 긴 직사각형 모양으로 종이 조각 내기
    for (int i = 1; c + i < m; i++)
    {
        if (visited[r][c + i])
            break;
        // 종이조각 값 구하기
        int num = 0;
        for (int j = 0; j <= i; j++)
        {
            num = num * 10 + board[r][c + j];
            visited[r][c + j] = true;
        }
        score += num;

        // 다음 dfs로 넘어가기
        if (c + 1 < m)
            dfs(r, c + 1);
        else if (r + 1 < n)
            dfs(r + 1, 0);

        score -= num;
        for (int j = 0; j <= i; j++)
        {
            visited[r][c + j] = false;
        }
    }

    // 3. 세로로 긴 직사각형 모양으로 종이 조각 내기
    for (int i = 1; r + i < n; i++)
    {
        if (visited[r + i][c])
            break;
        // 종이조각 값 구하기
        int num = 0;
        for (int j = 0; j <= i; j++)
        {
            num = num * 10 + board[r + j][c];
            visited[r + j][c] = true;
        }
        score += num;
        if (c + 1 < m)
            dfs(r, c + 1);
        else if (r + 1 < n)
            dfs(r + 1, 0);

        score -= num;
        for (int j = 0; j <= i; j++)
        {
            visited[r + j][c] = false;
        }
    }

    return;
}

int main()
{
    cin >> n >> m;
    // 초기화
    score = 0;
    for (int i = 0; i < 4; i++)
        memset(visited[i], false, sizeof(bool) * 4);

    //입력값 board에 저장하기
    for (int i = 0; i < n; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < m; j++)
        {
            board[i][j] = s[j] - '0';
        }
    }
    // dfs를 이용한 완전 탐색
    dfs(0, 0);
    cout << answer << endl;
    return 0;
}
