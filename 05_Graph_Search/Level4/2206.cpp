// 벽 부수고 이동하기
// https://www.acmicpc.net/problem/2206
// 힌트
// 1. BFS를 통해 시작지점에서 끝점까지 도달하는데 필요한 가장 짦은 거리를 구한다.
// 2. 벽을 부순 경우와, 부수지 않은 경우를 나누너 최소 거리를 갱신해 준다. (check 매트릭스를 2배로 만들어 활용)
#include <iostream>
#include <algorithm>
#include <queue>
#include <vector>
#include <climits>
using namespace std;
const int MAX = 1000;

int dx_array[4] = {1, -1, 0, 0};
int dy_array[4] = {0, 0, -1, 1};

int N, M;
int table[MAX][MAX];
int check[MAX][MAX][2];

int BFS(void)
{
    queue<pair<pair<int, int>, int> > q;
    q.push(make_pair(make_pair(0, 0), 1));
    check[0][0][1] = 1;
    while (!q.empty())
    {
        int y = q.front().first.first;
        int x = q.front().first.second;
        int block = q.front().second;
        q.pop();
        if (y == N - 1 && x == M - 1)
            return check[y][x][block];
        for (int i = 0; i < 4; i++)
        {
            int dy = y + dy_array[i];
            int dx = x + dx_array[i];
            if (0 <= dy && dy < N && 0 <= dx && dx < M)
            {
                if (table[dy][dx] == 1 && block)
                {
                    check[dy][dx][block - 1] = check[y][x][block] + 1;
                    q.push(make_pair(make_pair(dy, dx), block - 1));
                }
                else if (table[dy][dx] == 0 && check[dy][dx][block] == 0)
                {
                    check[dy][dx][block] = check[y][x][block] + 1;
                    q.push(make_pair(make_pair(dy, dx), block));
                }
            }
        }
    }
    return -1;
}
int main(void)
{
    cin >> N >> M;
    for (int i = 0; i < N; i++)
    {
        string s;
        cin >> s;
        for (int j = 0; j < M; j++)
            table[i][j] = s[j] - '0';
    }
    cout << BFS() << endl;
    return 0;
}