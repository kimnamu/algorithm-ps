# 트리 순회
# https://www.acmicpc.net/problem/1991
# 힌트
# 1. left와 right 값을 갖는 node로 이루어진 배열을 만들어 tree구조로 사용한다.
# 2. PreOrder는 root -> left -> right 순으로 출력한다.
# 3. InOrder는 left -> root -> right 순으로 출력한다.
# 4. PostOrder는 left -> right -> root 순으로 출력한다.
import sys


def pre_order(root):
    if root == '.':
        return
    print(root, end = '')
    pre_order(tree[root]['left'])
    pre_order(tree[root]['right'])


def in_order(root):
    if root == '.':
        return
    in_order(tree[root]['left'])
    print(root, end = '')
    in_order(tree[root]['right'])


def post_order(root):
    if root == '.':
        return
    post_order(tree[root]['left'])
    post_order(tree[root]['right'])
    print(root, end = '')


if __name__ == "__main__":
    N = int(sys.stdin.readline())

    tree = {}

    for i in range(1, N + 1):
        a, b, c = sys.stdin.readline().split()

        tree[a] = {'left': b, 'right': c}

    pre_order('A')
    print()

    in_order('A')
    print()

    post_order('A')
    print()