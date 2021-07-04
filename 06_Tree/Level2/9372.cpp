// 상근이의 여행
// https://www.acmicpc.net/problem/9372
// 힌트
// 1. 모든 나라가 연결되어 있다면, 모든 나라를 연결하는 최소의 간선 개수는 N-1개 이다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int T, N, M;
vector<vector<bool> > table;

int main()
{
    cin >> T;
    while (T--)
    {
        cin >> N >> M;
        table = vector<vector<bool> >(N + 1, vector<bool>(N + 1, false));
        for (int i = 0; i < M; i++)
        {
            int a, b;
            cin >> a >> b;
            table[a][b] = true;
            table[b][a] = true;
        }
        cout << N - 1 << "\n";
    }
    return 0;
}