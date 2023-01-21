# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 택배
# https://www.acmicpc.net/problem/1719
# 힌트
# 1. 모든 지점간의 최단 거리를 계산해주는 플로이드 와샬 알고리즘을 이용한다.
#    입력받는 지점의 출발점을 지정해 두었다가 최소거리가 갱신되면 갱신된 지점의 출발점으로 현재 출발점을 바꾸어주는 원리이다.
import sys

MAXNUM = 201


def floydmarshall():
    for k in range(1, N + 1):
        for i in range(1, N + 1):
            for j in range(1, N + 1):
                if (dist[i][j] > dist[i][k] + dist[k][j]):
                    dist[i][j] = dist[i][k] + dist[k][j]
                    fr[i][j] = fr[i][k]


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())

    dist = [[0] * MAXNUM for _ in range(MAXNUM)]
    fr = [[0] * MAXNUM for _ in range(MAXNUM)]

    for i in range(MAXNUM):
        for j in range(MAXNUM):
            if i == j:
                dist[i][j] = 0
            else:
                dist[i][j] = sys.maxsize

    for i in range(M):
        a, b, c = map(int, sys.stdin.readline().split())
        dist[a][b] = c
        dist[b][a] = c
        fr[a][b] = b
        fr[b][a] = a

    floydmarshall()

    for i in range(1, N + 1):
        for j in range(1,  N + 1):
            if i == j:
                print('-', end=' ')
            else:
                print(fr[i][j],end=' ')
        print()

