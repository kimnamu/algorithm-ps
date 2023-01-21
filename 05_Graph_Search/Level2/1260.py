# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# DFS와 BFS
# https://www.acmicpc.net/problem/1260
# 힌트
# 1. DFS와 BFS를 기본적으로 구현할 수 있는지를 확인하는 문제이다.
# 2. 만약 문제를 풀 수 없다면, 이론 공부를 좀 더 할 필요가 있다.
import sys


def dfs(k):
    print(k, end=' ')
    check[k] = True

    for i in range(1, N+1):
        if not check[i] and table[k][i]:
            dfs(i)


def bfs(k):
    q = [k]
    check[k] = True

    while len(q) > 0:
        s = q.pop(0)
        print(s, end=' ')

        for i in range(1, N + 1):
            if not check[i] and table[s][i]:
                check[i] = True
                q.append(i)


if __name__ == "__main__":
    N, M, V = map(int, sys.stdin.readline().split())

    table = [[0] * (N+1) for _ in range(N+1)]

    for _ in range(M):
        a, b = map(int, sys.stdin.readline().split())
        table[a][b] = 1
        table[b][a] = 1

    check = [False] * (N + 1)
    dfs(V)
    print()

    check = [False] * (N + 1)
    bfs(V)