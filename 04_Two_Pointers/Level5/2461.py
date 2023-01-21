# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 대표 선수
# https://www.acmicpc.net/problem/2461
# 힌트
# 1.각 반의 모든 선수들의 능력치를 하나의 배열에 담아 순서대로 나열 한다. 이때 각 선수들이 무슨반인지는 알 수 있도록 해야 한다.
# 2.순서대로 나열된 선수들의 능력치를 투포인터를 이용하여 각 반의 선수가 최소 한명씩 포함되도록 하는 구간을 찾으면서
#   왼쪽 포인터와 오른쪽 포인터에 위치한 선수들 간의 능력 차이가 최소가 되는 구간을 출력하면 된다.

import sys

if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())

    abilities = []
    for i in range(N):
        scores = map(int, sys.stdin.readline().split())
        for score in scores:
            abilities.append((score, i))

    abilities.sort(key=lambda x: x[0])

    count = [0] * N
    left, right = 0, 0
    cnt = 1

    count[abilities[right][1]] += 1

    answer = abilities[-1][0] - abilities[0][0]

    while True:
        if cnt == N:
            answer = min(answer, abilities[right][0] - abilities[left][0])
            count[abilities[left][1]] -= 1
            if count[abilities[left][1]] == 0:
                cnt -= 1
            left += 1
        elif cnt < N:
            right += 1
            if right == len(abilities):
                break
            if count[abilities[right][1]] == 0:
                cnt += 1
            count[abilities[right][1]] += 1

    print(answer)