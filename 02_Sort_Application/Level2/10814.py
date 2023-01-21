# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 나이순 정렬
# https://www.acmicpc.net/problem/10814

if __name__ == "__main__":
    N = int(input())
    cm_list = []
    # 고객정보(나이, 이름)을 tuple-자료형으로 list에 입력
    for _ in range(N):
        age, name = input().split()
        cm_list.append((int(age), name))

    # list의 sort 함수 이용하여 첫번째 정보(나이)순으로 정렬
    cm_list.sort(key=lambda x: x[0])

    for member in cm_list:
        print(member[0], member[1])