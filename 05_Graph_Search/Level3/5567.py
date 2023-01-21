# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 결혼식
# https://www.acmicpc.net/problem/5567
# 힌트
# 1. BFS를 이용하여 깊이 2까지의 모든 노드의 개수를 파악한다.
import sys
from collections import deque


def bfs(s):

    q = deque()
    q.append(s)
    check[s] = True

    depth = 0
    ans = 0

    while len(q) != 0:
        q_size = len(q)
        if depth == 2:
            return ans

        for i in range(q_size):
            current = q.popleft()

            for j in range(1, N + 1):
                if not check[j] and table[current][j]:
                    check[j] = True
                    q.append(j)
                    ans += 1

        depth += 1
    return 0


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    M = int(sys.stdin.readline())

    table = [[False] * (N + 1) for _ in range(N+1)]

    for i in range(M):
        x, y = map(int, sys.stdin.readline().split())
        table[x][y] = True
        table[y][x] = True

    check = [False] * (N + 1)
    answer = bfs(1)
    print(answer)