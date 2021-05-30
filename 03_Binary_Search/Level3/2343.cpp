// 기타 레슨
// https://www.acmicpc.net/problem/2343
// 힌트
// 1. 레슨 수가 적힌 배열을 순차적으로 합해가면서, 제한된 블루레이 용량을 초과할 경우 새로운 블루레이로 교환해주면 된다.
//    이때, 제한된 블루레이 용량을 Binary search로 찾으면 된다. 
// 2. Binary Search의 범위를 설정할때 최소값은 적어도 하나의 레슨은 담을 수 있는 용량으로 해야하고, 최대값을 모든 레슨을 한번에 담을 수 있응 용량으로 해야한다.
//    다시 말해, 블루레이 용량의 최소값을 레슨 중 최대값이 되어야하고, 최대값을 레슨의 모든 합이 되어야 한다.
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n, m;
vector<int> v;
int v_right = 0;
int v_left = 0;
bool solve(int limit)
{
    int cnt = 1;
    int lesson = 0;
    for (int i = 0; i < v.size(); i++)
    {
        if (lesson + v[i] > limit)
        {
            cnt += 1;
            lesson = v[i];
        }
        else
        {
            lesson += v[i];
        }
    }
    if (cnt > m)
        return false;
    else
        return true;
}

int bs()
{
    int l = v_left;
    int r = v_right;
    int m = (l + r) / 2;
    while (l <= r)
    {
        m = (l + r) / 2;
        if (solve(m))
        {
            r = m - 1;
        }
        else
        {
            l = m + 1;
        }
    }
    return l;
}

int main()
{
    cin >> n >> m;
    v = vector<int>(n);
    for (int i = 0; i < n; i++)
    {
        cin >> v[i];
        v_right += v[i];
        v_left = max(v_left, v[i]);
    }
    int answer = bs();
    cout << answer << endl;
    return 0;
}