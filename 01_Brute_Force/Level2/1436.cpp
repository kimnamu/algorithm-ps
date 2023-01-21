// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 영화감독 숌
// https://www.acmicpc.net/problem/1436
// 힌트
// 1. 종말의 수는 6이 적어도 3개만 들어가면 되는게 아니라, 연속해서 3개가 들어가야 한다.
#include <iostream>
using namespace std;

bool count6(int n)
{
    int cnt = 0;
    while (n)
    {
        if (n % 10 == 6)
            cnt += 1;
        else
            cnt = 0;
        if (cnt >= 3)
            return true;
        n /= 10;
    }
    return false;
}

int main()
{
    int N;
    cin >> N;
    int answer = 665;
    while (N)
    {
        answer += 1;
        if (count6(answer))
            N -= 1;
    }
    cout << answer << endl;
    return 0;
}