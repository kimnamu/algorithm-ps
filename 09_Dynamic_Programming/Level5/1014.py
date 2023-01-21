# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 컨닝
# https://www.acmicpc.net/problem/1014
# 힌트
# 1. 다이나믹 프로그래밍을 이용하여 이전 행의 학생 배치에 따라 현재 행에서의 학생 배치값이 최대값인지 memoization해준다.
# 2. 상태에 대한 memoization은 최대 10개의 위치에 대해서 bitmask를 활용해준다.

import sys


def dfs(index):
    if index == M:
        str = ""
        for i in range(M-1, -1, -1):
            if curr[i]:
                str += "1"
            else:
                str += "0"
        combinations.append(str)
        return

    curr[index] = 0
    dfs(index + 1)

    if not index or not curr[index - 1]:
        curr[index] = 1
        dfs(index + 1)


def solve(line, state):
    if line == N:
        return 0
    ret = dp[line][state]
    if ret > 0:
        return ret

    ret = 0
    dp[line][state] = 0

    for s in combinations:
        state_curr = 0
        FLAG = True
        cnt = 0

        for i in range(M):
            if s[i] == '1':
                cnt += 1
                if table[line][i] == 'x':
                    FLAG = False
                    break

                state_curr = state_curr | (1 << i)
                if (i > 0) and (state & (1 << (i - 1))):
                    FLAG = False
                    break

                if (i < M) and (state & (1 << (i + 1))):
                    FLAG = False
                    break

        if FLAG:
            ret = max(ret, solve(line + 1, state_curr) + cnt)
            dp[line][state] = ret

    dp[line][state] = ret

    return ret


if __name__ == "__main__":
    C = int(input())

    for _ in range(C):
        N, M = map(int, sys.stdin.readline().split())

        curr = [0] * 11
        dp = [[-1] * (1 << 10) for _ in range(12)]
        combinations = []

        dfs(0)

        table = []
        for _ in range(N):
            table.append(list(sys.stdin.readline().strip()))

        print(solve(0, 0))
