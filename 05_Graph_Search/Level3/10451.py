# 촌수계산
# https://www.acmicpc.net/problem/2644
# 힌트
# 1. 부모-자식, 자식-부모 와같이 특별히 순서는 상관 없다.
# 2. BFS를 통해 목표로 하는 노드를 찾는데 걸리는 스텝이 촌수계산의 답이 됩니다.
import sys
sys.setrecursionlimit(1000000)


def solve():
    ans = 0

    for i in range(1, N + 1):
        if not check[i]:
            check[i] = True
            dfs(i)
            ans += 1

    return ans


def dfs(k):
    e = edges[k]
    if not check[e]:
        check[e] = True
        dfs(e)


if __name__ == "__main__":
    T = int(sys.stdin.readline())

    for _ in range(T):
        N = int(sys.stdin.readline())

        check = [False] * (N + 1)
        edges = [0] + list(map(int, sys.stdin.readline().split()))

        answer = solve()

        print(answer)
