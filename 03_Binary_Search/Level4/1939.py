# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 중량제한
# https://www.acmicpc.net/problem/1939
# 힌트
# 1. BFS를 활용하여 지정한 중량으로 공장이 이어질 수 있는지 찾는다.
# 2. 여기서 중량의 범위가 방대하므로 binary search를 통해 값을 찾아낸다.
#    이때, 복잡도는 O(nlogc)이다.

import sys


def bfs(val):
    q = [loc1]
    check = [False] * 100001
    check[loc1] = True

    while len(q) != 0 :
        fr = q.pop()

        for (next_node, weight) in adj[fr]:
            if not check[next_node] and weight >= val:
                check[next_node] = True
                q.append(next_node)

    return check[loc2]


def bs():
    left, mid, right = 1, -1, max_weight

    while left <= right:
        mid = (left + right) // 2
        if bfs(mid):
            left = mid + 1
        else:
            right = mid - 1

    return right


def add_node_to_map(fr, to, weight):
    if fr in adj.keys():
        adj[fr].append((to, weight))
    else:
        adj[fr] = [(to, weight)]


if __name__ == "__main__":
    n, m = map(int, input().split())

    max_weight = 0
    adj = {}
    for i in range(m):
        n1, n2, weight = list(map(int, sys.stdin.readline().split()))
        add_node_to_map(n1, n2, weight)
        add_node_to_map(n2, n1, weight)

        max_weight = max(max_weight, weight)

    loc1, loc2 = map(int, input().split())

    answer = bs()

    print(answer)