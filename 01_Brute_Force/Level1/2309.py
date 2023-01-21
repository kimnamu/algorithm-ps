# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 일곱 난쟁이
# https://www.acmicpc.net/problem/2309

# 두 명의 키를 제외하고 모두 더하기
def solution(m1, m2) :
    ret = 0
    for k in range(9):
        if k not in [m1, m2]:
            ret += heights[k]

    return ret


if __name__ == "__main__":
    heights = []
    for _ in range(9):
        heights.append(int(input()))
    heights.sort()

    # 1. 9명 중 2명을 제외하는 모든 방법들을 탐색하며, 나머지 7명 키의 합이 100이 되는 때를 찾는다.
    n1, n2 = 0, 0
    for i in range(9) :
        for j in range(i+1, 9):
            if 100 == solution(i, j):
                n1 = i
                n2 = j

    for i in range(9):
        if i not in [n1, n2]:
            print(heights[i])
