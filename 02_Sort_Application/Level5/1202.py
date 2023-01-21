# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 보석 도둑
# https://www.acmicpc.net/problem/1202
# 힌트
# 1.가방과 상자 정렬을 무게에 대해서 오름차순으로 정렬하자.
# 2. 허용 무게가 가장 작은 가방부터 가방에서 담을 수 있는 보석의 가치를 모두 담는다.
# 3. 담을 수 있는 가치 중에서 가장 비싼 것을 해당 가방에 넣는다. (이를 위해 우선순위 큐를 이용하면 편리하다.)
# 4. 2~3을 반복하며 가방에서 담을 수 있는 보석에 대한 index를 하나씩 키워가며 추가로 담을 수 있는 보석을 우선순위 큐에 넣어준다.
import sys
import heapq

if __name__ == "__main__":
    N, K = map(int, sys.stdin.readline().split())

    gem_list = []
    for _ in range(N):
        m, v = map(int, sys.stdin.readline().split())
        gem_list.append((m, v))
    gem_list.sort()

    bag_list = []
    for _ in range(K):
        bag_list.append(int(sys.stdin.readline()))
    bag_list.sort()

    answer = 0
    heap = []

    for bag in bag_list:
        while gem_list and bag >= gem_list[0][0]:
            heapq.heappush(heap, -gem_list[0][1]) # Max-Heap을 위해 -1을 곱해줌
            heapq.heappop(gem_list)

        if heap:
            answer += -1 * heapq.heappop(heap)
        elif not gem_list:
            break

    print(answer)