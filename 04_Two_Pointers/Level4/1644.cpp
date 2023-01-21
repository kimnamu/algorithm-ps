// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 소수의 연속합
// https://www.acmicpc.net/problem/1644
// 힌트
// 1. 먼저 N 제한인 4000000까지 (혹은 N까지)의 소수를 구한다. 에라토스테네스의 체 방법을 이용하면 O(NloglogN)만에 모든 소수를 구할 수 있다.
// 2. 모든 소수에 대해서 투 포인터를 이용해 구간을 이동시키면서 합을 구한다.
//   2.1 구간합이 N보다 크면 왼쪽 포인터 위치 값을 빼주면서 한칸 옮겨준다.
//   2.2 구간합이 N보다 작으면 오른쪽 포인터 위치 값을 한칸 옮겨준 후 값을 더해준다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int maxNUM = 4000000;

typedef long long ll;
vector<bool> primeCheck(maxNUM + 1, true);
vector<int> primeNumbers;

// 에라토스테네스의 체 알고리즘
void primNumbers()
{
    primeCheck[0] = false;
    primeCheck[1] = false;

    // 2부터 특정 수의 배수에 해당하는 수를 모두 지움
    for (int i = 2; i <= maxNUM; i++)
    {
        if (!primeCheck[i])
            continue; // 이미 지워진 수라면 건너뜀

        // 이미 지워진 숫자가 아니라면, 해당 숫자의 배수를 모두 true로 만듦
        for (int j = 2 * i; j <= maxNUM; j += i)
        {
            primeCheck[j] = false;
        }
    }
    for (int i = 2; i <= maxNUM; i++)
    {
        if (primeCheck[i])
            primeNumbers.push_back(i);
    }
}

int main()
{
    int N;
    cin >> N;
    primNumbers();
    int left = 0;
    int right = 0;
    ll sum = primeNumbers[right];
    int answer = 0;
    while (right <= primeNumbers.size())
    {
        if (sum == N)
        {
            answer += 1;
            sum -= primeNumbers[left];
            left += 1;
        }
        else if (sum > N)
        {
            sum -= primeNumbers[left];
            left += 1;
        }
        else
        {
            right += 1;
            sum += primeNumbers[right];
        }
    }
    cout << answer << endl;
    return 0;
}