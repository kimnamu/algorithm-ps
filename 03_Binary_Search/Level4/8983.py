# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 사냥꾼
# https://www.acmicpc.net/problem/8983
# 힌트
# 1. 동물을 기준으로 사냥 가능한 범위에 사로가 있는지 이분 탐색으로 구하면 된다.
# 2. 사냥 가능한 범위는 L값을 기준으로 동물의 위치로 부터 가장 멀리 떨어 질 수 있는 lower와 upper를 구한다.
# 3. 각각의 동물에 대해 lower와 upper를 지정 후, 가능한 사로가 있는지 이분 탐색 한다.
import sys

if __name__ == "__main__":
    M, N, L = map(int, sys.stdin.readline().split())

    m_list = list(map(int, sys.stdin.readline().split()))
    m_list.sort()

    answer = 0
    for _ in range(N):
        x, y = map(int, sys.stdin.readline().split())

        if y > L:
            continue
        upper, lower = x + (L - y), x - (L - y)
        left, right = 0, len(m_list) - 1

        while left <= right:
            mid = (left + right) // 2
            if lower <= m_list[mid] and m_list[mid] <= upper:
                answer += 1
                break
            elif m_list[mid] < lower:
                left = mid + 1
            else:
                right = mid - 1

    print(answer)