# 공유기 설치
# https://www.acmicpc.net/problem/2110
# 힌트
# 1. 공유기를 설치하기 위한 최소한의 간격을 binary search로 찾으면 된다.
# 2. 첫번째 위치를 시작으로 최소한의 간격 이상일때만 공유기를 놓아주면서 c 갯수 이상 뒀는지, 부족하게 뒀는지로 binary search를 해준다.

import sys


def solve(dist):
    pos = houses[0]
    cnt = 1
    for i in range(1, n):
        if (houses[i] - pos) >= dist:
            cnt += 1
            pos = houses[i]

    if cnt >= c:
        return True
    else:
        return False


def bs():
    l, m, r = 0, -1, houses[-1] - houses[0]

    while l <= r:
        m = (l + r) // 2
        if solve(m):
            l = m + 1
        else:
            r = m - 1

    return r


if __name__ == "__main__":
    n, c = map(int, input().split())
    houses = []
    for i in range(n):
        houses.append(int(sys.stdin.readline()))

    houses.sort()

    answer = bs()

    print(answer)