# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 예산
# https://www.acmicpc.net/problem/2512
# 힌트
# 1. 상한선이 될 금액을 binary search로 구하면 된다. 이때 상한선 금액의 초기 범위는 0부터 가장큰 예산이다.
import sys


def solve(k):
    total = 0
    for i in range(n):
        total += min(k, budget[i])

    if total <= M:
        return True
    else:
        return False


def bs():
    l, m, r = 0, -1, budget_max

    while l <= r:
        m = (l + r) // 2
        if solve(m):
            l = m + 1
        else:
            r = m - 1

    return r


if __name__ == "__main__":
    n = int(input())

    budget = list(map(int, sys.stdin.readline().split()))
    budget_max = max(budget)
    M = int(input())

    answer = bs()

    print(answer)