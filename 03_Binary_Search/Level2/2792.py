# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
import sys


def solve(k):
    ret = 0
    for i in range(M):
        ret += (m_list[i] + k - 1) // k

    return ret


def bs(right):
    l, r, m = 1, right, 0

    while l < r:
        m = (l + r) // 2
        if solve(m) <= N:
            r = m
        else:
            l = m + 1

    return r


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())

    m_list = []
    for _ in range(M):
        m_list.append(int(sys.stdin.readline()))

    answer = bs(max(m_list))

    print(answer)