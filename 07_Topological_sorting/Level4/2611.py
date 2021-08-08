# 자동차경주
# https://www.acmicpc.net/problem/2611
# 힌트
# 1. 문제 조건을 통해 경로 내 순환 사이클이 없다는 점을 확인하여 위상정렬을 이용하여 푼다.
import sys
MAXNUM = 1001

if __name__ == "__main__":
    N = int(input())
    M = int(input())
    cnt = 0

    d = [0] * MAXNUM
    pre = [0] * MAXNUM
    depth = [0] * MAXNUM
    cost = [0] * MAXNUM
    adj = [[] for _ in range(MAXNUM)]

    for i in range(M):
        p, q, r = map(int, sys.stdin.readline().split())
        if p == 1:
            d[q] = r
            pre[q] = 1
        else:
            adj[p].append((r,q))
            depth[q] += 1

    i = 1
    while i <= N:
        if depth[i] > 0:
            i += 1
        else:
            for j in range(len(adj[i])):
                nv, nx = adj[i][j]
                if d[nx] < d[i] + nv:
                    d[nx] = d[i] + nv
                    pre[nx] = i
                depth[nx] -= 1
            depth[i] = 1
            i = 0

    cost[cnt] = 1
    cnt += 1

    while pre[1] != 1:
        cost[cnt] = pre[1]
        cnt += 1
        pre[1] = pre[pre[1]]
    cost[cnt] = 1
    cnt += 1

    print(d[1])
    for i in range(cnt - 1, -1, -1):
        print(cost[i], end=' ')