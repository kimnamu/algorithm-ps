# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 귀여운 라이언
# https://www.acmicpc.net/problem/15565
# 힌트
# 1. K개의 1을 포함하는 배열의 길이가 최소가 뙬때를 찾으면 된다.
# 2. 투 포인터를 이용하여 1의 갯수가 K개보다 작으면 오른쪽 포인터를 키워주고,
#    K보다 크면 오니쪽 포인터를 키워 준다.
# 3. 어떤 경우도 K개의 1을 포함하지 못할 경우 -1을 반환한다.
import sys


def is_ryon(k):
    return k == 1


if __name__ == "__main__":
    N, k = map(int, sys.stdin.readline().split())
    A = list(map(int, sys.stdin.readline().split()))

    left, right = 0, 0
    cnt = 1 if is_ryon(A[0]) else 0
    answer = N + 1

    while True:
        if cnt == k:
            answer = min(answer, right - left + 1)
            if is_ryon(A[left]):
                cnt -= 1
            left += 1
        elif cnt < k:
            right += 1
            if right == N:
                break
            if is_ryon(A[right]):
                cnt += 1
        else:
            if is_ryon(A[left]):
                cnt -= 1
            left += 1

    if answer == N + 1:
        answer = -1

    print(answer)
