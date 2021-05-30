# 정수 제곱근
# https://www.acmicpc.net/problem/2417
# 힌트
# 1. Binary Search를 이용하여 left와 right의 중앙값을 활용하여 탐색 범위를 좁혀간다.
import math


def binary_search(n):
    left, right = 0, n - 1

    while left <= right:
        middle = (left + right) // 2

        if middle < math.sqrt(n):
            left = middle + 1
        else:
            right = middle - 1

    return left


if __name__ == "__main__":
    N = int(input())

    # 방법 1. Binary Search 이용
    print(binary_search(N))

    # 방법 2. sqrt 함수 사용하여, 제곱으로 값이 일치하지 않는 경우 +1 하여 정답
    # answer = int(math.sqrt(N))
    # if answer * answer != N:
    #     answer += 1
    #
    # print(answer)
