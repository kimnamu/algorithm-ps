# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 최소 스패닝 트리
# https://www.acmicpc.net/problem/1197
# 힌트
# 1. 크루스칼 알고리즘을 이용하여 가중치가 낮은 node부터 순차적으로 연결해준다.
# 2. 이미 연결되어 있는 node는 스킵한다. 이미 연결되어 있는지의 체크는 union-find 방식을 이용한다.
# pytho
import sys
sys.setrecursionlimit(10000)


def find_parent(k):
    if parent[k] != k:
        parent[k] = find_parent(parent[k])
    return parent[k]


def union_edge(e1, e2):
    p1 = find_parent(e1)
    parent[p1] = find_parent(e2)


if __name__ == "__main__":
    V, E = map(int, sys.stdin.readline().split())
    parent = [i for i in range(V+1)]
    edges = []

    for i in range(E):
        x, y, weight = map(int, sys.stdin.readline().split())
        edges.append((x, y, weight))

    edges.sort(key=lambda x: x[2])

    answer = 0

    for i in range(E):
        edge1 = edges[i][0]
        edge2 = edges[i][1]
        if find_parent(edge1) != find_parent(edge2):
            union_edge(edge1, edge2)
            answer += edges[i][2]

    print(answer)