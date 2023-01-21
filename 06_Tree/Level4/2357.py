# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 최솟값과 최댓값
# https://www.acmicpc.net/problem/2357
# 힌트
# 1. 세그트리를 이용하여 각 구간 별 최소 값을 저장하는 트리와, 최대 값을 저장하는 트리를 만든다.
import sys
import math
sys.setrecursionlimit(100000000)


def init(node, start, end):
    if start == end:
        min_tree[node] = max_tree[node] = arr[start]
        return

    init(node * 2, start, (start + end) // 2)
    init(node * 2 + 1, (start + end) // 2 + 1, end)
    min_tree[node] = min(min_tree[node * 2], min_tree[node * 2 + 1])
    max_tree[node] = max(max_tree[node * 2], max_tree[node * 2 + 1])


def find(node, a, b, left, right):
    if left > b or right < a:
        return (sys.maxsize, 0)

    if a <= left and right <= b:
        return (min_tree[node], max_tree[node])

    l = find(node * 2, a, b, left, (left + right) // 2)
    r = find(node * 2 + 1, a, b, (left + right) // 2 + 1, right)
    return (min(l[0], r[0]), max(l[1], r[1]))


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    ts = pow(2, math.ceil(math.log2(N)) + 1)

    min_tree = [0] * ts
    max_tree = [0] * ts

    arr = [int(sys.stdin.readline()) for _ in range(N)]

    init(1, 0, N-1)

    for _ in range(M):
        a, b = map(int, sys.stdin.readline().split())
        answer = find(1, a-1, b-1, 0, N-1)
        print(answer[0], answer[1])



