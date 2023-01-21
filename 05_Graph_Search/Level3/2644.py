# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 촌수계산
# https://www.acmicpc.net/problem/2644
# 힌트
# 1. 부모-자식, 자식-부모 와같이 특별히 순서는 상관 없다.
# 2. BFS를 통해 목표로 하는 노드를 찾는데 걸리는 스텝이 촌수계산의 답이 됩니다.
import sys
from collections import deque


def bfs(s, e):
    ans = 0

    q = deque()
    q.append(s)
    check[s] = True

    while len(q) != 0:
        q_size = len(q)
        for i in range(q_size):
            current = q.popleft()

            if current == end:
                return ans

            for j in range(1, N + 1):
                if not check[j] and table[current][j]:
                    check[j] = True
                    q.append(j)

        ans += 1
    return -1


if __name__ == "__main__":
    N = int(sys.stdin.readline())

    start, end = map(int, sys.stdin.readline().split())
    M = int(sys.stdin.readline())

    check = [False] * (N + 1)
    table = [[False] * (N + 1) for _ in range(N + 1)]

    for i in range(M):
        x, y = map(int, sys.stdin.readline().split())
        table[x][y] = True
        table[y][x] = True

    answer = bfs(start, end)

    print(answer)