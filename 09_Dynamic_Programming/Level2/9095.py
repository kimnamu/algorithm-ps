# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 1, 2, 3 더하기
# https://www.acmicpc.net/problem/9095
# 힌트
# 1. 특정 숫자 n을 만들기 위해서는 n-3번째 수로부터 3을 더하거나, n-2번째 수로 부터 2를 더하거나, n-1번째 수로 부터 1을 만드는 방법 밖에 없음을 이용한다.
import sys

if __name__ == "__main__":
    T = int(sys.stdin.readline())

    dp = [0] * 12
    dp[1] = 1 # 1
    dp[2] = 2 # 1+1, 2
    dp[3] = 4 # 1+1+1, 1+2, 2+1, 3
    for i in range(4, 12):
        dp[i] = dp[i-3] + dp[i-2] + dp[i-1]

    for _ in range(T):
        n = int(sys.stdin.readline())
        print(dp[n])