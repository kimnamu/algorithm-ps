# 수열
# https://www.acmicpc.net/problem/2559
# 힌트
# 1. K개의 수를 합하는게 정해져 있으므로 K의 위치차이를 가지는 투 포인터를 활용하여 구간 합을 구한다.
# 2. 오른쪽 포인터를 증가시키면서 값을 더하고, 왼쪽 포인터를 증가시키면서 값을 빼준다.
# 3. 이렇게 포인터를 옮겨가면서 더한 합이 가장 큰 값을 정답으로 반환한다.

import sys

if __name__ == "__main__":
    N, K = map(int, sys.stdin.readline().split())
    A = list(map(int, sys.stdin.readline().split()))

    p_sum = sum(A[:K])

    left, right = 0, K-1
    answer = p_sum

    while right < N - 1:
        right += 1
        p_sum += A[right]
        p_sum -= A[left]
        left += 1
        answer = max(answer, p_sum)

    print(answer)