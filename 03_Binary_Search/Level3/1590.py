# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 캠프가는 영식
# https://www.acmicpc.net/problem/1590
# 힌트
# 1. 버스의 모든 시간을 입력하여 정렬한다.
# 2. 정렬된 버스를 기준으로 영식이의 도착시간이 가장 빠른 시간보다 빠르거나 가장 늦은 시간보다 늦으면 brute force로 구하고,
#    중간에 있을 경우 binary search로 도착시간과 같거나, 늦은 시간중 가장 이른 시간을 구해서 도착시간에서 빼준다.
import sys


def bs():
    if times[len(times) - 1] < T:
        return -1
    if times[0] >= T:
        return times[0] - T

    l, r, m = 0, len(times) - 1, 0

    while l < r:
        m = (l + r) // 2

        if times[m] == T:
            return 0
        elif times[m] > T:
            r = m
        else:
            l = m + 1

    return times[r] - T


if __name__ == "__main__":
    N, T = map(int, sys.stdin.readline().split())

    times = []
    for _ in range(N):
        s, g, n = map(int, sys.stdin.readline().split())
        times.extend(list(range(s, s + g * n,  g)))
    times.sort()

    answer = bs()

    print(answer)


