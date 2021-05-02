# 차이를 최대로
# https://www.acmicpc.net/problem/10819
# 순열을 이용하여 Brute-Force로 푸는 문제.
# 1. DFS를 이용해 앞자리 부터 부등호 규칙을 만족하는 수를 찾아간다.
# 2. 부등호를 만족시키는 수를 찾을때 9부터 0까지 순서대로 DFS를 통해 찾은 첫 수가 최대값이 된다.
# 3. 부등호를 만족시키는 수를 찾을때 0부터 9까지 순서대로 DFS를 통해 찾은 첫 수가 최소값이 된다.

def perm(depth, reverse):
    global flag

    # depth가 마지막까지 도달하였으면
    if depth == N + 1:
        # 현재 배열로 출력
        print(str(''.join(map(str, output))))
        flag = True
        return

    for k in range(10):
        if reverse:
            i = 9 - k
        else:
            i = k

        if not visited[i] and not flag:
            if depth == 0 or check(signs[depth-1], output[depth-1], i):
                visited[i] = True
                output[depth] = i
                perm(depth + 1, reverse)
                visited[i] = False


# 부등호 조건을 만족하는지 확인하는 함수
def check(sign, val1, val2):
    if sign == '<' and val1 < val2:
        return True
    if sign == '>' and val1 > val2:
        return True

    return False


if __name__ == "__main__":
    N = int(input())
    signs = input().split()

    visited = [False] * 10
    output = [0] * (N+1)

    flag = False
    perm(0, True)

    flag = False
    perm(0, False)