# Dance Dance Revolution
# https://www.acmicpc.net/problem/2342
# 1. Memoization을 이용하여 왼발, 오른발, 차례에 따른 최소 비용 값을 갱신해준다.
import sys
sys.setrecursionlimit(1000000)


def move(fr, to):
    ret = 0

    if fr == to:
        ret = 1
    elif fr == 0:
        ret = 2
    elif fr == 1:
        ret = 4 if to == 3 else 3
    elif fr == 2:
        ret = 4 if to == 4 else 3
    elif fr == 3:
        ret = 4 if to == 1 else 3
    elif fr == 4:
        ret = 4 if to == 2 else 3
    return ret


def solve(l, r, n):
    if n == len(v):
        return 0

    if dp[l][r][n] != 0:
        return dp[l][r][n]

    dp[l][r][n] = min(move(l, v[n]) + solve(v[n], r, n + 1),
                      move(r, v[n]) + solve(l, v[n], n + 1))

    return dp[l][r][n]


if __name__ == "__main__":
    v = list(map(int, sys.stdin.readline().split()))[:-1]

    dp = [[[0] * 100000 for _ in range(5)] for j in range(5)]

    answer = solve(0, 0, 0)

    print(answer)