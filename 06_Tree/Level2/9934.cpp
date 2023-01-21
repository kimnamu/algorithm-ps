// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 완전 이진 트리
// https://www.acmicpc.net/problem/9934
// 힌트
// 1. Input으로 들어오는 값들을 하나의 배열에 입력 받았을때, 가운데 값을 중심으로 왼쪽 오른쪽 트리가 만들어짐
// 2. 1의 방식이 재귀함수 방식으로 왼쪽 트리, 오른족 트리에서 동일하게 적용됨
// 3. 트리의 깊이에 따른 vector를 선언하여 입력을 받아놓으면, 나중에 깊이에 따라 출력할 수 있음.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> v;
vector<vector<int> > answer;
void solve(int s, int e, int depth)
{
    if (e - s == 1)
    {
        answer[depth].push_back(v[s]);
    }
    else
    {
        int m = (s + e - 1) / 2;
        answer[depth].push_back(v[m]);
        solve(s, m, depth + 1);
        solve(m + 1, e, depth + 1);
    }
}

int main()
{
    int k;
    int num = 1;
    cin >> k;
    for (int i = 0; i < k; i++)
    {
        num *= 2;
    }
    num -= 1;
    v = vector<int>(num);
    answer = vector<vector<int> >(k);
    for (int i = 0; i < num; i++)
    {
        cin >> v[i];
    }
    solve(0, num, 0);
    for (int i = 0; i < k; i++)
    {
        for (int j = 0; j < answer[i].size(); j++)
        {
            cout << answer[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}