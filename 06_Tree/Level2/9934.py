# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 완전 이진 트리
# https://www.acmicpc.net/problem/9934
# 힌트
# 1. Input으로 들어오는 값들을 하나의 배열에 입력 받았을때, 가운데 값을 중심으로 왼쪽 오른쪽 트리가 만들어짐
# 2. 1의 방식이 재귀함수 방식으로 왼쪽 트리, 오른족 트리에서 동일하게 적용됨
# 3. 트리의 깊이에 따른 vector를 선언하여 입력을 받아놓으면, 나중에 깊이에 따라 출력할 수 있음.
import sys
sys.setrecursionlimit(10000)


def solve(s, e, depth):
    if (e - s) == 1:
        answer[depth].append(v[s])
    else:
        m = (s + e - 1) // 2
        answer[depth].append(v[m])
        solve(s, m, depth + 1)
        solve(m + 1, e, depth + 1)


if __name__ == "__main__":
    k = int(sys.stdin.readline())
    num = pow(2, k) - 1

    v = list(map(int, sys.stdin.readline().split()))
    answer = [[] for _ in range(k)]

    solve(0, num, 0)

    for i in range(k):
        for j in range(len(answer[i])):
            print(answer[i][j], end=' ')
        print()
