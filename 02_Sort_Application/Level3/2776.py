# 암기왕
# https://www.acmicpc.net/problem/2776
# 1. N과 M을 일일이 비교하면 복잡도가 O(NM)이기 때문에 시간 초과가 된다.
# 2. N을 정렬하여 M의 값들을 binary search하여 logN만에 찾도록 하자.


def binary_search(val):
    l = 0
    r = n1 - 1

    while l <= r:
        m = (l + r) // 2
        if val == note1[m]:
            return 1
        elif val < note1[m]:
            r = m - 1
        else:
            l = m + 1

    return 0


if __name__ == "__main__":
    N = int(input())

    for _ in range(N):
        n1 = int(input())
        note1 = list(map(int, input().split()))
        n2 = int(input())
        note2 = list(map(int, input().split()))
        note1.sort()

        for value in note2:
            print(binary_search(value))