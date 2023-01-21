# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# BABBA
# https://www.acmicpc.net/problem/9625
# 힌트
# 1. Bottom-Up 방식의 다이나믹 프로그래밍을 이용하여 이전 상태에서 다음 상태를 갱신하여 O(N)안에 풀 수 있다.
import sys


if __name__ == "__main__":
    K = int(sys.stdin.readline())

    A, B = 1, 0

    for _ in range(K):
        A_new = B
        B_new = A + B

        A = A_new
        B = B_new

    print(A_new, B_new)



