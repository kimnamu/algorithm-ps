# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 평범한 배낭
# https://www.acmicpc.net/problem/12865
# 힌트
# 1. dp[i][j]는 1부터 i번째 물품 중 무게의 합이 j인 경우의 가치 합이다.
# 2. dp[i][j]는 i번째 물건을 담는 경우와 담지 않는 경우의 최대값을 넣어준다.
import sys

if __name__ == "__main__":
    N, K = map(int, sys.stdin.readline().split())
    bag = []
    for _ in range(N):
        w, v = map(int, sys.stdin.readline().split())
        bag.append((w,v))

    dp = [[0] * (K + 1) for _ in range(N)]

    for i in range(N):
        for j in range(1, K + 1):
            if j - bag[i][0] >= 0:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - bag[i][0]] + bag[i][1])
            else:
                dp[i][j] = dp[i - 1][j]

    print(dp[N-1][K])