# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 파일 합치기
# https://www.acmicpc.net/problem/11066
# 힌트
# 1. DFS를 통해 구간별 합치기 값이 가장 최소가 되는 값을 찾는다.
# 2. 각 구간별 합의 최소값을 찾기 위해 직전의 두 구간을 모두 search하고 이때 각 구간에 대해 또다시 최소 값을 구해준다.
# pypy3로 컴파일해야 타임아웃 발생안함.
import sys


def dfs(l, r):
    if dp[l][r] != 0:
        return dp[l][r]

    if r == l:
        dp[l][r] = 0
        return dp[l][r]

    ret = sys.maxsize
    for i in range(l, r):
        ret = min(ret, dfs(l, i) + dfs(i + 1, r) + cumsum[r] - cumsum[l - 1])
    dp[l][r] = ret

    return ret


if __name__ == "__main__":
    T = int(sys.stdin.readline())

    for _ in range(T):
        K = int(sys.stdin.readline())

        seq = list(map(int, sys.stdin.readline().split()))
        dp = [[0] * (K) for _ in range(K)]

        cumsum = [0] * (K + 1)
        for i in range(0, K):
            cumsum[i] = cumsum[i - 1] + seq[i]

        # timeout
        # print(dfs(0, K-1))

        for i in range(1, K):
            for l in range(K):
                r = l + i
                if r == K:
                    break

                ret = sys.maxsize
                for j in range(l, r):
                    ret = min(ret, dp[l][j] + dp[j+1][r] + cumsum[r] - cumsum[l - 1])
                dp[l][r] = ret
        print(dp[0][-1])

