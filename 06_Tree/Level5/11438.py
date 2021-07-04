# LCA 2
# https://www.acmicpc.net/problem/11438
# 힌트
# 1. 공통 조상을 상위 노드 하나씩 비교를 하다보면 시간 안에 통과할 수가 없다. 복잡도 O(NxM)이기 때문이다.
# 2. LCA (11437문제)와의 차이는 조상을 찾는 검색 복잡도를 log로 줄여주기 위해, 높이를 맞춰주는 과정에서 2의 n승씩 점프를 해가면서 부모값을 찾아 비교한다.
#    이를 위해 2의 n승의 부모 노드를 미리 저장해 놓는다.
# * python의 경우 pypy3로 컴파일해야 시간초과 안남.
import sys
from collections import deque

def LCA(u, v):
    if depth[u] > depth[v]:
        u, v = v, u

    # 두 노드의 깊이가 같아질때까지 v노드는 위로 거슬러 올라감
    while depth[u] != depth[v]:
        # 두 노드의 깊이 차이
        dist = depth[v] - depth[u]

        for i in range(20):
            if (dist <= (2 << i)):
                # 2^i 만큼 거슬러 오라감
                v = parent[v][i]
                break

    while u != v:
        for i in range(20):
            if parent[u][i + 1] == parent[v][i + 1]:
                u = parent[u][i]
                v = parent[v][i]
                break

    return u


if __name__ == "__main__":
    N = int(sys.stdin.readline())
    node = [[] for _ in range(100001)]

    for i in range(N - 1):
        u, v = map(int, sys.stdin.readline().split())
        node[u].append(v)
        node[v].append(u)

    check = [False] * 100001
    depth = [0] * 100001
    check[1] = True
    q = deque()
    q.append(1)

    parent = [[0] * 20 for _ in range(100001)]


    while len(q) > 0:
        x = q.popleft()
        for child in node[x]:
            if not check[child]:
                depth[child] = depth[x] + 1
                check[child] = True
                parent[child][0] = x
                for j in range(20):
                    parent[child][j + 1] = parent[parent[child][j]][j];
                    # 2^(j+1) 위에 부모노드가 없을 경우
                    if parent[child][j + 1] == 0:
                        break
                q.append(child)

    M = int(sys.stdin.readline())

    for i in range(M):
        u, v = map(int, sys.stdin.readline().split())
        print(LCA(u, v))