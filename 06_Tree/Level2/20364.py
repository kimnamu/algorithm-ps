# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 부동산 다툼
# https://www.acmicpc.net/problem/20364
# 힌트
# 1. 땅 번호를 모두 초기화 하여 해당 초기화 값을 가지면 root로 부터 도달할 수 있는 땅으로 간주한다.
# 2. root로부터 도달 가능한 땅이라면, 그 땅을 시작으로 child node는 모두 root로 부터 도달 할 수 없고 그때 root로 부터 가장 가까운 땅은  그 땅이 된다.
# 3. 때문에 그 땅의 모든 child node를 그 땅의 번호로 update해준다.
import sys
sys.setrecursionlimit(10000)


def dfs(index, value):
    if len(tree) <= index:
        return
    tree[index] = value
    dfs(index * 2, value)
    dfs(index * 2 + 1, value)


if __name__ == "__main__":
    N, Q = map(int, sys.stdin.readline().split())

    tree = [-1] * (N + 1)

    for _ in range(Q):
        q = int(sys.stdin.readline())

        if tree[q] == -1:
            tree[q] = q
            dfs(q * 2, tree[q])
            dfs(q * 2 + 1, tree[q])
            print(0)
        else:
            print(tree[q])