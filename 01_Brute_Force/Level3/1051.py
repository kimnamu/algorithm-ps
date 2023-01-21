# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 숫자 정사각형
# https://www.acmicpc.net/problem/1051

if __name__ == "__main__":
    N, M = map(int, input().split())
    board = []
    for i in range(N):
        board.append(input())

    # 1. 모든 행(i), 열(j)을 기준으로 변의 길이(k+1)만큼 떨어진 3좌표값을 비교하여, 모두 같은 값이면 최대 넓이 값을 갱신해줌.
    answer = 1
    for i in range(N):
        for j in range(M):
            for k in range(M if M > N else N):
                if i + k < N and j + k < M:
                    if (board[i][j] == board[i + k][j] and board[i][j] == board[i][j + k]
                            and board[i][j] == board[i + k][j + k]):
                        if (k + 1) * (k + 1) > answer:
                            answer = (k + 1) * (k + 1)

    print(answer)
