# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 바이러스
# https://www.acmicpc.net/problem/2606
# 1. DFS를 활용하여 1번 바이러스와 이어져있는 컴퓨터를 모두 찾으며 counting한다.
#    이때, 한번 방문한 컴퓨터는 재방문 할 필요가 없으므로 check배열을 통해 이미 한번 방문한 곳은 재방문하지 않도록 해준다.
import sys


def dfs(k):
    global answer

    answer += 1
    check[k] = True

    for i in range(1, N+1):
        if not check[i] and table[k][i]:
            dfs(i)


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    M = int(sys.stdin.readline())

    table = [[0] * (N+1) for _ in range(N+1)]

    for _ in range(M):
        a, b = map(int, sys.stdin.readline().split())
        table[a][b] = 1
        table[b][a] = 1

    check = [False] * (N + 1)
    answer = -1
    dfs(1)

    print(answer)
