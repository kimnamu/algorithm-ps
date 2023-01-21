# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 수열의 장인
# https://www.acmicpc.net/problem/10885
# 힌트
# 1. 마이너스(-)의 개수가 짝수일때 2 혹은 -2의 개수가 최대치가 되는 때를 구하면 된다.
# 2. 왼쪽부터 순차적으로 포인터를 오른쪽으로 이동해가며 구해주고, 오른쪽에서부터 순차적으로 왼쪽으로 포인터를 이동하며 구해주면 된다.
# 3. 마이너스(-)가 짝수이면서 2 혹은 -2가 없는 경우 예외처리를 위해 단일 수의 최대값을 정답의 초기값으로 지정해준다.
import sys

mod = 1000000007


def solve(idx):
    global ans_two, cnt_minus, cnt_two, answer

    if v[idx] == 0:
        cnt_two, cnt_minus = 0, 0
        return

    if v[idx] < 0:
        cnt_minus += 1

    if v[idx] == 2 or v[idx] == -2:
        cnt_two += 1

    if cnt_minus % 2 == 0:
        ans_two = max(ans_two, cnt_two)
        answer = 1


if __name__ == "__main__":

    T = int(input())

    for _ in range(T):
        N = int(input())
        v = list(map(int, sys.stdin.readline().split()))

        answer = max(-2, max(v))
        ans_two = 0

        cnt_two, cnt_minus = 0, 0
        for i in range(N):
            solve(i)

        cnt_two, cnt_minus = 0, 0
        for i in range(N-1, -1, -1):
            solve(i)

        while ans_two > 0:
            answer = ((answer % mod) * 2) % mod
            ans_two -= 1

        print(answer)
