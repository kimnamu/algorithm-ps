// 좌표 정렬하기 2
// https://www.acmicpc.net/problem/11651
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// x, y좌표계 정보를 담는 struct
struct Point
{
    int x, y;
};

// a < b일 때 참이 되도록 return하면 오름차순으로 정렬됨
bool cmp(Point a, Point b)
{
    // y좌표가 같을땐 x좌표로 오름차순 정렬
    if (a.y == b.y)
    {
        return a.x < b.x;
    }
    // y좌표가 다를땐 y좌표로 오름차순 정렬
    return a.y < b.y;
}

int main()
{
    int n;
    cin >> n;
    vector<Point> v(n);
    for (int i = 0; i < n; i++)
    {
        cin >> v[i].x >> v[i].y;
    }
    sort(v.begin(), v.end(), cmp);
    for (int i = 0; i < n; i++)
    {
        cout << v[i].x << " " << v[i].y << "\n";
    }
    return 0;
}