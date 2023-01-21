# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 두 개의 탑
# https://www.acmicpc.net/problem/2118
# 힌트
# 1. Two pointer를 사용하여 구간합(part2)을 조절한다.
# 2. 구간합(part2)을 구한다면 전체합에서 구간합을 빼면 또 다른 구간합(part1)이 나오게 된다.
# 3. 이때 두 구간합의 최소값이 더 커지도록 two pointer의 left와 right를 하나씩 이동하면서 두 구간합의 최소값의 최대값을 갱신한다.
import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    t_list = [int(sys.stdin.readline()) for _ in range(N)]

    part1 = sum(t_list) - t_list[0]
    part2 = t_list[0]

    answer = min(part1, part2)

    left, right = 0, 0
    move_left = False

    while left <= right and left != N-1:
        if right == N - 1:
            move_left = True
        elif left == right:
            move_left = False
        else:
            if min(part1 - t_list[right + 1], part2 + t_list[right + 1]) \
                    < min(part1 + t_list[left], part2 - t_list[left]):
                move_left = True
            else:
                move_left = False

        if move_left:
            part1 += t_list[left]
            part2 -= t_list[left]
            left += 1
        else:
            right += 1
            part1 -= t_list[right]
            part2 += t_list[right]

        answer = max(answer, min(part1, part2))

    print(answer)



