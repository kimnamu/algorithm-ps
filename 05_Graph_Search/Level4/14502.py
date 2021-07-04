# 연구소
# https://www.acmicpc.net/problem/14502
# 힌트
# 1. 벽의 위치 3곳을 완전 탐색을 통해 모든 경우를 위치 시킨다. N, M이 최대 8이므로 O(NM^3) 10만 단위의 복잡도까지 밖에 되지 않는다.
# 2. 각 경우에 대해, 바이러스가 감염되어 퍼지게 한다.
# 3. 바이러스가 퍼진 상태에서 멀쩡한 0의 위치를 counting한다.
import sys
import copy
dxy = [(-1, 0), (1, 0), (0, -1), (0, 1)]


def spread(i, j):
    for dx, dy in dxy:
        x = i + dx
        y = j + dy

        if 0 <= x < N and 0 <= y < M and infection[x][y] == 0:
            infection[x][y] = 2
            spread(x, y)


def dfs(i, j, cnt):
    for dx, dy in dxy:
        x = i + dx
        y = j + dy

        if 0 <= x < N and 0 <= y < M and infection[x][y] == 0:
            infection[x][y] = 1
            cnt += dfs(x, y, 1)

    return cnt

if __name__ == "__main__":
    N, M = map(int, sys.stdin.readline().split())
    table = []

    for i in range(N):
        table.append(list(map(int, sys.stdin.readline().split())))

    answer = 0

    for k1 in range(N * M):
        x1, y1 = k1 // M, k1 % M
        if table[x1][y1] != 0:
            continue

        for k2 in range(k1+1, N * M):
            x2, y2 = k2 // M, k2 % M
            if table[x2][y2] != 0:
                continue

            for k3 in range(k2 + 1, N * M):
                x3, y3 = k3 // M, k3 % M
                if table[x3][y3] != 0:
                    continue

                infection = copy.deepcopy(table)

                # 3군데 벽 세우기
                infection[x1][y1] = 1
                infection[x2][y2] = 1
                infection[x3][y3] = 1

                # 바이러스 퍼뜨리기
                for i in range(N):
                    for j in range(M):
                        if infection[i][j] == 2:
                            spread(i, j)

                cnt = 0

                # 안전 영역 계산
                for i in range(N):
                    for j in range(M):
                        if infection[i][j] == 0:
                            infection[i][j] = -1
                            cnt += dfs(i, j, 1)

                answer = max(answer, cnt)

    print(answer)