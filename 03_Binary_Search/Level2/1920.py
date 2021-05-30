# 수 찾기
# https://www.acmicpc.net/problem/1920
# 힌트
# 1. m개의 숫자들을 n개의 숫자내에서 완전 탐색으로 찾게되면 복잡도가 o(nm)이 되므로 완전탐색을 하면 시간초과가 난다.
# 2. 정렬 후 binary search를 통해 정렬 하고나서는 o(log n)에 찾을 수 있다.

import sys


def bs(k):
    # l, r, m은 index 일뿐 실제 값을 a에서 찾아 비교해야 한다.
    l, r = 0, len(a) - 1
    if a[l] > k or a[r] < k:
        return False

    while l <= r:
        m = (l + r) // 2
        if a[m] == k:
            return True
        elif a[m] > k:
            r = m - 1
        else:
            l = m + 1
    return False


if __name__ == "__main__":
    n = int(input())
    a = list(map(int, sys.stdin.readline().split()))

    m = int(input())
    b = list(map(int, sys.stdin.readline().split()))

    a.sort()

    for val in b:
        if bs(val):
            print("1")
        else:
            print("0")
