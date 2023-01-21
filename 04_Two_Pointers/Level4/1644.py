# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 소수의 연속합
# https://www.acmicpc.net/problem/1644
# 힌트
# 1. 먼저 N 제한인 4000000까지 (혹은 N까지)의 소수를 구한다. 에라토스테네스의 체 방법을 이용하면 O(NloglogN)만에 모든 소수를 구할 수 있다.
# 2. 모든 소수에 대해서 투 포인터를 이용해 구간을 이동시키면서 합을 구한다.
#   2.1 구간합이 N보다 크면 왼쪽 포인터 위치 값을 빼주면서 한칸 옮겨준다.
#   2.2 구간합이 N보다 작으면 오른쪽 포인터 위치 값을 한칸 옮겨준 후 값을 더해준다.

def get_prime_numbers(n):
    prime_check = [True] * (n + 1)
    p_numbers = []

    for i in range(2, N+1):
        if not prime_check[i]:
            continue
        j = 2
        while j * i < N + 1:
            prime_check[j * i] = False
            j += 1

    for i in range(2, N + 1):
        if prime_check[i]:
            p_numbers.append(i)

    return p_numbers


def solve():
    if N == 1:
        return 0
    left, right = 0, 0
    p_sum = prime_numbers[right]
    ans = 0

    while True:
        if p_sum == N:
            ans += 1
            p_sum -= prime_numbers[left]
            left += 1
        elif p_sum > N:
            p_sum -= prime_numbers[left]
            left += 1
        else:
            right += 1
            if right == len(prime_numbers):
                break
            p_sum += prime_numbers[right]

    return ans


if __name__ == "__main__":
    N = int(input())

    prime_numbers = get_prime_numbers(N)

    answer = solve()

    print(answer)
