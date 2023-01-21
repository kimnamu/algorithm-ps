// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 문자열
// https://www.acmicpc.net/problem/1120
// 힌트
// 1. A의 앞뒤에는 B에 맞출 수 있기 때문에, B부분 문자열 중에서 A문자열과 가장 적은 차이가 나는때를 찾아 비교하면 된다.
#include <iostream>
#include <string>
using namespace std;

int distance(string a, string b)
{
    if (a.size() != b.size())
        return -1;
    int ret = 0;
    for (int i = 0; i < a.size(); i++)
    {
        if (a[i] != b[i])
            ret += 1;
    }
    return ret;
}

int main()
{
    string A, B;
    cin >> A >> B;
    int answer = A.size();
    for (int i = 0; i + A.size() <= B.size(); i++)
    {
        int diff = distance(A, B.substr(i, A.size()));
        if (diff < answer)
            answer = diff;
    }
    cout << answer << endl;
    return 0;
}