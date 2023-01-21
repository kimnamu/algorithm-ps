# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 리모컨
# https://www.acmicpc.net/problem/1107
# 힌트
# 1. 리모컨으로 숫자를 먼저 고를때 0부터 누르는 경우는 카운팅하지 않도록 하자.
# 2. 반례 (https://www.acmicpc.net/board/view/46120)


def changeEntirely(m):
    result = 500000
    for i in range(1000000):
        if valid(i):
            dist = len(str(i)) + abs(i-m)
            if result > dist:
                result = dist

    return result


# 해당 채널을 누르는 것이 가능한지 여부
def valid(num):
    num_str = str(num)
    for i in range(len(num_str)):
        if num_str[i] in broken_nums:
            return False
    return True


if __name__ == "__main__":
    N = int(input())
    M = int(input())

    if M > 0:
        broken_nums = list(input().split())
    else:
        broken_nums = []

    # +/-로 채널 변경했을 때
    answer = abs(N - 100)

    # 수동 채널 변경 후 +/- 채널 변경했을 때
    answer = min(answer, changeEntirely(N))

    # 정답 출력
    print(answer)