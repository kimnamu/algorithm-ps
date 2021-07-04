// 부동산 다툼
// https://www.acmicpc.net/problem/20364
// 힌트
// 1. 땅 번호를 모두 초기화 하여 해당 초기화 값을 가지면 root로 부터 도달할 수 있는 땅으로 간주한다.
// 2. root로부터 도달 가능한 땅이라면, 그 땅을 시작으로 child node는 모두 root로 부터 도달 할 수 없고 그때 root로 부터 가장 가까운 땅은  그 땅이 된다.
// 3. 때문에 그 땅의 모든 child node를 그 땅의 번호로 update해준다.
// * cpp의 경우 ios_base::sync_with_stdio(false); cin.tie(NULL);을 해주지 않으면 시간 초과 발생.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> tree;

void dfs(int index, int value)
{
    if (tree.size() <= index)
        return;
    tree[index] = value;
    dfs(index * 2, value);
    dfs(index * 2 + 1, value);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int N, Q;
    cin >> N >> Q;
    tree = vector<int>(N + 1, -1);
    while (Q--)
    {
        int q;
        cin >> q;
        if (tree[q] == -1)
        {
            tree[q] = q;
            dfs(q * 2, tree[q]);
            dfs(q * 2 + 1, tree[q]);
            cout << 0 << "\n";
        }
        else
        {
            cout << tree[q] << "\n";
        }
    }

    return 0;
}