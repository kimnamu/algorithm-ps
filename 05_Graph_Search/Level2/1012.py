# 유기농 배추
# https://www.acmicpc.net/problem/1012
# 힌트
# 1. 모든 위치를 탐색하다가 배추가 심어진 곳을 발견하면,
#    정답에 1을 추가하고, dfs를 활용하여 인접한 모든 위치의 배추값을 0으로 바꿔 준다.
#    이러면 인접한 배추에 대해서는 정답에 1만 기여하게 된다.
# 2. BOJ 채점 서버에는 파이썬은 recursionlimit가 기본 1000으로 되어있으므로 변경해줘야 오류가 뜨지 않는다.
import sys
sys.setrecursionlimit(1000000)


def solve():
    ans = 0

    for i in range(M):
        for j in range(N):
            if table[i][j]:
                ans += 1
                dfs(i, j)

    return ans


def dfs(i, j):
    if table[i][j]:
        table[i][j] = 0

    if i + 1 < M and table[i+1][j]:
        dfs(i+1, j)
    if i - 1 >= 0 and table[i-1][j]:
        dfs(i-1, j)
    if j + 1 < N and table[i][j+1]:
        dfs(i, j+1)
    if j - 1 >= 0 and table[i][j-1]:
        dfs(i, j-1)


if __name__ == "__main__":
    T = int(sys.stdin.readline())
    while T > 0:
        M, N, K = map(int, sys.stdin.readline().split())

        table = [[0] * N for _ in range(M)]

        for _ in range(K):
            a, b = map(int, sys.stdin.readline().split())
            table[a][b] = 1

        answer = solve()
        print(answer)

        T -= 1