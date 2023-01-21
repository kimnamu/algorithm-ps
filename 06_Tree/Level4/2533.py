# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 사회망 서비스(SNS)
# https://www.acmicpc.net/problem/2533
# 힌트
# 1. Tree구조를 이용한 완전탐색과 DP를 활용한다.
# 2. 현재 정점이 얼리어답터라면, 연결되어 있는 정점도 얼리어답터로 설정하는 경우, 연결되어 있는 정점을 얼리어답터로 설정하지 않는 경우.
#    이 2가지 경우를 모두 비교한 후에 더 최소값으로 값을 저장해 주면 된다.
# 3. 현재 정점이 얼리어답터가 아니라면, 이 현재 정점과 연결되어 있는 정점들은 반드시 얼리어답터여야 한다.
#    따라서 이 경우에는 다음 정점으로 넘어가기 위해서 탐색을 할 때, 연결되어 있는 정점들은 반드시 얼리어답터가 되도록탐색을 진행하면 된다.
import sys
sys.setrecursionlimit(1000000)


def init():
    def init_tree(index):
        visited[index] = True
        for next_node in (v[index]):
            if not visited[next_node]:
                tree[index].append(next_node)
                init_tree(next_node)

    v = [[] for _ in range(MAX)]
    visited = [False] * MAX
    for _ in range(N - 1):
        a, b = map(int, sys.stdin.readline().split())
        v[a].append(b)
        v[b].append(a)
    init_tree(1)


def dfs(index, state):
    if dp[index][state] != -1:
        return dp[index][state]

    if state == 1:
        dp[index][state] = 1
        for next_node in tree[index]:
            dp[index][state] += min(dfs(next_node, 0), dfs(next_node, 1))
    else:
        dp[index][state] = 0
        for next_node in tree[index]:
            dp[index][state] += dfs(next_node, 1)

    return dp[index][state]


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    MAX = N + 1
    tree = [[] for _ in range(MAX)]
    init()

    dp = [[-1, -1] for _ in range(MAX)]

    answer = min(dfs(1, 0), dfs(1, 1))
    print(answer)