# 행성 터널
# https://www.acmicpc.net/problem/2887
# 힌트
# 1. N이 100,000이기 때문에 모든 행성간의 간선을 구하면 메모리 초과가 된다.
# 2. 각 세 좌표값 차이의 절대값의 최소를 거리로 삼으므로
#    각 좌표값으로 정렬하여 이웃한 간선만을 구하면 3 * (N-1)개의 간선만 구하면 된다.
# 3. 간선의 거리를 오름차순으로 정렬한 뒤 Kruskal 알고리즘으로 최소 스패닝 트리를 구하면 된다.

import sys


# 현재 노드 집합에 연결된 최소 idx를 반환
def get_parent(idx):
    global parents

    if idx != parents[idx]:
        parents[idx] = get_parent(parents[idx])
    return parents[idx]


# idx1과 idx2를 같은 집합에 속하게 만들어주는 함수
def union_find(idx1, idx2):
    global parents

    pdx1 = get_parent(idx1)
    pdx2 = get_parent(idx2)

    if pdx1 > pdx2:
        parents[pdx2] = pdx1
    else:
        parents[pdx1] = pdx2


if __name__ == "__main__":
    N = int(input())

    # 1. 각 행성의 좌표와 index를 저장한다.
    stars = []
    for i in range(N):
        stars.append(list(map(int, sys.stdin.readline().split())) + [i])

    # 2. x,y,z 각각 좌표별로 정렬한 뒤, 인접한 행성끼리 거리를 구해서 edge에 저장한다.
    edges = []
    for i in range(3):
        stars.sort(key=lambda x: x[i])
        for j in range(N-1):
            edges.append([abs(stars[j][i] - stars[j + 1][i]), stars[j][3], stars[j + 1][3]])

    # 3. 행성간의 거리를 기준으로 오름차순으로 정렬해준다.
    edges.sort(key=lambda x: x[0])

    # 4. 사이클을 형성하는 간선을 제외하기 위해 각 노드에 연결된 집합의 최소 index 노드를 가지게 할 parents 생성(기본적으로 다른 노드와 연결되어 있지 않으면 자기 자신의 index를 가짐)
    parents = list(range(N))

    answer = 0
    for i in range(len(edges) - 1):
        # 5. 두 정점이 같은 집합에 속하는지 판별
        if get_parent(edges[i][1]) != get_parent(edges[i][2]):
            # 두 정점을 같은 집합에 속하게 병합
            union_find(edges[i][1], edges[i][2])
            answer += edges[i][0]

    print(answer)



