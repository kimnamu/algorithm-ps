# 나무 자르기
# https://www.acmicpc.net/problem/2805
# 힌트
# 1. Binary Search를 통해 적정 자르는 나무의 범위를 좁힌다.
#    자르는 나무높이의 범위는 [0, 가장 큰 나무] 이다.
# 2. 대소관계에 유의하자.
# 3. python에서는 pypy3로 컴파일해야 시간초과가 되지 않는다.

import sys


def solve(tree):
    total = 0
    for i in range(n):
        total += max(0, v[i] - tree)

    if total >= m:
        return True
    else:
        return False


def bs():
    l, m, r = 0, -1, v_max

    while l <= r:
        m = (l + r) // 2
        if solve(m):
            l = m + 1
        else:
            r = m - 1

    return r


if __name__ == "__main__":
    n, m = map(int, input().split())
    v = list(map(int, sys.stdin.readline().split()))
    v_max = max(v)

    answer = bs()

    print(answer)