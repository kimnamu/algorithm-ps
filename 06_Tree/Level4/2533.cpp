// 사회망 서비스(SNS)
// https://www.acmicpc.net/problem/2533
// 힌트
// 1. Tree구조를 이용한 완전탐색과 DP를 활용한다.
// 2. 현재 정점이 얼리어답터라면, 연결되어 있는 정점도 얼리어답터로 설정하는 경우, 연결되어 있는 정점을 얼리어답터로 설정하지 않는 경우.
//    이 2가지 경우를 모두 비교한 후에 더 최소값으로 값을 저장해 주면 된다.
// 3. 현재 정점이 얼리어답터가 아니라면, 이 현재 정점과 연결되어 있는 정점들은 반드시 얼리어답터여야 한다.
//    따라서 이 경우에는 다음 정점으로 넘어가기 위해서 탐색을 할 때, 연결되어 있는 정점들은 반드시 얼리어답터가 되도록탐색을 진행하면 된다.
#include <iostream>
#include <vector>
#include <cstring>

#define MAX 1000010
using namespace std;

int N;
int dp[MAX][2];
vector<bool> visited;
vector<int> v[MAX];
vector<int> tree[MAX];

void init_tree(int index)
{
    visited[index] = true;
    for (int i = 0; i < v[index].size(); i++)
    {
        int next = v[index][i];
        if (visited[next] == false)
        {
            tree[index].push_back(next);
            init_tree(next);
        }
    }
}

int DFS(int index, int state)
{
    if (dp[index][state] != -1)
        return dp[index][state];
    if (state == 1)
    {
        dp[index][state] = 1;
        for (int i = 0; i < tree[index].size(); i++)
        {
            int next = tree[index][i];
            dp[index][state] += min(DFS(next, 0), DFS(next, 1));
        }
    }
    else
    {
        dp[index][state] = 0;
        for (int i = 0; i < tree[index].size(); i++)
        {
            int next = tree[index][i];
            dp[index][state] += DFS(next, 1);
        }
    }
    return dp[index][state];
}

int main(void)
{
    cin >> N;
    for (int i = 0; i < N - 1; i++)
    {
        int a, b;
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }
    visited = vector<bool>(MAX, false);
    init_tree(1);
    memset(dp, -1, sizeof(dp));

    cout << min(DFS(1, 0), DFS(1, 1)) << endl;
    return 0;
}