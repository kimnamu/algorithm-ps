# 최단경로
# https://www.acmicpc.net/problem/1753
# 힌트
# 1. BFS알고리즘을 이용하면 메모리 초과가 발생한다.
# 2. Dijkstra알고리즘을 이용하여 시작점으로 각 노드에 대한 최단 거리를 구한다.
import sys
import heapq


def dijkstra():
    hq = []

    heapq.heappush(hq, (0, K))

    while len(hq) > 0:
        w, v = heapq.heappop(hq)

        for edge in edges[v]:
            vw, vt = edge
            if min_dist[vt] > min_dist[v] + vw:
                min_dist[vt] = min_dist[v] + vw
                heapq.heappush(hq, (min_dist[vt], vt))


if __name__ == "__main__":
    V, E = map(int, sys.stdin.readline().split())
    K = int(sys.stdin.readline())

    min_dist = [sys.maxsize] * (V+1)
    min_dist[K] = 0

    edges = [[] for _ in range(V + 1)]

    for _ in range(E):
        u, v, w = map(int, sys.stdin.readline().split())
        edges[u].append((w, v))

    dijkstra()

    for i in range(1, V + 1):
        if min_dist[i] == sys.maxsize:
            print('INF')
        else:
            print(min_dist[i])