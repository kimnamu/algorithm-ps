# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 행렬 곱셈 순서
# https://www.acmicpc.net/problem/11049
# 힌트
# 1. DFS를 통해 구간별 연산수 값이 가장 최소가 되는 값을 찾는다.
# 2. 각 구간별 연산수의 최소값을 찾기 위해 직전의 두 메트릭스를 모두 search하고 이때 각 구간에 대해 또 다시 최소값을 구해준다.
# pypy3로 컴파일해야 timeout 안생김.
import sys
sys.setrecursionlimit(100000)


def dfs(l, r):
    if l == r:
        return 0
    ret = sys.maxsize

    if dp[l][r] != -1:
        return dp[l][r]

    for i in range(l, r ):
        ret = min(ret, dfs(l, i) + dfs(i + 1, r) + \
                  (matrices[l][0] * matrices[i][1] * matrices[r][1]))
    dp[l][r] = ret

    return dp[l][r]


if __name__ == "__main__":
    N = int(sys.stdin.readline())

    matrices = [[0] * 2 for _ in range(N)]
    dp = [[-1] * N for _ in range(N)]

    for i in range(N):
        matrices[i] = list(map(int, sys.stdin.readline().split()))

    answer = dfs(0, N - 1)

    print(answer)
