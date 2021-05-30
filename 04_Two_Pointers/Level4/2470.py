# 두 용액
# https://www.acmicpc.net/problem/2470
# 힌트
# 1. 용액의 값을 정렬 후 투포인터 알고리즘을 이용해 답이 되는 두 쌍의 용액을 찾는다.
# 2. 두 포인터를 왼쪽과 오른쪽 끝에서 부터 시작하여, 각 위치값의 합이 0보다 큰지 작은지에 따라 포인터를 이동시킨다.
#   2.1. 두 위치값의 합이 0보다 크면, 합을 줄이기 위해 오른쪽 포인터를 왼쪽으로 한칸 옮겨준다.
#   2.2. 두 위치값의 합이 0보다 작으면, 합을 키워주기 위해 왼쪽 포인터를 오른쪽으로 한칸 옮겨준다.

import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    A = list(map(int, sys.stdin.readline().split()))

    A.sort()

    min_sum, min_left, min_right = sys.maxsize, 0, 0
    left, right = 0, N-1

    while left < right:
        p_sum = A[left] + A[right]
        if abs(p_sum) < min_sum:
            min_sum = abs(p_sum)
            min_left = A[left]
            min_right = A[right]

        if p_sum < 0:
            left += 1
        else:
            right -= 1

    print(str(min_left) + " " + str(min_right))
