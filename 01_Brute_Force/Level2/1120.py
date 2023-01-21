# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 문자열
# https://www.acmicpc.net/problem/1120
# 힌트
# 1. A의 앞뒤에는 B에 맞출 수 있기 때문에, B부분 문자열 중에서 A문자열과 가장 적은 차이가 나는때를 찾아 비교하면 된다.

def distance(a, b):
    if len(a) != len(b):
        return -1
    ret = 0
    for j in range(len(a)):
        if a[j] != b[j]:
            ret += 1
    return ret


if __name__ == "__main__":
    A, B = input().split()

    answer = len(A)

    for i in range(len(B) - len(A) + 1):
        diff = distance(A, B[i:(i+len(A))])
        if diff < answer:
            answer = diff

    print(answer)
