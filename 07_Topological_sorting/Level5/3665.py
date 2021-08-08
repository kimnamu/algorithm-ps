# 최종 순위
# https://www.acmicpc.net/problem/3665
# 힌트
# 1. 위상정렬을 이용해 정렬 후 순위를 출력 한다.
import sys
from collections import deque
MAXNUM = 501

def topological_sort():
    q = deque()
    for i in range(1, N + 1):
        if indegree[i] == 0:
            q.append(i)

    while q:
        if len(q)>1:
            return 0
        cur = q.popleft()

        answer.append(team[cur])
        if len(answer) == N:
            return 1

        for i in range(1, N + 1):
            if not adj[cur][i]:
                continue
            adj[cur][i] = False
            indegree[i] -= 1
            if indegree[i] == 0:
                q.append(i)
    return -1

if __name__ == "__main__":
    T = int(input())

    for _ in range(T):
        N = int(input())

        answer = []
        team = [0] * MAXNUM
        order = [0] * MAXNUM
        indegree = [0] * MAXNUM
        adj = [[False] * MAXNUM for _ in range(MAXNUM)]

        team = [0] + list(map(int, sys.stdin.readline().split()))
        for i in range(1, N + 1):
            order[team[i]] = i

        for i in range(1, N):
            for j in range(i+1, N + 1):
                adj[i][j] = True
                indegree[j] += 1

        M = int(input())
        for j in range(M):
            f, s = map(int, sys.stdin.readline().split())
            if order[f] > order[s]:
                f, s = s, f
            node_f, node_s = order[f], order[s]

            adj[node_f][node_s] = False
            indegree[node_s] -= 1

            adj[node_s][node_f] = True
            indegree[node_f] += 1

        result = topological_sort()

        if result == -1:
            print("IMPOSSIBLE")
        elif result == 0:
            print("?")
        else:
            for j in range(len(answer)):
                print(answer[j], end=' ')
            print()



