# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 영화감독 숌
# https://www.acmicpc.net/problem/1436
# 힌트
# 1. 종말의 수는 6이 적어도 3개만 들어가면 되는게 아니라, 연속해서 3개가 들어가야 한다.

def count6(n):
    cnt = 0
    while n > 0:
        if n % 10 == 6:
            cnt += 1
        else:
            cnt = 0
        if cnt >= 3:
            return True
        n = n // 10

    return False


if __name__ == "__main__":
    N = int(input())

    answer = 665

    while N > 0:
        answer += 1
        if count6(answer):
            N -= 1

    print(answer)