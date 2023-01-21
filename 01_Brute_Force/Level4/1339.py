# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 단어 수학
# https://www.acmicpc.net/problem/1339


if __name__ == "__main__":
    N = int(input())
    strs = []
    for _ in range(N):
        strs.append(input())

    # 각 알파벳별로 다 합쳤을때 얼마나 기여하는지 계산
    pow_str = [0] * 26
    for i in range(N):
        power = 1
        for ch in reversed(strs[i]):
            pow_str[ord(ch) - ord('A')] += power
            power *= 10

    pow_str.sort(reverse=True)

    # 기여도가 높은 순으로 9부터 대입시켜준 합을 구함.
    answer = 0
    current_num = 9
    for p in pow_str:
        answer += p * current_num
        current_num -= 1

    print(answer)

