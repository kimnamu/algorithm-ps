# RGB거리
# https://www.acmicpc.net/problem/1149
# 힌트
# 1. Bottom UP Dynamic Programming을 이용하여 순차적으로 가장 작은 값이 되는 답을 찾는다.
# 2. 이때, 각 색깔이 연달아 이어지면 안되기 때문에 이번에 R을 선택할 경우 이전 G, B 중 최소거리 값을 이어 받도록한다. G, B도 마찬가지이다.
import sys

if __name__ =="__main__":
    N = int(sys.stdin.readline())

    c_list = []
    for _ in range(N):
        r, g, b = map(int, sys.stdin.readline().split())
        c_list.append([r,g,b])

    dp = [[0,0,0] for _ in range(N)]
    dp[0] = c_list[0]

    for i in range(1, N):
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + c_list[i][0]
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + c_list[i][1]
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + c_list[i][2]

    print(min(dp[N-1]))