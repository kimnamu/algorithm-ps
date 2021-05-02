# 세수정렬
# https://www.acmicpc.net/problem/2752

if __name__ == "__main__":
    n1, n2, n3 = map(int, input().split())

    if n1 > n2:
        n1, n2 = n2, n1

    if n2 > n3:
        n2, n3 = n3, n2
        if n1 > n2:
            n1, n2 = n2, n1

    print(n1, n2, n3)
