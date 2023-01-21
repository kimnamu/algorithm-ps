// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 이진 검색 트리
// https://www.acmicpc.net/problem/5639
// 힌트
// 1. pre[start]보다 작은 노드들의 구간 중 끝 지점을 찾아 해당 위치를 기준으로
//    (l, r - 1), (r, end) 구간에서 postOrder 함수를 재귀호출한다.
// 2. pre[start]보다 작은 노드가 없다면 (l, end)에 대해 postOrder함수를 재귀 호출 한다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, x;
vector<int> pre(100000);

void post(int start, int end)
{
    int root = pre[start], l = start + 1, r = -1;
    //right 시작점 찾기
    for (int i = start; i <= end; i++)
    {
        if (root < pre[i])
        {
            r = i;
            break;
        }
    }
    //leaf가 아니라면
    if (start != end)
    {
        //left가 있다면
        if (r != l)
        {
            if (r != -1)
                post(l, r - 1);
            else
                post(l, end);
        }
        //right가 있다면
        if (r != -1)
            post(r, end);
    }
    cout << root << '\n';
}

int main()
{
    while (!(cin >> x).eof())
        pre[n++] = x;
    post(0, n - 1);
}