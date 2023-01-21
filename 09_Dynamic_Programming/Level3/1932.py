# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 정수 삼각형
# https://www.acmicpc.net/problem/1932
# 힌트
# 1. 삼각형의 아래로 한줄씩 내려가며, 이전 위 양쪽 값 중 큰 값을 이어 받도록 구한다.
# 2. 각 줄의 양쪽 끝은 선택지 없이 끝값을 그대로 이어받도록 구현한다.
import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())

    clist = []
    for _ in range(N):
        clist.append(list(map(int, sys.stdin.readline().split())))

    dp = [[0] * N for _ in range(N)]
    dp[0][0] = clist[0][0]

    for i in range(1, N):
        for j in range(0, i + 1):
            print(i, j)
            dp[i][j] = max(dp[i-1][max(0, j-1)], dp[i-1][j]) + clist[i][j]

    print(max(dp[N-1]))