# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 수들의 합 2
# https://www.acmicpc.net/problem/2003
# 힌트
# 1. 투 포인터를 이용하여 부분합의 왼쪽 위치와 오른쪽 위치를 조정해가면서 부분합을 계산한다.
# 1.1 부분합이 M보다 작으면 왼쪽 포인터 위치의 배열 값을 빼주고 오른쪽으로 한칸 옮겨준다.
# 1.2 부분합이 M보다 크면 오른쪽 포인터를 한칸 오른쪽으로 옮겨준 후 해당 값을 더해준다.
# 1.3 부분합이 M이면 count를 하나 늘려주고, 왼쪽 포인터 위치의 배열 값을 빼주고 오른쪽으로 한칸 옮겨준다.

import sys

if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    A = list(map(int, sys.stdin.readline().split()))

    left, right = 0, 0
    p_sum = A[0]
    answer = 0

    while True:
        if p_sum == M:
            answer += 1
            p_sum -= A[left]
            left += 1
        elif p_sum < M:
            right += 1
            if right == N:
                break
            p_sum += A[right]
        else:
            p_sum -= A[left]
            left += 1

    print(answer)

