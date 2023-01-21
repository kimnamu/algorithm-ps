// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 가장 긴 증가하는 팰린드롬 부분수열
// https://www.acmicpc.net/problem/16161
// 힌트
// 1. 처음 시작 위치에 left, right 포인터를 주고, 왼쪽으로 하나씩 읽었을때 증가하는 수열에 대해 right 포인터를 같이 옮겨준다.
// 2. 이때 같거나, 감소하는 수열을 만나게 되면 그 지점을 중심으로 좌우 수열이 팰린드롬 수열인지 확인해 준다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    int N;
    int answer = 1;
    cin >> N;
    vector<int> s(N);
    for (int i = 0; i < N; i++)
    {
        cin >> s[i];
    }

    int left = 0;
    int right = 0;
    while (right < s.size() - 1)
    {
        int cnt, l, r;
        if (s[right] < s[right + 1])
        {
            right += 1;
        }
        else
        {
            if (s[right] > s[right + 1])
            {
                cnt = 1;
                l = right - 1;
                r = right + 1;
            }
            else
            {
                cnt = 0;
                l = right;
            }
            r = right + 1;

            while (l >= left and r < s.size())
            {
                if (s[l] == s[r])
                {
                    cnt += 2;
                    l -= 1;
                    r += 1;
                }
                else
                    break;
            }
            answer = max(answer, cnt);

            right += 1;
            left = right;
            right = right;
        }
    }
    cout << answer;
    return 0;
}