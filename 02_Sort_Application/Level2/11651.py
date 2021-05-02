# 좌표 정렬하기
# https://www.acmicpc.net/problem/11650
import sys

if __name__ == "__main__":
    N = int(input())
    coord_list = []

    for _ in range(N):
        # input() 사용시 시간 초과.
        x, y = map(int, sys.stdin.readline().split())
        coord_list.append([x, y])

    # y, x 순으로 정렬
    coord_list.sort(key=lambda x: (x[1], x[0]))

    # 출력
    for coord in coord_list:
        print(coord[0], coord[1])