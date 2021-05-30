# 두 수의 합
# https://www.acmicpc.net/problem/3273
# 힌트
# 1. 리스트를 정렬을 한 뒤, 투 포인터를 사용하여
# 2. 하나는 작은 값부터 올라가면서, 다른 하나는 큰 값부터 내려가면서 합이 x가 되는 쌍을 찾으면 된다.
# 3. 합이 x보다 작으면 작은 값을 하나 더 큰 값으로 올려주고, 합이 x보다 작다면 큰 값을 하나 더 작은 값으로 내려주면 된다.

import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    A = list(map(int, sys.stdin.readline().split()))
    x = int(sys.stdin.readline())

    A.sort()

    left, right = 0, N-1
    answer = 0

    while left < right:
        if A[left] + A[right] == x:
            answer += 1
            left += 1
        elif A[left] + A[right] > x:
            right -= 1
        else:
            left += 1

    print(answer)