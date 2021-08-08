# 좌표 압축
# https://www.acmicpc.net/problem/18870
# 힌트
# 1. X원소 중 중복을 제외하고 오름차순으로 정렬된 새로운 set를 구한다.
# 2. 이 set 값의 작은 수부터 0부터 시작하는 좌표 값을 mapping 해준다.

import sys

if __name__ == "__main__":
    N = int(input())
    a_list = list(map(int, sys.stdin.readline().split()))

    result_dict = {}

    b_set = sorted(set(a_list))

    for i, val in enumerate(b_set):
        result_dict[val] = i

    for val in a_list:
        print(result_dict[val])



