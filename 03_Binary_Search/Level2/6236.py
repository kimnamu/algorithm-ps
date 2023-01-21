# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 용돈 관리
# https://www.acmicpc.net/problem/6236
# 힌트
# 1. 문제의 시뮬레이션이 정상 작동하는데 최소 인출 회수(cnt)를 구해서,
#    그 최소 횟수가 m이하이면 가능한 경우로 보고 가능한 가장 작은 수를 구한다.
# 2. 인출하는 비용을 binary search를 통해 찾는다.
#    이때 최대 값은 인출을 한번만 해도 되는 모든 금액의 합으로 지정한다.

import sys


def solve(k):
    amount, cnt = 0, 0

    for i in range(N):
        if amount < bank[i]:
            amount = k
            cnt += 1

        amount -= bank[i]
        # 인출해도 값을 지불하지 못하면 실패.
        if amount < 0:
            return False
    if cnt <= M:
        return True
    else:
        return False


def bs():
    l, m, r = 0, 0, bank_full

    while l <= r:
        m = (l + r) // 2
        if solve(m):
            r = m - 1
        else:
            l = m + 1

    return l


if __name__ == "__main__":
    N, M = map(int, input().split())

    bank = [0] * N
    bank_full = 0

    for i in range(N):
        bank[i] = int(sys.stdin.readline())
        bank_full += bank[i]

    answer = bs()

    print(answer)
