# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 모든 순열
# https://www.acmicpc.net/problem/10974

from itertools import permutations


def perm(depth):
    global visited, output
    # depth가 마지막까지 도달하였으면
    if depth == N:
        # 현재 배열로 출력
        for number in output:
            print(number, end=' ')
        print()
        return

    for i in range(N):
        if not visited[i]: # 사용한 index가 아니면
            visited[i] = True # 현재 index를 사용
            output[depth] = A[i] # output 배열의 depth번째 값에 A 배열의 현재 index번째 값을 사용.
            perm(depth + 1)
            visited[i] = False # 현재 index를 사용 해제


if __name__ == "__main__":
    N = int(input())

    A = [i for i in range(1, N + 1)]

    # 방법1. python library 사용시
    for a in permutations(A, len(A)):
        for number in a:
            print(number, end=' ')
        print()

    # 방법2. 직접 모든 순열 출력 구현시
    visited = [False] * N
    output = [0] * N
    # perm(0)