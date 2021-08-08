// 숨바꼭질 3
// https://www.acmicpc.net/problem/13549
// 1. BFS를 이용하여 최단거리로 도달할 수 있는 방법을 찾는다.
// 2. 이때, 우선순위 Queue를 이용하여 2배 위치로 점프할 경우 가중치가 유지되어 먼저 search하도록 해준다.
#include <iostream>
#include <vector>
#include <utility>
#include <deque>
#define MAXNUM 100000

using namespace std;
typedef pair<int, int> pii;

int main()
{
    int n, k;
    cin >> n >> k;
    vector<bool> visit(MAXNUM + 1, false);
    deque<pii > dq;
    dq.push_front(make_pair(n, 0));
    visit[n] = true;

    while (!dq.empty())
    {
        pii curr = dq.front();
        int pos = curr.first;
        int answer = curr.second;
        dq.pop_front();

        visit[pos] = true;

        if (pos == k)
        {
            cout << answer << "\n";
            return 0;
        }

        int l = pos - 1;
        int r = pos + 1;
        int jump = pos * 2;

        if (jump <= MAXNUM && !visit[jump])
        {
            dq.push_front(make_pair(jump, answer));
        }
        if (l >= 0 && !visit[l])
        {
            dq.push_back(make_pair(l, answer + 1));
        }
        if (r <= MAXNUM && !visit[r])
        {
            dq.push_back(make_pair(r, answer + 1));
        }
    }

    return 0;
}