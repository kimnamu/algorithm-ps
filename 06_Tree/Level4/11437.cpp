// LCA
// https://www.acmicpc.net/problem/11437
// 힌트
// 1. 각 노드 별로 깊이를 저장하고 같은 깊이가 될때까지 더 깊은 노드의 parent를 찾는다.
// 2. 같은 깊이 일때 서로 다른 노드 값을 갖는다면 같은 parent를 갖을때까지 계속해서 parent를 찾는다.
#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
#include <queue>
using namespace std;

int main()
{
    // 1. map을 활용해 input데이터 저장하기
    int N, M, num1, num2;
    cin >> N;
    unordered_map<int, vector<int> > m;
    for (int i = 0; i < N - 1; i++)
    {
        cin >> num1 >> num2;
        if (m.find(num1) != m.end())
            m[num1].push_back(num2);
        else
            m.insert(make_pair(num1, vector<int>(1, num2)));
        if (m.find(num2) != m.end())
            m[num2].push_back(num1);
        else
            m.insert(make_pair(num2, vector<int>(1, num1)));
    }
    // 2. 질문들 저장
    cin >> M;
    vector<pair<int, int> > question(M);
    for (int i = 0; i < M; i++)
    {
        cin >> question[i].first >> question[i].second;
    }

    // 3. 트리 배열과 깊이 배열 만들기
    // tree 배열은 조상 노드를 저장
    // depth 배열은 해당 노드의 깊이 저장
    vector<int> tree(N + 1, 0);
    vector<int> depth(N + 1, 0);
    queue<int> q;

    tree[1] = 1;
    depth[1] = 0;
    q.push(1);
    int d = 0;
    while (q.size() && ++d)
    {
        vector<int> parent(q.size());
        for (int i = 0; i < q.size(); i++)
        {
            parent[i] = q.front();
            q.pop();
        }
        for (int i = 0; i < parent.size(); i++)
        {
            vector<int> child = m[parent[i]];
            for (int j = 0; j < child.size(); j++)
            {
                if (tree[child[j]] == 0)
                {
                    tree[child[j]] = parent[i];
                    depth[child[j]] = d;
                    q.push(child[j]);
                }
            }
        }
    }

    // 4. 가까운 공통조상 찾기
    for (int i = 0; i < question.size(); i++)
    {
        num1 = question[i].first;
        num2 = question[i].second;
        while (true)
        {
            // 공통 조상을 찾으면 출력
            if (num1 == num2)
            {
                cout << num1 << endl;
                break;
            }
            // depth가 같으면 두 노드 모두 조상 노드로 치환
            if (depth[num1] == depth[num2])
            {
                num1 = tree[num1];
                num2 = tree[num2];
                // num1의 depth가 더 깊으면 num1만 조상 노드로 치환
            }
            else if (depth[num1] > depth[num2])
            {
                num1 = tree[num1];
                // num2의 depth가 더 깊으면 num2만 조상 노드로 치환
            }
            else
            {
                num2 = tree[num2];
            }
        }
    }
    return 0;
}