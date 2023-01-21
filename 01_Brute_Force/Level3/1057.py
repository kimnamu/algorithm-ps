# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 토너먼트
# https://www.acmicpc.net/problem/1057

if __name__ == "__main__":
    N, a, b = map(int, input().split())
    answer = 1

    # 1. a < b로 swap 해준다.
    if a > b:
        a, b = b, a

    # 2. 토너먼트에서 지정된 두 사람이 만나기 위해서는, 번호가 낮은사람이 홀수, 번호가 큰사람이 그보다 1큰 짝수 일때 대결을 하게 된다.
    while True:
        if a % 2 == 1 and b - a == 1:
            break

        a = (a + 1) // 2
        b = (b + 1) // 2
        answer += 1

    print(answer)