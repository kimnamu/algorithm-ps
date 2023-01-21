# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>

def solve(n):
    dp[1] = 0

    for i in range(2, N + 1):
        dp[i] = dp[i - 1] + 1
        fr[i] = i - 1
        if i % 3 == 0:
            if dp[i] > dp[i // 3] + 1:
                dp[i] = dp[i // 3] + 1
                fr[i] = i // 3
        if i % 2 == 0:
            if dp[i] > dp[i // 2] + 1:
                dp[i] = dp[i // 2] + 1
                fr[i] = i // 2
    return dp[n]


if __name__ == "__main__":
    N = int(input())

    dp = [0] * 1000001
    fr = [0] * 1000001
    print(solve(N))

    while True:
        if N == 0:
            break
        print(N, end=' ')
        N = fr[N]