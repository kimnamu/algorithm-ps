# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 전화번호 목록
# https://www.acmicpc.net/problem/5052
# 힌트
# 1. 전화번호 목록을 문자열 형식으로 받아서 문자열 순서대로 정렬
# 2. 문자열 순서대로 정렬되어 있으므로 현재 번호와 다음 번호만 비교하면 가능

import sys

# 인접한 두 번호가 접두어로 시작하는지 확인하는 함수
def solve(numbers):
    for i in range(len(numbers) - 1):
        if numbers[i] == numbers[i + 1][:len(numbers[i])]:
            return False

    return True


if __name__ == "__main__":
    T = int(input())

    for t in range(T):
        N = int(input())

        # 전화번호를 문자열 형식으로 입력받아 저장
        p_numbers = []
        for i in range(N):
            p_numbers.append(sys.stdin.readline().strip())

        # 문자열 오름차순으로 정렬
        p_numbers.sort()

        if solve(p_numbers):
            print("YES")
        else:
            print("NO")
