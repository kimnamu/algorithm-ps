import sys


if __name__ == "__main__":
    N = int(sys.stdin.readline())

    MOD = 1000000000
    dp = [[[0] * 2000 for _ in range(10)] for _ in range(110)]

    for i in range(10):
        dp[1][i][1 << i] = 1

    for i in range(2, N + 1):
        for j in range(0, 10):
            a = 1 << j
            for k in range(1, 1024):
                if j == 0:
                    dp[i][j][k | a] += dp[i - 1][j + 1][k]
                elif j == 9:
                    dp[i][j][k | a] += dp[i - 1][j - 1][k]
                else :
                    dp[i][j][k | a] += dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]

                dp[i][j][k | a] %= MOD

    sum = 0
    for i in range(1, 10):
        sum += dp[N][i][1023]

    print(sum % MOD)