# 기타 레슨
# https://www.acmicpc.net/problem/2343
# 힌트
# 1. 레슨 수가 적힌 배열을 순차적으로 합해가면서, 제한된 블루레이 용량을 초과할 경우 새로운 블루레이로 교환해주면 된다.
#    이때, 제한된 블루레이 용량을 Binary search로 찾으면 된다.
# 2. Binary Search의 범위를 설정할때 최소값은 적어도 하나의 레슨은 담을 수 있는 용량으로 해야하고, 최대값을 모든 레슨을 한번에 담을 수 있응 용량으로 해야한다.
#    다시 말해, 블루레이 용량의 최소값을 레슨 중 최대값이 되어야하고, 최대값을 레슨의 모든 합이 되어야 한다.

import sys


def solve(k):
    current_sum = 0
    cnt = 1
    for i in range(n):
        current_sum += v[i]
        if current_sum > k:
            cnt += 1
            current_sum = v[i]

    if cnt > m:
        return True
    else:
        return False


def bs():
    left, mid, right = v_min, -1, v_max

    while left <= right:
        mid = (left + right) // 2
        if solve(mid):
            left = mid + 1
        else:
            right = mid - 1

    return left


if __name__ == "__main__":
    n, m = map(int, input().split())

    v = list(map(int, sys.stdin.readline().split()))
    v_min = max(v)
    v_max = sum(v)

    answer = bs()

    print(answer)