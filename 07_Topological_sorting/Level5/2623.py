# 음악프로그램
# https://www.acmicpc.net/problem/2623
# 힌트
# 1.  PD들 서로의 목록에 싸이클이 있는 경우 모든 PD들의 요구사항을 만족할 수 없으니 위상정렬을 하면서 사이클 존재 여부 또한 검사해야한다.
# 2.  맨 마지막 노드인 리프를 제일 끝에 두는 방법이 일반적인 위상 정렬의 방법이다.
#     leaf 노드들을 결과를 저장할 배열의 끝에 넣고, 트리에 제외하면서 다음 리프노드를 찾는것을 반복하면 결국 배열에는 위상 정렬된 트리를 얻을 수 있다.
import sys


def dfs(k):
    visited[k] = True
    for i in range(len(adj[k])):
        if adj[k][i] == False:
            continue
        if visited[i]:
            if not i in v:
                return False
        else:
            if not dfs(i):
                return False
    v.append(k)
    return True


if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    adj = [[False] * N for _ in range(N)]
    visited = [False] * N
    v = []

    for i in range(M):
        tp = list(map(int, sys.stdin.readline().split()))
        t = tp[0]

        b = 0
        for j in range(t):
            a = tp[j+1] - 1
            if j != 0:
                adj[b][a] = True
            b = a

    for i in range(N):
        if not visited[i] and not dfs(i):
            print(0)
            sys.exit(0)

    for i in range(N-1, -1, -1):
        print(v[i] + 1)
