# 주몽
# https://www.acmicpc.net/problem/1940
# 힌트
# 1. 번호들이 고유한 값을 가지므로 M을 만드는 수 중에서 중복되는 수가 없다.
# 2. 투 포인터를 이용해 하나는 갑이 가장 작은값부터 올라가면서, 다른 하나는 값이 가장 큰 값부터 내려가면서 합이 M 이되는 쌍을 찾으면된다.
# 3. 합이 M보다 작다면 작은 값을 하나 더 큰값으로 올려주고, 합이 M보다 작다면 큰값을 하나더 작은 값으로 내려주면 된다.

import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    M = int(sys.stdin.readline())
    A = list(map(int, sys.stdin.readline().split()))

    A.sort()

    left, right = 0, N-1
    answer = 0

    while left < right:
        if A[left] + A[right] == M:
            answer += 1
            left += 1
        elif A[left] + A[right] > M:
            right -= 1
        else:
            left += 1

    print(answer)