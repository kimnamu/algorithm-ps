# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 벽 부수고 이동하기
# https://www.acmicpc.net/problem/2206
# 힌트
# 1. BFS를 통해 시작지점에서 끝점까지 도달하는데 필요한 가장 짦은 거리를 구한다.
# 2. 벽을 부순 경우와, 부수지 않은 경우를 나누너 최소 거리를 갱신해 준다. (dist 매트릭스를 2배로 만들어 활용)

import sys
from collections import deque

dxy = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def bfs():
    global dist, table

    q = deque()
    q.append((0, 0, 1))
    dist[0][0][1] = 1

    while len(q) > 0:
        y, x, block = q.popleft()

        if y == (N - 1) and x == (M - 1):
            return dist[y][x][block]

        for dx1, dy1 in dxy:
            dy = y + dy1
            dx = x + dx1
            if 0 <= dy < N and 0 <= dx < M:
                if table[dy][dx] == 1 and block == 1:
                    dist[dy][dx][block - 1] = dist[y][x][block] + 1
                    q.append((dy, dx, block - 1))
                elif table[dy][dx] == 0 and dist[dy][dx][block] == 0:
                    dist[dy][dx][block] = dist[y][x][block] + 1
                    q.append((dy, dx, block))
    return -1


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    table = [list(map(int, sys.stdin.readline().strip())) for _ in range(N)]
    dist = [[[0] * 2 for _ in range(M)] for _ in range(N)]
    answer = bfs()

    print(answer)