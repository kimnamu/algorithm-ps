# 적록색약
# https://www.acmicpc.net/problem/10026
# 힌트
# 1. RGB의 서로 다른 색상들에대해 DFS를 활용하여 몇개의 군집으로 나뉘어져있는지 counting한다.
# 2. 적록색약이 R과 G의 구분이 없는 것이므로 모든 R을 G로 바꿔 준 후 1을 반복한다.
import sys
sys.setrecursionlimit(10000)
dxy = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def solve():
    answer = 0
    check = [[False] * N for _ in range(N)]

    for i in range(N):
        for j in range(N):
            if not check[i][j]:
                answer += 1
                check[i][j] = True
                dfs(i, j, check)

    return answer


def dfs(i, j, check):
    for dx, dy in dxy:
        x = i + dx
        y = j + dy
        if 0 <= x < N and 0 <= y < N \
            and table[i][j] == table[x][y] and not check[x][y]:
            check[x][y] = True
            dfs(x, y, check)


def convert_to_r2g():
    for i in range(N):
        for j in range(N):
            if table[i][j] == 'R':
                table[i][j] = 'G'


if __name__ == "__main__":
    N = int(input())

    table = []

    for _ in range(N):
        table.append(list(sys.stdin.readline().strip()))

    answer1 = solve()
    convert_to_r2g()
    answer2 = solve()

    print(answer1, answer2)