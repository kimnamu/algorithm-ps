# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 합이 0이 아닌 네 정수
# https://www.acmicpc.net/problem/7453
# 힌트
# 1. 4중 for문을 쓰게되면 시간초과
# 2. 2중 for문을 통해 A+B의 덧셈 집합(AB)과 C+D의 덧셈 집합(CD)을 각각 만들어줌
# 3. AB 수열 값 * -1 값이 CD 수열에 있는지 Binary Search
# 4. 이때 AB와 CD값이 유니크하지 않기 때문에 값이 여러개 일 수 있고 이를 찾는데 오래 걸리므로
#    map을 이용해서 dynamic programming 해줌
# pypy3로 컴파일해야 시간 초과 안남.

import sys

def get_same_value(index):
    global mm

    if index in mm:
        return mm[index]

    ret = 0

    for j in range(index, len(cd)):
        if cd[j] == cd[index]:
            ret += 1
        else:
            break

    for j in range(index-1, -1, -1):
        if cd[j] == cd[index]:
            ret += 1
        else:
            break

    mm[index] = ret
    return ret


def binary_search(k):
    l, r, m = 0, len(cd) - 1, 0

    while True:
        if m == (l + r) // 2:
            return 0
        m = (l + r) // 2
        if cd[m] == k:
            break
        elif cd[m] < k:
            l = m + 1
        else:
            r = m - 1

    return get_same_value(m)


if __name__ == "__main__":
    N = int(input())

    A, B, C, D = [0] * N, [0] * N, [0] * N, [0] * N
    for i in range(N):
        A[i], B[i], C[i], D[i] = map(int, sys.stdin.readline().split())

    answer = 0

    ab = [0] * N * N
    cd = [0] * N * N
    for i in range(N):
        for j in range(N):
            ab[i*N+j] = A[i] + B[j]
            cd[i*N+j] = C[i] + D[j]

    ab.sort()
    cd.sort()

    mm = dict()
    answer = 0
    for i in range(len(ab)):
        answer += binary_search(-ab[i])

    print(answer)

