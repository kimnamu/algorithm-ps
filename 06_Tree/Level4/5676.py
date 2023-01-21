# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 음주 코딩
# https://www.acmicpc.net/problem/5676
# 힌트
# 1. 구간연산을 위해 Segment Tree를 활용한다.
import sys


def sumc(k):
    ret = 0
    while k > 0:
        ret += tree[k]
        k -= (k & -k)

    return int(ret)


def update(k, val):
    while k <= N:
        tree[k] += val
        k += (k & -k)


if __name__ == "__main__":
    while True:
        try:
            N, K = map(int, sys.stdin.readline().split())
            tree = [0] * 500000
            # v = [0] * 500000
            v = [0] + list(map(int, sys.stdin.readline().rstrip().split()))

            for i in range(1, N + 1):
                if v[i] == 0:
                    update(i, 1e6)
                elif v[i] > 0:
                    update(i, 0)
                elif v[i] < 0:
                    update(i, 1)

            for i in range(1, K + 1):
                c, x, y = list(sys.stdin.readline().split())
                x, y = int(x), int(y)

                if c == 'P':
                    ans = sumc(y) - sumc(x-1)
                    if ans >= 1000000:
                        print('0', end='')
                    elif ans & 1:
                        print('-', end='')
                    else:
                        print('+', end='')
                elif c == 'C':
                    tmp1 = 0 if y > 0 else 1 if y < 0 else 1e6
                    tmp2 = 0 if v[x] > 0 else 1 if v[x] < 0 else 1e6
                    diff = tmp1 - tmp2
                    v[x] = y
                    update(x, diff)
            print()
        except Exception:
            break