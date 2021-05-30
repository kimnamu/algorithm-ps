// 개똥벌레
// https://www.acmicpc.net/problem/3020
// 힌트
// 1. 개똥벌레가 통과하려는 구간(1~h)에 따라 통과해야 하는 장애물의 수를 찾으면 되고 장애물 수는 U자 곡선을 그리게 된다.
// 2. 통과 구간이 정해지면 정렬해놓은 종유석, 석순에 대해 binary search로 파괴해야하는 장애물 수를 구한다.
//    이때 복잡도는 O(NlogN + HlogN) 이 된다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> bottom, top;
int n, h;

int bs(int height)
{
    // 1. 파괴해야하는 석순
    int cnt = 0;
    int l = 0;
    int r = n / 2 - 1;
    int m = -1;
    while (l <= r)
    {
        m = (l + r) / 2;
        if (bottom[m] >= height)
        {
            r = m - 1;
        }
        else
        {
            l = m + 1;
        }
    }
    cnt += n / 2 - r - 1;
    // 2. 파괴해야하는 종유석
    l = 0;
    r = n / 2 - 1;
    m = -1;
    while (l <= r)
    {
        m = (l + r) / 2;
        if (top[m] >= h - height + 1)
        {
            r = m - 1;
        }
        else
        {
            l = m + 1;
        }
    }
    cnt += n / 2 - r - 1;
    return cnt;
}

void solve()
{
    int answer = n;
    int temp;
    int answer_cnt = 0;
    for (int i = 1; i <= h; i++)
    {
        temp = bs(i);
        if (answer == temp)
        {
            answer_cnt += 1;
        }
        // 가장 적은수의 장애물이 나오면 새롭게 카운트 시작
        if (answer > temp)
        {
            answer = temp;
            answer_cnt = 1;
        }
    }
    cout << answer << " " << answer_cnt << endl;
    return;
}

int main()
{
    cin >> n >> h;
    bottom = vector<int>(n / 2);
    top = vector<int>(n / 2);
    for (int i = 0; i < n; i++)
    {
        if (i % 2 == 0)
            cin >> bottom[i / 2];
        else
            cin >> top[i / 2];
    }
    sort(bottom.begin(), bottom.end());
    sort(top.begin(), top.end());
    solve();

    return 0;
}