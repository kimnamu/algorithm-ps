# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 알파벳
# https://www.acmicpc.net/problem/1987
# 힌트
# 1. DFS를 통해 가장 길게 만들수 있는 알파벳의 길이를 갱신한다.
# 2. 이때 한번 지나간 알파벳은 체크해주어 DFS탐색 위치에서 배재해준다.
# Python의 경우 pypy3로 컴파일해야 시간초과가 나지 않는다.

import sys
dxy = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def dfs(i, j, depth):
    global answer
    answer = max(answer, depth)

    for dx1, dy1 in dxy:
        dx = i + dx1
        dy = j + dy1
        if 0 <= dx < r and 0 <= dy < c \
                and alpha[table[dx][dy]]:
            alpha[table[dx][dy]] = False
            dfs(dx, dy, depth + 1)
            alpha[table[dx][dy]] = True


if __name__ == "__main__":
    r, c = map(int, sys.stdin.readline().split())

    table = [[0] * c for _ in range(r)]

    for i in range(r):
        tp = sys.stdin.readline()
        for j in range(c):
            table[i][j] = ord(tp[j]) - ord('A')

    alpha = [True] * 26
    alpha[table[0][0]] = False

    answer = 1
    dfs(0, 0, 1)

    print(answer)