# 수들의 합
# https://www.acmicpc.net/problem/2268
# 힌트
# 1. Brute Force의 시간복잡도는 O(N^2 mode M)이므로 시간초과를 하게 된다. 세그트리를 이용하면 시간복잡도는 O(logN * M)로 제한 시간안에 풀 수 있다.
# 2. 세그트리는 크게 세부분으로 나누어 구현한다.
# 2.1. init : 세그트리를 초기화 해준다. N의 크기에 맞춰 트리의 높이를 계산해주고, 그 높이에 맞는 tree를 만들어준다.
# 2.2. query : 구간을 던져주면 해당 구간합을 반환 한다.문제에서 sum이라고 하지만 세그트리에서는 구간을 던져주면 그에 대한 구간합을 만들어주기 때문에 query라고 한다.
# 2.3. update : 특정 index의 값이 바뀌면 해당 index를 포함하는 tree node값을 갱신해준다.
import sys
import math

if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())

    # 2.1 Initialization
    arr = [0] * (N+1)
    tree = [0] * (N+1)

    def query(i, j):
        def sum(pos):
            ret = 0
            while pos > 0:
                ret += tree[pos]
                pos &= (pos-1)
            return ret
        return sum(j) - sum(i-1)

    def update(pos, val):
        while pos < len(tree):
            tree[pos] += val
            pos += (pos & -pos)

    for i in range(M):
        mode, i, j = map(int, sys.stdin.readline().split())
        if mode:
            update(i, j - arr[i])
            arr[i] = j
        else:
            if i > j:
                i, j = j, i
            print(query(i, j))
