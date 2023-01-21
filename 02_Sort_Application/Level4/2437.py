# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 수 묶기
# https://www.acmicpc.net/problem/1744
# 힌트
# 1. 오름차순으로 정렬
# 2. 정렬된 순서대로 추의 값을 더함
# 3. 현재까지 추의 합 + 1 이 다음의 추의 값보다 작으면
#    현재까지 추의 합 + 1 은 표현 못함.

import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    numbers = list(map(int, sys.stdin.readline().split()))

    # 오름차순으로 정렬
    numbers.sort()

    current_sum = 0
    for val in numbers:
        # 현재까지의 합 + 1보다 현재 값이 더 크면 break
        if current_sum + 1 < val:
            break
        else:
            current_sum += val

    print(current_sum + 1)

