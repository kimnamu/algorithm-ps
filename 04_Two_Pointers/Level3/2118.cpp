// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 두 개의 탑
// https://www.acmicpc.net/problem/2118
// 힌트
// 1. Two pointer를 사용하여 구간합(part2)을 조절한다.
// 2. 구간합(part2)을 구한다면 전체합에서 구간합을 빼면 또 다른 구간합(part1)이 나오게 된다.
// 3. 이때 두 구간합의 최소값이 더 커지도록 two pointer의 left와 right를 하나씩 이동하면서 두 구간합의 최소값의 최대값을 갱신한다.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef long long ll;

int main()
{
    int N;
    cin >> N;
    vector<int> v(N);
    int part1 = 0, part2 = 0;
    for (int i = 0; i < N; i++)
    {
        cin >> v[i];
        part1 += v[i];
    }
    int answer = 0;
    part2 += v[0];
    part1 -= v[0];
    answer = max(answer, min(part1, part2));

    int l = 0, r = 0;
    bool moveLeft = false;
    while (l <= r && l != N - 1)
    {
        if (r == N - 1)
        {
            moveLeft = true;
        }
        else if (l == r)
        {
            moveLeft = false;
        }
        else
        {
            if (min(part1 - v[r + 1], part2 + v[r + 1]) < min(part1 + v[l], part2 - v[l]))
            {
                moveLeft = true;
            }
            else
            {
                moveLeft = false;
            }
        }
        if (moveLeft)
        {
            part1 += v[l];
            part2 -= v[l];
            l += 1;
        }
        else
        {
            r += 1;
            part1 -= v[r];
            part2 += v[r];
        }
        answer = max(answer, min(part1, part2));
    }
    cout << answer << endl;
    return 0;
}