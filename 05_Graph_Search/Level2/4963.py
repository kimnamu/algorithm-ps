# 섬의 개수
# https://www.acmicpc.net/problem/4963
# 힌트
# 1. 모든 섬의 위치를 순회하면서,
#    한번도 방문한적 없는 새로운 섬의 번호가 나타나면
#    DFS를 활용하여 인접한 섬을 모두 순회한다.
# 2. 이때 인접한 모든 섬은 상하좌우 뿐만 아니라 대각선도 포함됨을 주의하자.
import sys
sys.setrecursionlimit(1000000)


def solve():
    ans = 0

    for i in range(0, h):
        for j in range(w):
            if table[i][j]:
                ans += 1
                dfs(i, j)

    return ans


def dfs(i, j):
    if table[i][j] == 1:
        table[i][j] = 0

    for ii in range(-1, 2):
        for jj in range(-1, 2):
            if ii == 1 and i + ii >= h:
                continue
            if ii == -1 and i + ii < 0:
                continue
            if jj == 1 and j + jj >= w:
                continue
            if jj == -1 and j + jj < 0:
                continue

            if table[i + ii][j + jj] == 1:
                dfs(i + ii, j + jj)


if __name__ == "__main__":
    while True:
        w, h = map(int, sys.stdin.readline().split())

        if w == 0 and h == 0:
            break

        table = [[0] * w for _ in range(h)]

        for i in range(h):
            table[i] = list(map(int, sys.stdin.readline().split()))

        answer = solve()
        print(answer)