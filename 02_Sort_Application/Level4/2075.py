# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# N번째 큰 수
# https://www.acmicpc.net/problem/2075
# 힌트
# 1. 한 줄에 걸쳐 list를 받을 때마다 정렬하여 마지막 n개만 남김
# 2. n개의 데이터만 가지고 있으므로 첫번째 값을 출력

import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    a_list = []
    for _ in range(N):
        a_list.extend(list(map(int, sys.stdin.readline().split())))
        a_list.sort()
        a_list = a_list[-N:]

    print(a_list[0])

## 방법 2. heapq 이용
# import sys
# import heapq
#
# if __name__ == "__main__":
#     N = int(sys.stdin.readline())
#     a_list = []
#     for _ in range(N):
#         for val in list(map(int, sys.stdin.readline().split())):
#             heapq.heappush(a_list, val)
#         while len(a_list) > N:
#             heapq.heappop(a_list)
#     print(heapq.heappop(a_list))