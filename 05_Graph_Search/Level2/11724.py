# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 연결 요소의 개수
# https://www.acmicpc.net/problem/11724
# 힌트
# 1. DFS를 활용하여 1~N까지의 연결 요소를 탐색하며, 염결된 정점이 있으면 방문하도록 하자.
# 2. 이때 한번 방문한 정점을 반복해서 방문하지 않도록 check 배열을 이용해 준다.
import sys
sys.setrecursionlimit(1000000)


def solve():
    ans = 0

    for i in range(1, N + 1):
        if not check[i]:
            ans += 1
            dfs(i)

    return ans


def dfs(k):
    global check

    check[k] = True
    for i in range(1, N + 1):
        if not check[i] and table[k][i]:
            dfs(i)


if __name__ == "__main__":
    N, K = map(int, sys.stdin.readline().split())

    check = [False] * (N + 1)
    table = [[False] * (N + 1) for _ in range(N + 1)]

    for i in range(K):
        a, b = map(int, sys.stdin.readline().split())
        table[a][b] = True
        table[b][a] = True

    answer = solve()
    print(answer)