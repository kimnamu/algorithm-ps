// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 구간 합 구하기 5
// https://www.acmicpc.net/problem/11660
// 힌트
// 1. 매번 구간합을 구하려면 O(N^2 x M)이 계속 발생하므로 하기의 점화식을 이용하여 구간합을 반환해준다.
// - 이 점화식을 이용하면 모든 좌표에 대해 (0,0) 부터 (x,y)의 합을 O(N^2)에 구해 놓을 수 있고, 그후로는 O(1)만에 값을 반환할 수 있어 전체 복잡도가 O(N^2)이 된다.
// - 점화식 : 구간합(x1, y1, x2, y2) = 구간합(0, 0, x1-1, y2) + 구간합(0, 0, x2, y1-1) - 구간합(0, 0, x1-1, y1-1) + 값 (x2, y2)
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    int N, M;
    cin >> N >> M;
    int table[N + 1][N + 1];
    vector<vector<int> > area(N + 1, vector<int>(N + 1, 0));
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            cin >> table[i][j];
        }
    }

    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= N; j++)
        {
            area[i][j] += area[i - 1][j] + area[i][j - 1] - area[i - 1][j - 1] + table[i][j];
        }
    }

    while (M--)
    {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        x1 -= 1;
        y1 -= 1;
        int answer = area[x2][y2] - area[x1][y2] - area[x2][y1] + area[x1][y1];
        cout << answer << "\n";
    }
    return 0;
}