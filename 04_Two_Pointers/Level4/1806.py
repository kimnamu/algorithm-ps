# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 부분합
# https://www.acmicpc.net/problem/1806
# 힌트
# 1. 투 포인터 방법을 활용해 부분합의 가장 왼쪽 위치와 오른쪽 위치를 조정해가면서 부분합을 계산한다.
# 1.1. 부분합이 S보다 크거나 같다면, 왼쪽 포인터 위치의 값을 빼주고 오른쪽으로 한칸 옮겨준다.
# 1.2. 부분합이 S보다 작다면, 오른쪽 포인터 위치를 오른쪽으로 한칸 옮겨준 후 해당 위치 값을 더해준다.
import sys

if __name__ == "__main__":
    N, S = map(int, sys.stdin.readline().split())
    A = list(map(int, sys.stdin.readline().split()))

    left, right = 0, 0
    p_sum = A[0]
    answer = N + 1

    while True:
        if p_sum >= S:
            answer = min(answer, right - left + 1)
            p_sum -= A[left]
            left += 1
        else:
            right += 1
            if right == N:
                break
            p_sum += A[right]

    if answer == N + 1:
        answer = 0
    print(answer)

