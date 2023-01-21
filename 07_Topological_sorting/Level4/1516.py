# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
import sys
from collections import deque
MAXNUM = 501


def topological_sort():
    q = deque()
    for i in range(1, N + 1):
        if depth[i] == 0:
            q.append(i)
            cost[i] = value[i]

    for i in range(1, N + 1):
        x = q.popleft()
        for j in range(0, len(v[x])):
            y = v[x][j]
            cost[y] = max(cost[y], value[y] + cost[x])
            depth[y] -= 1
            if depth[y] == 0:
                q.append(y)


if __name__ == "__main__":
    N = int(input())

    depth = [0] * MAXNUM
    value = [0] * MAXNUM
    cost = [0] * MAXNUM
    v = [[] for _ in range(MAXNUM)]

    for i in range(1, N + 1):
        tp = list(map(int, sys.stdin.readline().split()))
        value[i] = tp[0]
        for x in tp[1:-1]:
            v[x].append(i)
            depth[i] += 1

    topological_sort()

    for i in range(1, N + 1):
        print(cost[i])