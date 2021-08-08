# 입국심사
# https://www.acmicpc.net/problem/3079
# 힌트
# 1. 구해야할 최소 시간을 Binary Search를 통해 탐색한다.
# 2. 해당 시간안에 M명의 사람들이 모두 통과할 수 있는지를 체크하면서 통과 가능한 가장 작은 수를 찾으면 된다.
import sys


# 해당 시간 내에 통과 될 수 있는 인원
def solve(tt):
    ret = 0
    for t_val in t_list:
        ret += tt // t_val
    return ret


def bs(right):
    l, r, m = 0, right, 0

    while l <= r:
        m = (l + r) // 2
        if solve(m) >= M:
            r = m - 1
        else:
            l = m + 1

    return l


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())

    t_list = [int(sys.stdin.readline()) for _ in range(N)]

    right = max(t_list) * M

    answer = bs(right)

    print(answer)