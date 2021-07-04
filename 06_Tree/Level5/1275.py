# 커피숍2
# https://www.acmicpc.net/problem/1275
# 힌트
# 1. Brute Force의 시간복잡도는 O(N^2 x M)이므로 시간초과를 하게 된다. 세그트리를 이용하면 시간복잡도는 O(logN * M)로 제한 시간안에 풀 수 있다.
# 2. 세그트리는 크게 세부분으로 나누어 구현한다.
# 2.1. init : 세그트리를 초기화 해준다. N의 크기에 맞춰 트리의 높이를 계산해주고, 그 높이에 맞는 tree를 만들어준다.
# 2.2. query : 구간을 던져주면 해당 구간합을 반환 한다.문제에서 sum이라고 하지만 세그트리에서는 구간을 던져주면 그에 대한 구간합을 만들어주기 때문에 query라고 한다.
# 2.3. update : 특정 index의 값이 바뀌면 해당 index를 포함하는 tree node값을 갱신해준다.
import sys


def init(node, start, end):
    if start == end:
        tree[node] = arr[start]
        return tree[node]
    else:
        mid = (start + end) // 2
        tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end)
        return tree[node]


def update(node, start, end, idx, diff):
    if idx < start or end < idx:
        return

    tree[node] += diff

    if start != end:
        mid = (start + end) // 2
        update(node * 2, start, mid, idx, diff)
        update(node * 2 + 1, mid + 1, end, idx, diff)


def query(node, start, end, k, j):
    if k > end or j < start:
        return 0

    if k <= start and end <= j:
        return tree[node]

    mid = (start + end) // 2

    return query(node * 2, start, mid, k, j) + query(node * 2 + 1, mid + 1, end, k, j)


if __name__ == "__main__":
    N, Q = map(int, sys.stdin.readline().split())

    arr = [0] * 10000001
    tree = [0] * 10000001

    for i, val in enumerate(map(int, sys.stdin.readline().split())):
        arr[i] = val

    init(1, 0, N - 1)

    for i in range(Q):
        x, y, idx, b = map(int, sys.stdin.readline().split())

        if x > y:
            x, y = y, x

        diff = b - arr[idx - 1]
        arr[idx - 1] = b

        print(query(1, 0, N - 1, x - 1, y - 1))
        update(1, 0, N - 1, idx - 1, diff)
