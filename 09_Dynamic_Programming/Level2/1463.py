# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 1로 만들기
# https://www.acmicpc.net/problem/1463
# 힌트
# 1. Top-Down 방식을 이용한 dynamic programming 방법을 이용한다.
# 2. n에 도달했을때 비용이 기존에 memoization해둔 값보다 크다면 더 이상 탐색하지 않는다.
import sys
sys.setrecursionlimit(1000000)


def dp(n, k):
    if dlist[n] > k:
        dlist[n] = k
    else:
        return

    if n == 1:
        return
    if n % 3 == 0:
        dp(n // 3, k + 1)
    if n % 2 == 0:
        dp(n // 2, k + 1)
    dp(n - 1, k + 1)


if __name__ == "__main__":
    N = int(sys.stdin.readline())


    # 방법 1. 메모리 초과
    # dlist = [sys.maxsize] * (N + 1)
    # dp(N, 0)

    # 방법 2. for문으로 N 부터 1까지 내려가면서 계산
    dlist = [sys.maxsize] * N + [0]
    for i in range(N, 1, -1):
        next_cnt = dlist[i] + 1
        if i % 3 == 0 and dlist[i // 3] > next_cnt:
            dlist[i // 3] = next_cnt
        if i % 2 == 0 and dlist[i // 2] > next_cnt:
            dlist[i // 2] = next_cnt
        if dlist[i-1] > next_cnt:
            dlist[i-1] = next_cnt

    print(dlist[1])
