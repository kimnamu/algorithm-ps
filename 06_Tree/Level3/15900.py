# 나무 탈출
# https://www.acmicpc.net/problem/15900
# 힌트
# 1. 성원이는 먼저 시작하기 때문에 홀수 번째 턴이다. 때문에 짝수 번째 턴에 모든 말이 사라지면 성원이가 지가 된다.
# 2. root의 깊이를 0으로 잡았을때, 모든 리프노드의 깊이의 합이 홀수이면 성원이가 이기게 된다.
# * python는 pypy3로 컴파일해야 시간초과 안남.
import sys
sys.setrecursionlimit(100000)


def dfs(node, cnt):
    global total_depth

    visited[node] = True

    for next_node in tree[node]:
        if not visited[next_node]:
            dfs(next_node, cnt + 1)

    if node != 1 and len(tree[node]) == 1:
        total_depth += cnt


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    tree = [[] for _ in range(N + 1)]
    visited = [False] * (N + 1)

    for _ in range(N - 1):
        a, b = map(int, sys.stdin.readline().split())

        tree[a].append(b)
        tree[b].append(a)

    visited[1] = True
    total_depth = 0

    dfs(1, 0)

    if total_depth % 2 == 0:
        print('No')
    else:
        print('Yes')