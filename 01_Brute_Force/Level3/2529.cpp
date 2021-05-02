// 부등호
// https://www.acmicpc.net/problem/2529
// 힌트
// 1. DFS를 이용해 앞자리 부터 부등호 규칙을 만족하는 수를 찾아간다.
// 2. 부등호를 만족시키는 수를 찾을때 9부터 0까지 순서대로 DFS를 통해 찾은 첫 수가 최대값이 된다.
// 2. 부등호를 만족시키는 수를 찾을때 0부터 9까지 순서대로 DFS를 통해 찾은 첫 수가 최소값이 된다.
#include <iostream>
#include <vector>
#include <string>
using namespace std;

// k : 입력 받는 수
// signs : 입력 받는 부호들
// answer : 답을 입력받는 배열
// dp : 한번 사용된 수는 재사용되지 않도록 memoization
// flag : 최대값이든 최소값이든 찾게 되면 dfs 탈출
int k;
vector<char> signs;
vector<int> answer;
vector<bool> dp;
bool flag;

void dfsMin(int num, int numk)
{
    if (numk == k + 1)
    {
        flag = true;
        for (int i = 0; i < answer.size(); i++)
        {
            cout << answer[i];
        }
        cout << endl;
        return;
    }
    for (int i = 0; i < 10; i++)
    {
        if (flag)
            break;
        if (dp[i])
            continue;
        answer[numk] = i;
        dp[i] = true;
        // 부등호를 만족시키는 다음 수 넣어주기
        if (signs[numk - 1] == '<' && num < i)
        {
            dfsMin(i, numk + 1);
        }
        else if (signs[numk - 1] == '>' && num > i)
        {
            dfsMin(i, numk + 1);
        }
        dp[i] = false;
    }
}

void dfsMax(int num, int numk)
{
    if (numk == k + 1)
    {
        flag = true;
        for (int i = 0; i < answer.size(); i++)
        {
            cout << answer[i];
        }
        cout << endl;
        return;
    }
    for (int i = 9; i >= 0; i--)
    {
        if (flag)
            break;
        if (dp[i])
            continue;
        answer[numk] = i;
        dp[i] = true;
        // 부등호를 만족시키는 다음 수 넣어주기
        if (signs[numk - 1] == '<' && num < i)
        {
            dfsMax(i, numk + 1);
        }
        else if (signs[numk - 1] == '>' && num > i)
        {
            dfsMax(i, numk + 1);
        }
        dp[i] = false;
    }
}

int main()
{
    cin >> k;
    signs = vector<char>(k);
    answer = vector<int>(k + 1);

    for (int i = 0; i < k; i++)
    {
        cin >> signs[i];
    }
    // 1. 첫 자리부터 9부터 0까지 대입할때 가장 먼저 부등호를 만족하는 수가 최대값이 된다.
    // flag, dp 초기화
    flag = false;
    dp = vector<bool>(10, false);
    for (int i = 9; i >= 0; i--)
    {
        answer[0] = i;
        dp[i] = true;
        dfsMax(i, 1);
        dp[i] = false;
    }
    // 2. 첫 자리부터 0에서 9까지 대입할때 가장 먼저 부등호를 만족하는 수가 최솟값이 된다.
    // flag, dp 초기화
    flag = false;
    dp = vector<bool>(10, false);
    for (int i = 0; i < 10; i++)
    {
        answer[0] = i;
        dp[i] = true;
        dfsMin(i, 1);
        dp[i] = false;
    }

    return 0;
}