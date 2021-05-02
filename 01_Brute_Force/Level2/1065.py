# 한수
# https://www.acmicpc.net/problem/1065
# # 힌트
# 1. 1~99는 모두 한수


# 숫자의 자릿수를 구하는 function,
def getCipher(n):
    ret = 0

    while n != 0:
        ret += 1
        n = n // 10

    return ret


# 1. 한수인지 체크하는 function
def func(n: int) -> bool:
    # 2. getCipher는 n의 자릿수를 반환
    k = getCipher(n)
    # 3. 1~2자릿수는 모두 한수
    if k <= 2:
        return True
    # 4. 1의 자릿수(small)과 10의 자릿수(big)을 통해 등차(diff)를 구함
    small = n % 10
    n = n // 10
    big = n % 10
    diff = big - small
    # 5. 나머지 수들이 같은 등차(diff)를 갖는지 체크
    for _ in range(k-2):
        small = big
        big = (n // 10) % 10
        if diff != big - small:
            return False
        n = n // 10
    return True


if __name__ == "__main__":
    N = int(input())
    count = 0
    for i in range(1, N + 1):
        if func(i):
            count += 1

    print(count)