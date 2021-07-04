// 트리 순회
// https://www.acmicpc.net/problem/1991
// 힌트
// 1. left와 right 값을 갖는 node로 이루어진 배열을 만들어 tree구조로 사용한다.
// 2. PreOrder는 root -> left -> right 순으로 출력한다.
// 3. InOrder는 left -> root -> right 순으로 출력한다.
// 4. PostOrder는 left -> right -> root 순으로 출력한다.

#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N;
struct node
{
    char left;
    char right;
};

vector<node> tree(27);

void PreOrder(char root)
{
    if (root == '.')
        return;
    cout << root;
    PreOrder(tree[root].left);
    PreOrder(tree[root].right);
}

void InOrder(char root)
{
    if (root == '.')
        return;
    InOrder(tree[root].left);
    cout << root;
    InOrder(tree[root].right);
}

void PostOrder(char root)
{
    if (root == '.')
        return;
    PostOrder(tree[root].left);
    PostOrder(tree[root].right);
    cout << root;
}

int main()
{
    cin >> N;
    for (int i = 1; i <= N; i++)
    {
        char a, b, c;
        cin >> a >> b >> c;
        tree[a].left = b;
        tree[a].right = c;
    }
    PreOrder('A');
    cout << "\n";
    InOrder('A');
    cout << "\n";
    PostOrder('A');
    cout << "\n";

    return 0;
}