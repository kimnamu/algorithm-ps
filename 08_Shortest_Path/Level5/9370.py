# 미확인 도착지
# https://www.acmicpc.net/problem/9370
# 힌트
# 1. 다익스트라 알고리즘을 이용하여 S-G-H-Dst 혹은 S-H-G-Dst 경로의 최단 거리를 찾아주는 문제이다.
# 2. 위읭 각 구간별 최단 거리를 구해주고 마지막 Dst까지 최단경로가 되는 정점을 찾아주면 된다.
# python에서는 pypy3로 컴파일해야 타임아웃이 나지 않는다.

import sys
import heapq
MAXNUM = 2010

def dijkstra(start, dist):
    q = []

    heapq.heappush(q, (0, start))
    dist[start] = 0

    while len(q) > 0:
        cost, here = heapq.heappop(q)

        for next, next_cost in v[here]:
            if dist[next] > dist[here] + next_cost:
                dist[next] = dist[here] + next_cost
                heapq.heappush(q, (-dist[next], next))


def solve():
    dijkstra(S, distS)
    dijkstra(G, distG)
    distGH = distG[H]
    dijkstra(H, distH)
    dists.sort()
    for i in range(len(dists)):
        dst = dists[i]
        if distS[dst] == distS[G] + distGH + distH[dst]:
            print(dst, end=' ')
        elif distS[dst] == distS[H] + distGH + distG[dst]:
            print(dst, end=' ')
    print()


if __name__ == "__main__":
    g = int(input())

    for _ in range(g):
        N, M, T = map(int, sys.stdin.readline().split())
        S, G, H = map(int, sys.stdin.readline().split())
        v = [[] for _ in range(MAXNUM)]
        distS = [sys.maxsize] * MAXNUM
        distG = [sys.maxsize] * MAXNUM
        distH = [sys.maxsize] * MAXNUM
        dists = []

        for _ in range(M):
            a, b, c = map(int, sys.stdin.readline().split())
            v[a].append((b, c))
            v[b].append((a, c))

        for _ in range(T):
            a = int(input())
            dists.append(a)

        solve()

