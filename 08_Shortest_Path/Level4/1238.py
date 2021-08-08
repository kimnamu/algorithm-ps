# 파티
# https://www.acmicpc.net/problem/1238
# 1. 다익스트라 알고리즘을 이용하여 모든 지점에서 X까지 가는 길의 최소 시간을 계산해준다.
# 2. 다익스트라 알고리즘을 이용하여 역방향의 모든 지점에서 X까지 가는 길의 최소 시간을 계산해준다.
# 3. 정방향과 역방향의 X지점까지의 왕복 거리 합이 가장 큰 값을 반환해준다.


import sys
import heapq


def dijkstra(start, edge):
    dist = [sys.maxsize] * (N + 1)
    q = []

    heapq.heappush(q, (0, start))
    dist[start] = 0

    while len(q) > 0:
        cost, here = heapq.heappop(q)

        for next, next_cost in edge[here]:
            if dist[next] > dist[here] + next_cost:
                dist[next] = dist[here] + next_cost
                heapq.heappush(q, (-dist[next], next))

    return dist


if __name__ == "__main__":
    N, M, X = map(int, sys.stdin.readline().split())
    edges = [[] for _ in range(N + 1)]
    edges_rev = [[] for _ in range(N + 1)]

    for _ in range(M):
        fr, to, val = list(map(int, sys.stdin.readline().split()))
        edges[fr].append((to, val))
        edges_rev[to].append((fr, val))

    dist1 = dijkstra(X, edges)
    dist2 = dijkstra(X, edges_rev)

    answer = 0
    for i in range(1, N + 1):
        answer = max(answer, dist1[i] + dist2[i])

    print(answer)