# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 합리적인 이동경로
# https://www.acmicpc.net/problem/2176
# 힌트
# 1. T(=2)로부터 모든 지점의 최단 거리를 구하여, 정점 이동시 2에 가까워지는 합리적인 이동경로 인지 체크하는데 활용한다.
# 2. S(=1)에서 T(=2)까지 가는 모든 합리적인 이동경로를 dfs로 구할 시 시간 초과가 발생하므로 dynamic programming을 활용하여 중간 경로의 값을 저장해서 활용해준다.
import sys
import heapq


def dijkstra(start):
    dist = [sys.maxsize] * (N + 1)
    q = []

    heapq.heappush(q, (0, start))
    dist[start] = 0

    while len(q) > 0:
        cost, here = heapq.heappop(q)

        for next, next_cost in edges[here]:
            if dist[next] > dist[here] + next_cost:
                dist[next] = dist[here] + next_cost
                heapq.heappush(q, (-dist[next], next))

    return dist


def find_path(here):
    if dp[here] != -1:
        return dp[here]

    if here == 2:
        return 1

    ret = 0

    for i in range(len(edges[here])):
        next = edges[here][i][0]
        if dist[here] > dist[next]:
            ret += find_path(next)

    dp[here] = ret

    return ret


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())

    edges = [[] for _ in range(N + 1)]
    dp = [-1] * (N + 1)

    for i in range(M):
        fr, to, val = list(map(int, sys.stdin.readline().split()))
        edges[fr].append((to, val))
        edges[to].append((fr, val))

    dist = dijkstra(2)
    answer = find_path(1)

    print(answer)