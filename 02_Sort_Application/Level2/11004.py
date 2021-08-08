# 보물
# https://www.acmicpc.net/problem/11004
# 힌트
# 1. 정렬 후 K-1 인자를 반환해주면 된다.
import sys


if __name__ == "__main__":
    N, K = map(int, sys.stdin.readline().split())

    a_list = list(map(int, sys.stdin.readline().split()))
    a_list.sort()

    print(a_list[K-1])