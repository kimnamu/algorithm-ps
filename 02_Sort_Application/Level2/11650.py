# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 좌표 정렬하기
# https://www.acmicpc.net/problem/11650
import sys

if __name__ == "__main__":
    N = int(input())
    coord_list = []
    # 좌표(x,y)를 list에 입력
    for _ in range(N):
        x, y = map(int, sys.stdin.readline().split())
        coord_list.append([x, y])

    # list의 sort 함수 이용하여 x, y 순으로 정렬
    coord_list.sort(key=lambda x: (x[0], x[1]))

    for coord in coord_list:
        print(coord[0], coord[1])