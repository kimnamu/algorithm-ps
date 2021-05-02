# ATM
# https://www.acmicpc.net/problem/11399
# 힌트
# 1. 대기시간이 짧은 사람이 먼저 ATM기를 이용할 수록 뒷사람들의 누적 대기시간이 짧아진다.

if __name__ == "__main__":
    N = int(input())
    customers = list(map(int, input().split()))

    customers.sort()

    answer = 0
    for i in range(1, N + 1):
        # 누적 대기시간의 합
        answer += sum(customers[:i])

    print(answer)