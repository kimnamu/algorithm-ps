// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 세수정렬
// https://www.acmicpc.net/problem/2752
#include <iostream>
using namespace std;

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

int main()
{
    int n1, n2, n3, temp;
    cin >> n1 >> n2 >> n3;
    // temp를 활용하여 n1 < n2 < n3 순으로 swap 해준다.
    if (n1 > n2)
    {
        swap(&n1, &n2);
    }
    if (n2 > n3)
    {
        swap(&n2, &n3);
        if (n1 > n2)
        {
            swap(&n1, &n2);
        }
    }
    printf("%d %d %d\n", n1, n2, n3);
    return 0;
}