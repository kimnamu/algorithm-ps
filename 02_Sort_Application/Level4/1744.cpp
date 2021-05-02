// 수 묶기
// https://www.acmicpc.net/problem/1744
// 힌트
// 1. 1보다 큰 경우, 1인 경우, 0보다 작거나 같은 경우 세가지로 분류한다.
// 2. 1보다 큰 경우는 큰 순서로 정렬하여 두개의 수를 곱해주면 된다.
// 3. 1인 경우는 해당 수를 더해 주면 된다.
// 4. 0보다 작은 경우는 절대값이 큰 순서대로 정렬하여 두개의 수를 곱해주면 된다.
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
    int n, k;
    int answer = 0;
    cin >> n;
    vector<int> positive, negative;
    for (int i = 0; i < n; i++)
    {
        cin >> k;
        // 1은 그냥 더해준다.
        if (k == 1)
        {
            answer += 1;
        }
        else if (k > 0)
        {
            positive.push_back(k);
        }
        else
        {
            negative.push_back(k);
        }
    }
    // 0보다 큰 수들을 내림차순으로 정렬
    sort(positive.begin(), positive.end(), greater<int>());
    // 0이하의 수들을 올림차순으로 정렬
    sort(negative.begin(), negative.end());
    for (int i = 0; i < positive.size(); i += 2)
    {
        if (i + 1 < positive.size())
        {
            answer += positive[i] * positive[i + 1];
        }
        else
        {
            answer += positive[i];
        }
    }
    for (int i = 0; i < negative.size(); i += 2)
    {
        if (i + 1 < negative.size())
        {
            answer += negative[i] * negative[i + 1];
        }
        else
        {
            answer += negative[i];
        }
    }
    cout << answer << endl;
    return 0;
}