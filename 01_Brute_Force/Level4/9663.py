# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# N-Queen
# https://www.acmicpc.net/problem/9663
# 힌트 : 세로줄은 column 값으로 확인가능
#       대각선(\)은 row - column + N - 1 값으로 확인 가능.
#       Skew-대각선(/)은 row + column 값으로 확인 가능.
# 해당 방법은 pypy3으로 컴파일 해야 시간 초과되지 않음.

def dfs(r):
    global answer

    if r == N - 1:
        answer += 1
        return

    for j in range(N):
        # 세로줄, 대각선(\, /) 값을 만족하는지 확인
        if j in cols or (r + 1 + j) in diag or (r + 1 - j + N - 1) in skew_diag:
            continue

        cols.append(j); diag.append(r + 1 + j); skew_diag.append(r + 1 - j + N - 1)
        dfs(r + 1)
        cols.pop(); diag.pop(); skew_diag.pop()


if __name__ == "__main__":
    N = int(input())

    cols, diag, skew_diag = [], [], []
    answer = 0
    for i in range(N):
        cols.append(i); diag.append(0 + i); skew_diag.append(0 - i + N - 1)
        dfs(0)
        cols.pop(); diag.pop(); skew_diag.pop()

    print(answer)
