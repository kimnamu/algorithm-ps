# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 문제집
# https://www.acmicpc.net/problem/1766
# 힌트
# 1. 위상정렬을 이용한다.
# 2. 각 순서를 갇는 노드에 대해 뒤에 오는 노드에 대해 앞에 와야만 하는 이전 노드의 수를 counting해 둔다.
# 3. 앞에 와야만 하는 노드의 수가 0인 노드들을 순서대로 출력하면서, 연결된 노드들의 이전 노드의 수를 갱신해 준다.
#  단, 이때 input node의 수가 0인 노드 중 가장 작은 숫자 부터 출력해야 하므로 우선순위 큐를 이용해준다.
import sys
import heapq

if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())

    in_cnt = [0] * (N + 1)
    v = [[] for _ in range(N + 1)]

    for i in range(M):
        a, b = map(int, sys.stdin.readline().split())
        in_cnt[b] += 1
        v[a].append(b)

    q = []

    for i in range(1, N + 1):
        if in_cnt[i] == 0:
            heapq.heappush(q, i)

    while len(q) > 0:
        i = heapq.heappop(q)
        print(str(i), end = ' ')
        for j in range(len(v[i])):
            in_cnt[v[i][j]] -= 1
            if in_cnt[v[i][j]] == 0:
                heapq.heappush(q, v[i][j])