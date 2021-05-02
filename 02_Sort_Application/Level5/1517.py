# 버블 소트
# https://www.acmicpc.net/problem/1517
# 힌트
# 1. 버블 소트로 문제를 풀면 O(N^2)로 시간 초과
# 2. 버블 소트는 수열의 왼쪽에 있는 수가 오른쪽에 있는 수보다 몇개나 더 큰지 알아내면 됨.
# 3. 합병정렬(merge sort)를 통해 정렬을 하며, 정렬 중 왼쪽에 있는 수가 오른쪽에 있는
#    수보다 몇개가 더 큰지 계산하여 더해줌
# 4. 합병정렬의 시간복잡도는 O(nlogn)으로 시간내에 통과가능

import sys


def merge(left_arr, right_arr):
    global answer

    sorted_arr = []
    i, j = 0, 0

    while i < len(left_arr) and j < len(right_arr):
        if left_arr[i] <= right_arr[j]:
            sorted_arr.append(left_arr[i])
            i += 1
        else:
            sorted_arr.append(right_arr[j])
            j += 1
            answer += len(left_arr) - i

    while i < len(left_arr):
        sorted_arr.append(left_arr[i])
        i += 1
    while j < len(right_arr):
        sorted_arr.append(right_arr[j])
        j += 1

    return sorted_arr


def merge_sort(arr):
    if len(arr) <= 1:
        return arr

    middle_idx = len(arr) // 2

    left_arr = merge_sort(arr[:middle_idx])
    right_arr = merge_sort(arr[middle_idx:])

    return merge(left_arr, right_arr)


if __name__ == "__main__":
    N = int(input())
    numbers = list(map(int, sys.stdin.readline().split()))

    answer = 0
    merge_sort(numbers)

    print(answer)
