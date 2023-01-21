# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 게임
# https://www.acmicpc.net/problem/1072
# 힌트
# 1. 최소 몇번을 이겨야하는지 그 횟수를 binary search를 통해 찾아보자.
# 2. 형변환에 주의하자.
#    예를 들어, 정수형 변수 x, y에 대해서 "(y*100)/x"과  "y/x * 100"은 값이 다르다.


def solve(x, y):
    if x == y or 99 <= (y * 100) / x:
        return -1

    z = y * 100 // x
    l, r, m = 0, 1000000000, -1

    while l <= r:
        m = (l + r) // 2
        z_new = (y + m) * 100 // (x + m)

        if z_new <= z:
            l = m + 1
        else:
            r = m - 1

    return l


if __name__ == "__main__":
    X, Y = map(int, input().split())

    answer = solve(X, Y)

    print(answer)
