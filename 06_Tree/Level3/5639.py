# 이진 검색 트리
# https://www.acmicpc.net/problem/5639
# 힌트
# 1. pre[start]보다 작은 노드들의 구간 중 끝 지점을 찾아 해당 위치를 기준으로
#    (l, r - 1), (r, end) 구간에서 postOrder 함수를 재귀호출한다.
# 2. pre[start]보다 작은 노드가 없다면 (l, end)에 대해 postOrder함수를 재귀 호출 한다.
import sys
sys.setrecursionlimit(100000)

def post(start, end):
    root, l, r = pre[start], start + 1, -1

    for i in range(start, end + 1):
        if root < pre[i]:
            r = i
            break

    if start != end:
        if r != l:
            if r != -1:
                post(l, r - 1)
            else:
                post(l, end)

        if r != -1:
            post(r, end)
    print(root)


if __name__ == "__main__":
    pre = []
    while True:
        try:
            pre.append(int(sys.stdin.readline()))
        except Exception:
            break
    post(0, len(pre) - 1)