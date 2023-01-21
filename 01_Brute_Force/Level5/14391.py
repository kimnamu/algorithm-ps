# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 종이 조각
# https://www.acmicpc.net/problem/14391

def dfs(r, c):
    global visited, answer, score

    # 1. 한칸짜리로 종이 조각내기
    if visited[r][c]:
        if r == N - 1 and c == M - 1:
            answer = max(answer, score)
        if c + 1 < M:
            dfs(r, c + 1)
        elif r + 1 < N:
            dfs(r + 1, 0)
        return
    else:
        score += board[r][c]
        visited[r][c] = True
        if r == N - 1 and c == M - 1:
            answer = max(answer, score)
            score -= board[r][c]
            visited[r][c] = False
            return

        if c + 1 < M:
            dfs(r, c + 1)
        elif r + 1 < N:
            dfs(r + 1, 0)

        score -= board[r][c]
        visited[r][c] = False

    # 2. 가로로 긴 직사각형 모양으로 종이 조각 내기
    for i in range(1, M - c):
        if visited[r][c + i]:
            break
        # 종이조각 값 구하기
        num = 0
        for j in range(i+1):
            num = num * 10 + board[r][c + j]
            visited[r][c + j] = True
        score += num

        # 다음 dfs로 넘어가기
        if c + 1 < M:
            dfs(r, c + 1)
        elif r + 1 < N:
            dfs(r + 1, 0)

        score -= num
        for j in range(i+1):
            visited[r][c + j] = False

    # 3. 세로로 긴 직사각형 모양으로 종이 조각 내기
    for i in range(1, N - r):
        if visited[r + i][c]:
            break
        # 종이조각 값 구하기
        num = 0
        for j in range(i + 1):
            num = num * 10 + board[r + j][c]
            visited[r + j][c] = True
        score += num
        if c + 1 < M:
            dfs(r, c + 1)
        elif r + 1 < N:
            dfs(r + 1, 0)

        score -= num
        for j in range(i+1):
            visited[r + j][c] = False


if __name__ == "__main__":
    N, M = map(int, input().split())
    board = []

    for _ in range(N):
        tmp = []
        for j in input():
            tmp.append(int(j))
        board.append(tmp)

    visited = [[False] * M for _ in range(N)]

    answer, score = 0, 0
    # dfs를 이용한 완전 탐색
    dfs(0, 0)

    print(answer)