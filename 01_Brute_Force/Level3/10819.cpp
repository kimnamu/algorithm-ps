// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 차이를 최대로
// https://www.acmicpc.net/problem/10819
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int N;
    cin >> N;
    vector<int> A(N);
    for (int i = 0; i < A.size(); i++)
    {
        cin >> A[i];
    }
    // 1. A를 오름차순으로 정렬하여 가장 작은 순열로 만듦
    sort(A.begin(), A.end());
    int answer = 0;
    // 2. A를 다음 순열로 바꿔가면서 그때의 이웃한 값들의 차이의 합이 가장 커지는 temp값을 answer에 갱신
    do
    {
        int temp = 0;
        for (int i = 0; i < A.size() - 1; i++)
        {
            temp += abs(A[i + 1] - A[i]);
        }
        answer = max(answer, temp);
    } while (next_permutation(A.begin(), A.end()));
    cout << answer << endl;
    return 0;
}