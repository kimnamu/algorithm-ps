# K번째 최단경로 찾기
# https://www.acmicpc.net/problem/1854
# 1. 다익스트라 알고리즘의 원리에 탑승해, 각 지점 별 경로의 길이를 저장하여 해당 지점의 K번째 최단 경로를 찾는다.
# 2. 각 지점 별 도달 경로의 길이를 우선순위 큐를 이용하여 누적시키고, 그 개수가 K개보다 많아지면 가장 긴 경로와의 값을 비교하여 K번째 값만 갱신해 준다.
import sys
import heapq


def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))

    heapq.heappush(answer[1], 0)

    while q:
        cost, here = heapq.heappop(q)

        for next, next_cost in edges[here]:
            next_cost = next_cost + cost

            if len(answer[next]) < K:
                heapq.heappush(answer[next], -next_cost)

                heapq.heappush(q, (next_cost, next))
            elif -answer[next][0] > next_cost:
                heapq.heappop(answer[next])
                heapq.heappush(answer[next], -next_cost)

                heapq.heappush(q, (next_cost, next))


if __name__ == "__main__":
    N, M, K = map(int, sys.stdin.readline().split())

    edges = [[] for _ in range(N + 1)]
    answer = [[] for _ in range(1010)]

    for _ in range(M):
        fr, to, val = list(map(int, sys.stdin.readline().split()))
        edges[fr].append((to, val))

    dijkstra(1)

    for i in range(1, N + 1):
        if len(answer[i]) < K:
            print(-1)
        else:
            print(-answer[i][0])