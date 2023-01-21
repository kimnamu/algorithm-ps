# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 휴게소 세우기
# https://www.acmicpc.net/problem/1477
# 힌트
# 1. 휴게소와 휴게소 사이에 새로운 휴게소를 설치할때, 새로운 휴게소 기준으로 왼쪽 휴게소로 부터 "얼마 만큼 떨어진 휴게소"를 지을지 거리를 정하고,
#  그 거리로 설치하게 되면 "총 몇 개의 휴게소룰 새로설치"하게 되는지 계산을해서, 새로 설치하는 휴게소가 제한된 개수보다 적거나 같으면 더 작은 간격으로 설치가 가능하다.
#  반대로 새로 설치하는 휴게소 개수가 제한된 개수보다 많으면 더 멀리 떨어지게 휴게소를 만들 수 있다.

import sys


def solve(distance):
    cnt = 0
    for i in range(n + 1):
        d = v[i + 1] - v[i]
        if d / distance > 0:
            temp = (d - 1) // distance
            cnt += temp

    if cnt > m:
        return True
    else:
        return False


def bs():
    left, mid, right = 1, -1, length - 1

    while left <= right:
        mid = (left + right) // 2
        if solve(mid):
            left = mid + 1
        else:
            right = mid - 1

    return left


if __name__ == "__main__":
    n, m, length = map(int, input().split())

    v = list(map(int, sys.stdin.readline().split()))
    v.append(0)
    v.append(length)

    v.sort()

    answer = bs()

    print(answer)