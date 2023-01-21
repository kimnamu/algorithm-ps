// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 트리의 높이와 너비
// https://www.acmicpc.net/problem/2250
// 힌트
// 1. inorder traverse 이용해 각 노드의 열번호를 발견한다.
// 2. traverse를 진행하면서 각 원소의 level을 찾아주고 각 level의 MAX와 MIN을 열번호를 통해 최신화 해줍니다.
// 3. par 값은 저장해서 root 노드를 찾는 용도로 사용합니다.
// 4. inorder traverse를 이용해서 차례대로 pos를 찾아주고 시켜주고, level의 MIN과 MAX를 통해 너비가 가장 넓은 위치를 찾아줍니다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <cstdio>

using namespace std;
typedef pair<int, int> pii;

int max_lvl = 0, pos = 1, n, p, l, r, root = 1;
int nodes[10001], MIN[10001], MAX[10001];
vector<pii> v(10001);

void inorder(int root, int level)
{
    int left = v[root].first;
    int right = v[root].second;
    if (level > max_lvl)
        max_lvl = level;
    if (left != -1)
        inorder(left, level + 1);
    if (MIN[level] > pos)
        MIN[level] = pos;
    if (MAX[level] < pos)
        MAX[level] = pos;
    pos += 1;
    if (right != -1)
        inorder(right, level + 1);
}
int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
    {
        cin >> p >> l >> r;
        v[p] = pii(l, r);
        nodes[l] = nodes[r] = p;
    }
    while (nodes[root] != 0)
        root = nodes[root];
    for (int i = 1; i <= 10000; i++)
        MIN[i] = 100000, MAX[i] = 1;
    inorder(root, 1);
    int ans = 1;
    for (int i = 1; i <= max_lvl; i++)
    {
        if (MAX[i] - MIN[i] > MAX[ans] - MIN[ans])
            ans = i;
    }
    cout << ans << " " << MAX[ans] - MIN[ans] + 1;
}