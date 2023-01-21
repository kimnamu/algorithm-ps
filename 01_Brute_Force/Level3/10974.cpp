// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 모든 순열
// https://www.acmicpc.net/problem/10974
// 힌트
// 1. cpp에서 endl을 사용할경우 내부 버퍼를 비워주는 flush가 매번 진행되어 느리다(시간초과)
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void Permutation(vector<int> Array, int Start, int End)
{
    if (Start == End)
    {
        for (const auto it : Array)
        {
            cout << it << " ";
        }
        cout << "\n";
    }
    else
    {
        for (int i = Start; i <= End; ++i)
        {
            swap(Array[Start], Array[i]);
            Permutation(Array, Start + 1, End);
        }
    }
}

int main()
{
    int N;
    cin >> N;
    vector<int> v(N);
    for (int i = 0; i < N; i++)
    {
        v[i] = i + 1;
    }
    // 1. STD 활용할 경우
    do
    {
        for (int i = 0; i < v.size(); i++)
        {
            cout << v[i] << " ";
        }
        cout << "\n";
    } while (next_permutation(v.begin(), v.end()));

    // 2. 직접 구현할 경우 (cpp외 다른 언어)
    // sort(v.begin(), v.end());
    // Permutation(v, 0, v.size() - 1);
    return 0;
}