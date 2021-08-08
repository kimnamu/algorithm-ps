# 최소비용 구하기
# https://www.acmicpc.net/problem/1916
# 힌트
# 1. 각 구간 별 단방향으로 주어진 가격임을 주의해야한다.
# 2. 다익스트라 알고리즘을 이용하여 최단 거리를 구하되,
#    주의할 점은 같은 구간에 대해 서로 다른 요금이 주어질 수 있어 최소 요금을 찾고 알고리즘을 적용해야한다.
# python에서는 pypy3로 컴파일해야 타임아웃이 나지 않는다.

import sys
import heapq


def dijkstra(start):
    dist = [sys.maxsize] * (N + 1)
    q = []

    heapq.heappush(q, (0, start))
    dist[start] = 0

    while q:
        cost, here = heapq.heappop(q)

        for next, next_cost in edges[here]:
            if dist[next] > dist[here] + next_cost:
                dist[next] = dist[here] + next_cost
                heapq.heappush(q, (-dist[next], next))

    return dist


if __name__ == "__main__":
    N = int(input())
    M = int(input())

    edges = [[] for _ in range(N + 1)]
    m = {}
    for _ in range(M):
        fr, to, val = map(int, sys.stdin.readline().split())
        if (fr, to) in m:
            m[(fr, to)] = min(m[(fr, to)], val)
        else:
            m[(fr, to)] = val

    for (fr, to), val in m.items():
        edges[fr].append([to, val])

    v1, v2 = map(int, sys.stdin.readline().split())

    dist = dijkstra(v1)

    print(dist[v2])