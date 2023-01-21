# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 녹색 옷 입은 애가 젤다지?
# https://www.acmicpc.net/problem/4485
# 1. bfs를 통해 0,0에서 상, 하, 좌, 우로 한칸씩 순회하며 순회하는 위치에서 최소비용으로 도달할 경우,
#    그 위치를 중심으로 다시 상, 하, 좌, 우를 순회하며 모든 지점의 최소 비용을 갱신한다.
# 2. 해당 위치에서 최소비용으로의 갱신이 일어나지 않으면 그 순회는 멈추도록 한다.
import sys
import heapq

dxy = [(1, 0), (-1, 0), (0, -1), (0, 1)]


def bfs():
    visit = [[0] * N for _ in range(N)]
    visit[0][0] = 1

    dp = [[sys.maxsize] * N for _ in range(N)]
    dp[0][0] = cave[0][0]

    heap = []
    heapq.heappush(heap, [cave[0][0], 0, 0])

    while heap:
        c, x, y = heapq.heappop(heap)
        for dx, dy in dxy:
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < N and visit[nx][ny] == 0:
                dp[nx][ny] = min(dp[nx][ny], dp[x][y] + cave[nx][ny])
                heapq.heappush(heap, [dp[nx][ny], nx, ny])
                visit[nx][ny] = 1

    return dp[N-1][N-1]


if __name__ == "__main__":
    idx = 0

    while True:
        idx += 1
        N = int(input())
        if N == 0:
            break

        cave = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

        ans = bfs()

        print(f'Problem {idx}: {ans}')
