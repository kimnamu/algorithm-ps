# 박성원
# https://www.acmicpc.net/problem/1086
# 힌트 (참조 : https://suuntree.tistory.com/124)
# 1. bit DP를 이용하여 각 bit set에 대해 K에 의한 나머지를 저장해주도록 한다.이때, dp[0][0] = 1으로 예외처리하도록 하자.
# 2. 그러면 분자는 모든 수가 포함된 bit set의 나머지가 0인 모든 수의 합 dp[(1<<n)-1][0]이다.
# 3. 분모는 전체 순열의 수인 n!이다.
# 4. 각 수의 길이가 최대 50 char이므로, K로 나눈 나머지로 저장해야 한다.
# 5. 현재 집합이 i이고 나머지가 j일 때, i에 속하지 않은 r번 수를 뒤에 이어붙였을 때 나머지를 next라고 하면
#    d[i | (1<<r)][next] += dp[i][j] 이다.
#    next = (새로만들어진 수) % k
#         = (원래 수 * pow( 10, len(r번째 수) ) + r번째 수) % k
#         = [ (원래 수 * pow( 10, len(r번째 수) ) ) % k  + r번째 수 % k ] % k
#         = [ (원래 수 % k  * pow( 10, len(r번째 수) ) % k ) %k + r번째 수 % k ] % k
#         = [ (j * pow( 10, len(r번째 수) ) % k ) % k +    r번째 수 % k ] % k
#    이때 a(r)은 r번째 수 이고, r번째 수의 길이는 len(r) 이다. 10의 t승의 모듈러 k 값 = mod10(t)로 전처리를 해둔다면,
#    next = [ (j*mod10(len(r))) % k + a(r)%k ] % k
# 6. 새롭게 만들어진 수의 모듈러 k값은, 원래 수의 모듈러 k값인 j와 새롭게 추가되는 수의 정보만 있으면 만들 수 있다.
# 7. 분수 값 출력해줄때 최대공약수(GCD)를 구해서 분자, 분모를 나누어 준다.
# python에서는 pypy3로 컴파일해야 타임아웃 발생 안함.
import sys


def gcd(x, y):
    if y == 0:
        return x
    return gcd(y, x % y)


if __name__ == "__main__":
    N = int(sys.stdin.readline())

    mod = [0] * N
    length = [0] * N
    nums = []

    for i in range(N):
        nums.append(sys.stdin.readline().strip())
        length[i] = len(nums[-1])
    K = int(sys.stdin.readline())

    for i in range(N):
        for j in range(length[i]):
            mod[i] = mod[i] * 10 + int(nums[i][j])
            mod[i] %= K

    mod10 = [0] * 51
    mod10[0] = 1

    for i in range(1, 51):
        mod10[i] = mod10[i - 1] * 10
        mod10[i] %= K
    dp = [[0] * 101 for _ in range(1<<15)]
    dp[0][0] = 1

    for i in range(1 << N):
        for j in range(K):
            for r in range(N):
                if (i & (1 << r)) == 0:
                    next = j * mod10[length[r]]
                    next %= K
                    next += mod[r]
                    next %= K
                    dp[i | (1 << r)][next] += dp[i][j]

    p = dp[(1 << N) - 1][0]
    q = 1
    for i in range(2, N + 1):
        q *= i

    g = gcd(p, q)
    p = p // g
    q = q // g
    print(f'{p}/{q}')


