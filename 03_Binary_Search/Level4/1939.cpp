// 중량제한
// https://www.acmicpc.net/problem/1939
// 힌트
// 1. BFS를 활용하여 지정한 중량으로 공장이 이어질 수 있는지 찾는다.
// 2. 여기서 중량의 범위가 방대하므로 binary search를 통해 값을 찾아낸다.
//    이때, 복잡도는 O(nlogc)이다.
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;

int n, m, a, b, c;
int loc1, loc2, weight_max = 0;

int answer = 1;
struct from
{
    int to;
    int weight;
};

vector<from> v[100001];
vector<bool> check(100001);

void bfs(int mid)
{
    queue<int> q;
    check[loc1] = true;
    q.push(loc1);
    while (!q.empty())
    {
        int node = q.front();
        q.pop();

        for (int i = 0; i < v[node].size(); i++)
        {
            from next = v[node][i];
            int n_node = next.to;
            int n_cost = next.weight;
            if (!check[n_node] && n_cost >= mid)
            {
                check[n_node] = true;
                q.push(n_node);
            }
        }
    }
}

void bs()
{
    int start = 1;
    int end = weight_max;
    int mid = -1;
    while (start <= end)
    {
        mid = (start + end) / 2;
        check = vector<bool>(100001, false);
        bfs(mid);
        if (check[loc2])
        {
            answer = max(answer, mid);
            start = mid + 1;
        }
        else
        {
            end = mid - 1;
        }
    }
}

int main()
{
    cin >> n >> m;
    for (int i = 0; i < m; i++)
    {
        cin >> a >> b >> c;
        v[a].push_back({b, c});
        v[b].push_back({a, c});
        weight_max = max(weight_max, c);
    }
    cin >> loc1 >> loc2;
    bs();
    cout << answer << endl;
}