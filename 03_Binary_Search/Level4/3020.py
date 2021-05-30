# 개똥벌레
# https://www.acmicpc.net/problem/3020
# 힌트
# 1. 개똥벌레가 통과하려는 구간(1~h)에 따라 통과해야 하는 장애물의 수를 찾으면 되고 장애물 수는 U자 곡선을 그리게 된다.
# 2. 통과 구간이 정해지면 정렬해놓은 종유석, 석순에 대해 binary search로 파괴해야하는 장애물 수를 구한다.
#    이때 복잡도는 O(NlogN + HlogN) 이 된다.

import sys


def bs(height):
    cnt = 0
    left, mid, right = 0, -1, n // 2 - 1

    while left <= right:
        mid = (left + right) // 2
        if bottom[mid] >= height:
            right = mid - 1
        else:
            left = mid + 1
    cnt += n // 2 - left

    left, mid, right = 0, -1, n // 2 - 1

    while left <= right:
        mid = (left + right) // 2
        if top[mid] >= h - height + 1:
            right = mid - 1
        else:
            left = mid + 1
    cnt += n // 2 - left

    return cnt


def solve():
    answer, temp, answer_cnt = n, 0, 0

    for i in range(1, h + 1):
        temp = bs(i)

        if answer == temp:
            answer_cnt += 1

        if answer > temp:
            answer = temp
            answer_cnt = 1

    print(answer, answer_cnt)


if __name__ == "__main__":
    n, h = map(int, input().split())

    bottom = []
    top = []
    for i in range(n):
        if i % 2 == 0:
            bottom.append(int(sys.stdin.readline()))
        else:
            top.append(int(sys.stdin.readline()))

    bottom.sort()
    top.sort()

    solve()