# 두 배열의 합
# https://www.acmicpc.net/problem/2143
# 힌트
# 1. a배열의 누적합과 b배열의 누적합을 각각 이용해 만들어질수 있는 부분 배열합을 새로운 배열에 만들자.
#    이때 각 부분 배열합을 만드는데 필요한 복잡도는 O(n^2), O(m^2)이다.
# 2. 새로운 부분 배열합 a의 i번째 원소를 기준으로 t-a[i] 값이 부분배열합 b에 몇개 존재하는지 찾으면 된다.
# 3. Brute force로 찾게되면 O(n^2 * m^2)이므로 제한된 시간내에 탐색할 수 없기 때문에 binary search를 이용한다.
#    값이 있는지 없는지 뿐만아니라 몇개 존재하는지 확인하기 위해 t-a[i]값이 시작하는지점과 끝나는 지점을 각각 찾아주어야 한다.
import sys


def get_partials(lt):
    partials = []
    for i in range(len(lt)):
        for j in range(i, len(lt)):
            partials.append(sum(lt[i:j+1]))

    return partials


def bs(k):
    left, mid, right = 0, -1, len(partialsB)-1
    start, end = 0, 0

    while left < right:
        mid = (left + right) // 2
        if partialsB[mid] >= k:
            right = mid
        else:
            left = mid + 1

    if partialsB[left] != k:
        return 0
    start = left

    left, right = 0, len(partialsB) - 1

    while left < right:
        mid = (left + right + 1) // 2
        if partialsB[mid] > k:
            right = mid - 1
        else:
            left = mid

    end = left
    return end - start + 1


if __name__ == "__main__":
    t = int(input())
    n = int(input())
    listA = list(map(int, sys.stdin.readline().split()))

    m = int(input())
    listB = list(map(int, sys.stdin.readline().split()))

    partialsA = get_partials(listA)
    partialsB = get_partials(listB)

    partialsA.sort()
    partialsB.sort()

    answer = 0

    for i in range(len(partialsA)):
        answer += bs(t - partialsA[i])

    print(answer)
