# Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
# 암호 만들기
# https://www.acmicpc.net/problem/1759
# 힌트
# 1. 문자를 순서대로 정렬한 후, dfs를 활용하여 완전탐색을 하며 만들어지는 문자열들 중
# 모음수, 자음수 조건을 만족하는 문자열을 순서대로 출력한다.
def dfs(index, depth):
    global vowel, consonant, visited

    if depth == L:
        if vowel >= 1 and consonant >= 2:
            for i in range(C):
                if visited[i]:
                    print(alphas[i], end='')
            print()
        return

    # 정렬된 문자열만 정답이 되므로, index부터 시작
    for i in range(index, C):
        if not visited[i]:
            visited[i] = True
            if isVowel(alphas[i]):
                vowel += 1
            else:
                consonant += 1

            # dfs로 다음 위치의 문자 탐색
            dfs(i + 1, depth + 1)

            visited[i] = False
            if isVowel(alphas[i]):
                vowel -= 1
            else:
                consonant -= 1

# 모음인지 판단
def isVowel(ch):
    if ch in ['a', 'e', 'i', 'o', 'u']:
        return True
    return False


if __name__ == "__main__":
    L, C = map(int, input().split())

    alphas = input().split()
    visited = [False] * C

    # 정렬된 문자열 출력을 위해 정렬함
    alphas.sort()

    vowel, consonant = 0, 0
    dfs(0, 0)