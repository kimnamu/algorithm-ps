# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 작업
# https://www.acmicpc.net/problem/2056
# 힌트
# 1. 전에 작업에 걸리는 시간을 위상정렬을 통해 구한다.
# - i번까지 작업을 완료하는데 걸리는 시간을 cost[i]라고 하고, 처음에 0으로 초기화 한다.
# - depth[i] == 0 인 정점들만 작업하는데 걸리는 시간으로 cost를 초기화 한다.
# - 위상정렬된 순서대로 정점들을 방문하면서 cost[next] = max(cost[next], cost[curr]+work[next])로 초기화해준다.
# - 위상정렬 후 cost[i]중 최대값을 출력한다.
import sys
from collections import deque

MAXNUM = 10001


if __name__ == "__main__":
    N = int(input())

    depth = [0] * MAXNUM
    cost = [0] * MAXNUM
    v = [0] * MAXNUM
    adj = [[] for _ in range(MAXNUM)]

    for i in range(1, N+1):
        tp = list(map(int, sys.stdin.readline().split()))
        v[i] = tp[0]
        for val in tp[2:]:
            adj[val].append(i)
            depth[i] += 1

    q = deque()
    for i in range(1, N + 1):
        if depth[i] == 0:
            q.append(i)
            cost[i] = v[i]

    while q:
        x = q.popleft()
        for j in range(0, len(adj[x])):
            y = adj[x][j]
            cost[y] = max(cost[y], v[y] + cost[x])
            depth[y] -= 1
            if depth[y] == 0:
                q.append(y)

    answer = 0
    for i in range(1, N + 1):
        answer = max(answer, cost[i])

    print(answer)

