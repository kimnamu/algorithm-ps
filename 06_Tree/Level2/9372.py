# 상근이의 여행
# https://www.acmicpc.net/problem/9372
# 힌트
# 1. 모든 나라가 연결되어 있다면, 모든 나라를 연결하는 최소의 간선 개수는 N-1개 이다.

import sys

if __name__ == "__main__":
    T = int(sys.stdin.readline())

    for _ in range(T):
        N, M = map(int, sys.stdin.readline().split())
        table = [[False] * (N + 1) for _ in range(N + 1)]

        for _ in range(M):
            a, b = map(int, sys.stdin.readline().split())
            table[a][b] = True
            table[b][a] = True

        print(N-1)

