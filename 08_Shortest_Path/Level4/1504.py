# 특정한 최단 경로
# https://www.acmicpc.net/problem/1504
# 1. 다익스트라 알고리즘을 이용하여 v1과 v2로 부터 모든 지점에 대한 최단 거리를 구한다.
# 2. 두 최단거리 배열을 이용하여 1->v1->v2->N 과 1->v2->v1->N 거리 중 더 짧은 거리 거리를 반환한다.
# 3. 이때 하나의 구간이라도 연결이 되어있지 않다면 -1을 반환한다.
# python에서는 pypy3로 컴파일해야 타임아웃이 나지 않는다.

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


if __name__ == "__main__":
    N, E = map(int, sys.stdin.readline().split())

    edges = [[] for _ in range(N + 1)]
    for _ in range(E):
        fr, to, val = list(map(int, sys.stdin.readline().split()))
        edges[fr].append((to, val))
        edges[to].append((fr, val))

    v1, v2 = map(int, sys.stdin.readline().split())

    dist1 = dijkstra(v1)
    dist2 = dijkstra(v2)

    dist_v12 = dist1[v2]
    answer = -1

    if dist1[1] != sys.maxsize and dist_v12 != sys.maxsize and dist2[1] != sys.maxsize:
        answer = dist_v12 + min(dist1[1] + dist2[N], dist1[N] + dist2[1])

    print(answer)

