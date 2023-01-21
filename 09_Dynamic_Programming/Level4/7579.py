# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 앱
# https://www.acmicpc.net/problem/7579
# 힌트
# 1. Memoization을 통해 첫 번째 부터 n번째까지의 비용에 따른 최소 메모리사용 값을 갱신해준다.
# 2. 이때 메모리를 사용할지 사용하지 않을지에 따라 다음 번째의 비용과 메모리값을 다르게 넣어준다.
# pypy3로 컴파일해야 timeout 안생김.
import sys


def dfs(index, volume, cost):
    global answer

    if volume >= M:
        answer = min(answer, cost)

    if dp[index][cost] != -1 and dp[index][cost] >= volume:
        return

    dp[index][cost] = volume

    if index + 1 < N:
        dfs(index + 1, volume + mlist[index + 1], cost + clist[index + 1])
        dfs(index + 1, volume, cost)

    return


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())

    mlist = list(map(int, sys.stdin.readline().split()))
    clist = list(map(int, sys.stdin.readline().split()))

    dp = [[-1] * 10001 for _ in range(101)]

    answer = 1e9

    dfs(0, mlist[0], clist[0])
    dfs(0, 0, 0)

    print(answer)



