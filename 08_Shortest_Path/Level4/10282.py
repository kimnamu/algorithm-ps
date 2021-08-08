# 해킹
# https://www.acmicpc.net/problem/10282
# 1. 다익스트라 알고리즘을 활용하여 가장 처음 감염된 C로 부터 다른 노드까지의 최단거리를 구하면 된다.

import sys
import heapq

def dijkstra(start):
    dist = [sys.maxsize] * (N + 1)
    q = []

    heapq.heappush(q, (start, 0))
    dist[start] = 0

    while q:
        here, cost = heapq.heappop(q)

        if dist[here] < -cost:
            continue

        for next, next_cost in edges[here]:
            if dist[next] > dist[here] + next_cost:
                dist[next] = dist[here] + next_cost
                heapq.heappush(q, (next, -dist[next]))

    return dist


if __name__ == "__main__":
    T = int(input())

    for _ in range(T):
        N, D, C = map(int, sys.stdin.readline().split())

        v = [0] * (N + 1)
        edges = [[] for _ in range(N + 1)]

        for _ in range(D):
            a, b, c = map(int, sys.stdin.readline().split())
            edges[b].append((a, c))
            v[a] += 1

        dist = dijkstra(C)

        cnt = 0
        mx = 0

        for i in range(1, N + 1):
            if dist[i] != sys.maxsize:
                cnt += 1
                mx = max(mx, dist[i])

        print(cnt, mx)
