# 부분수열의 합
# https://www.acmicpc.net/problem/14225
from itertools import combinations

def dfs(num, sum):
    global visited
    visited[sum] = True

    if num == N:
        return

    # 해당 number를 사용하는 경우
    dfs(num + 1, sum + nums[num])
    # 해당 number를 사용하지 않는 경우
    dfs(num + 1, sum)


def comb():
    global visited

    for j in range(1, N+1):
        for numbers in combinations(nums, j):
            visited[sum(numbers)] = True


if __name__ == "__main__":
    N = int(input())
    nums = list(map(int, input().split()))

    visited = [False] * 100000 * N

    ## 방법1. dfs로 완전 탐색
    dfs(0, 0)

    ## 방법2. combinations 함수 사용
    # comb()

    for i in range(1, len(visited)):
        if not visited[i]:
            print(i)
            break