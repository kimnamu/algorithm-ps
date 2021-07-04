# 트리의 높이와 너비
# https://www.acmicpc.net/problem/2250
# 힌트
# 1. inorder traverse 이용해 각 노드의 열번호를 발견한다.
# 2. traverse를 진행하면서 각 원소의 level을 찾아주고 각 level의 MAX와 MIN을 열번호를 통해 최신화 해줍니다.
# 3. par 값은 저장해서 root 노드를 찾는 용도로 사용합니다.
# 4. inorder traverse를 이용해서 차례대로 pos를 찾아주고 시켜주고, level의 MIN과 MAX를 통해 너비가 가장 넓은 위치를 찾아줍니다.
import sys


def inorder(root, level):
    global max_lvl, pos

    left = v[root][0]
    right = v[root][1]
    if level > max_lvl:
        max_lvl = level
    if left != -1:
        inorder(left, level + 1)

    if min_n[level] > pos:
        min_n[level] = pos
    if max_n[level] < pos:
        max_n[level] = pos
    pos += 1
    if right != -1:
        inorder(right, level + 1)


if __name__ == "__main__":
    N = int(sys.stdin.readline())

    nodes = [0] * 100001
    min_n = [0] * 100001
    max_n = [0] * 100001
    v = [[] for _ in range(100001)]

    for i in range(N):
        p, l, r = map(int, sys.stdin.readline().split())
        v[p] = (l, r)
        nodes[l] = nodes[r] = p

    root = 1
    while nodes[root] != 0:
        root = nodes[root]

    for i in range(1, 10001):
        min_n[i] = 100000
        max_n[i] = 1

    max_lvl, pos = 0, 1
    inorder(root, 1)

    ans = 1
    for i in range(1, max_lvl + 1):
        if max_n[i] - min_n[i] > max_n[ans] - min_n[ans]:
            ans = i

    print(ans,(max_n[ans] - min_n[ans] + 1))