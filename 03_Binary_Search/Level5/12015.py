# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 가장 긴 증가하는 부분 수열 2
# https://www.acmicpc.net/problem/12015
# 힌트
# 1. "가장 긴 증가하는 부분 수열"을 위한 "특별한 수열"을 만들어 준다.
#    이 "특별한 수열"은 n번째 값이 n번 증가하는데 사용될 수 중 가장 작은 수를 입력한다.
#    그러면 이 특별한 수열의 길이가 "가장 긴 증가하는 부분 수열"의 길이가 된다.
# 2. 수열의 순서가 바뀌면 안되기 때문에 입력받는 수를 바로바로 "특별한 수열"값을 갱신해 준다.
#   2.1 새로 입력된 수가 "특별한 수열"의 마지막 수 보다 크다면, 특별한 수열 뒤에 값을 추가해주면된다. 이때 "특별한 수열"이 길어지는 만큼 답도 커진다.
#   2.2 새로 입력된 수가 "특별한 수열"의 마지막 수 보다 작다면, 새로 입력된 수보다 크거나 같은 값의 위치에 새롭게 갱신해준다.
# 3. 이를 구현하기 위해 모든 수가 1번째 수가 될수 있도록 0번째 수는 모든 수보다 작은 0을 넣어주고 시작한다.

import sys


def bs(k):
    left, mid, right = 1, -1, len(v)

    while left <= right:
        mid = (left + right) // 2
        if v[mid] < k:
            left = mid + 1
        else:
            right = mid - 1

    return left


if __name__ == "__main__":
    n = int(input())

    v = [0]
    cnt = 0
    numbers = list(map(int, sys.stdin.readline().split()))
    for val in numbers:
        if val > v[-1]:
            v.append(val)
            cnt += 1
        else:
            loc = bs(val)
            v[loc] = val

    print(cnt)