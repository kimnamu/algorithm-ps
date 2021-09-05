# 계단 오르기
# https://www.acmicpc.net/problem/2579
# 힌트
# 1. 연달아 세 계단을 밟을 수 없으므로 직전 계단을 안밟은 경우, 직전 계단을 밟은 경우를 나누어 dynamic programming 해준다.
import sys


if __name__ == "__main__":
    n = int(sys.stdin.readline())
    v = []
    for _ in range(n):
        v.append(int(sys.stdin.readline()))
    v.append(0)
    dp = [[0] * n for _ in range(2)]

    if n >= 1:
        dp[0][0] = v[0]
        dp[1][0] = v[0]
    if n >= 2:
        dp[0][1] = v[1]
        dp[1][1] = v[0] + v[1]

    for i in range(2, n):
        dp[0][i] = v[i] + max(dp[0][i - 2], dp[1][i - 2])
        dp[1][i] = v[i] + dp[0][i - 1]

    print(max(dp[0][n-1], dp[1][n-1]))
