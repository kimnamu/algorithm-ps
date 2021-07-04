// 나이트의 이동
// https://www.acmicpc.net/problem/7562
// 힌트
// 1. BFS 알고리즘을 활용하여 시작점을 중심으로 몇 번째 만에 목적지에 다다를 수 있는지 구해보자.
// 2. 시작 위치를 중심으로 총 8가지의 이동을 할 수 있고, 
//    이전에 방문한 적이 없다면 queue에 넣어주어 다음 스텝에서 꺼내서 방문하자.
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
int dx_array[8] = {-2, -1, 1, 2, 2, 1, -1, -2};
int dy_array[8] = {-1, -2, -2, -1, 1, 2, 2, 1};

struct Point
{
    int x = 0;
    int y = 0;
    bool operator==(Point b)
    {
        return x == b.x && y == b.y;
    }
};

Point start, goal;
vector<vector<bool> > check;

int I;

int BFS(Point start)
{
    queue<Point> q;
    q.push(start);
    check[start.x][start.y] = false;
    int answer = 0;
    while (q.size())
    {
        int size = q.size();
        for (int i = 0; i < size; i++)
        {
            Point p = q.front();
            q.pop();
            if (p == goal)
                return answer;
            for (int i = 0; i < 8; i++)
            {
                int dx = p.x + dx_array[i];
                int dy = p.y + dy_array[i];
                if (0 <= dx && 0 <= dy && dx < I && dy < I && check[dx][dy])
                {
                    Point point = {dx, dy};
                    q.push(point);
                    check[dx][dy] = false;
                }
            }
        }
        answer += 1;
    }
    return -1;
}

int main()
{
    int T;
    cin >> T;
    while (T--)
    {
        cin >> I;
        cin >> start.x >> start.y;
        cin >> goal.x >> goal.y;
        check = vector<vector<bool> >(I, vector<bool>(I, true));
        int answer = BFS(start);
        cout << answer << endl;
    }
    return 0;
}