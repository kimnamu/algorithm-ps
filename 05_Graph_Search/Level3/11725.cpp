// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 트리의 부모 찾기
// https://www.acmicpc.net/problem/11725
// 힌트
// 1. 연결된 노드가 "부모-자식" 인지 "자식-부모"인지 명확하지 않기 때문에, 우선은 모두 연결 해준다.
// 2. 노드1을 루트로 하여 DFS를 통해 모든 노드를 순회한다.
//    이 때, 이전에 방문하지 않았던 새로운 노드를 방문하게 된다면, 새로운 노드의 부모 노드는 input으로 주어진 노드의 번호 된다.
// 3. N이 너무 크기 때문에 N^2의 이차 배열을 만들게 되면 메모리 초과 발생

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N;
vector<vector<int> > table;
vector<int> parent;

void DFS(int p)
{
    int size = table[p].size();
    for (int i = 0; i < size; i++)
    {
        int curr = table[p][i];
        if (parent[curr] == -1)
        {
            parent[curr] = p;
            DFS(curr);
        }
    }
}

int main()
{
    cin >> N;
    table = vector<vector<int> >(N + 1, vector<int>(0, 0));
    parent = vector<int>(N + 1, -1);
    for (int i = 0; i < N; i++)
    {
        int a, b;
        cin >> a >> b;
        table[a].push_back(b);
        table[b].push_back(a);
    }
    DFS(1);
    for (int i = 2; i < N + 1; i++)
    {
        cout << parent[i] << "\n";
    }

    return 0;
}