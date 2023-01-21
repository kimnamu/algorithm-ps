# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 부분수열의 합
# https://www.acmicpc.net/problem/1182
# 힌트
# 1. 부분수열은 꼭 연속한수의 집합이 아니여도 된다.
# 2. 모든 부분 수열을 탐색해야 한다.
from itertools import permutations
from itertools import combinations


# python library의 combinations를 사용해서 조합 구함.
def sol(idx):
    mat = 0
    for c in combinations(nums, idx):
        if sum(c) == S:
            mat += 1

    return mat

## 시간 초과.
# def sol(ik):
#     # 2. Filter를 만들어준다.
#     # 만약 N==4라면, Filter는 다음과 같은 순서로 만들어 준다.
#     # {0, 0, 0, 1}
#     # {0, 0, 1, 1}
#     # {0, 1, 1, 1}
#     # {1, 1, 1, 1}
#     filters = [0] * (N - ik) + [1] * ik
#
#     mat = 0
#     for filt in set(permutations(filters, N)):
#         #temp = sum([a * b for a, b in zip(nums, filt)])
#         temp = 0
#         for j in range(len(nums)):
#             temp = temp + filt[j] * nums[j]
#
#         if temp == S:
#             mat = mat + 1
#
    # return mat


if __name__ == "__main__":
    N, S = map(int, input().split())
    nums = list(map(int, input().split()))

    answer = 0
    for i in range(1, N+1):
        answer += sol(i)

    print(answer)


