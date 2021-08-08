# 꼬인 전깃줄
# https://www.acmicpc.net/problem/1365
# 힌트
# 1. 왼쪽 전봇대를 기준으로 오른쪽에 매칭된 전봇대의 위치가 단조 증가하게 되면 꼬인 전깃줄이 없게 된다.
#    즉, LIS(Longest Increasing Subsequence)의 길이를 구하여 전체 전깃줄의 개수에서 빼주면 된다.
# 2. LIS를 구하는 방법에서 오른쪽 전봇대의 위치값을 기준으로 순차적으로 구할 때, 새로운 전봇대의 위치가
#    축적시켜놓은 vector의 어느 위치에 넣어주어야 할지 binary search로 찾아주면 시간 내에 풀 수 있다.
import sys


def bs(num):
    left, right = 0, len(a_list) - 1

    while left < right:
        mid = (left + right) // 2
        if a_list[mid] >= num:
            right = mid
        else:
            left = mid + 1
    return right


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    v_list = list(map(int, sys.stdin.readline().split()))

    a_list = [-1]

    for v in v_list:
        if v > a_list[-1]:
            a_list.append(v)
        else:
            a_list[bs(v)] = v

    print((N - len(a_list) + 1))
