// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// K번째 수
// https://www.acmicpc.net/problem/1300
// 힌트
// 1. 임의의 숫자를 골라 K번째 숫자가 맞는지 찾아보자.
//    이때 임의의 숫자를 Bruete force로 맞으면 시간초과가 발생하기 때문에 binary search를 적용해 찾아보자.
// 2. 임의의 숫자보다 작은 수의 갯수를 찾는 방법은 i번째 행의 모든 값은 i의 배수임을 활용해서 구할 수 있는데,
//    min(mid/i, n)이 i번째 행에서 임의의 숫자보다 작은 숫자들의 개수가 된다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

typedef long long ll;
int main()
{
	int n, k;
	cin >> n >> k;

	int l = 1;
	int r = k;
	int answer;
	while (l <= r)
	{
		ll cnt = 0;
		int mid = (l + r) / 2;
		for (int i = 1; i <= n; i++)
			cnt += min(mid / i, n);
		if (cnt < k)
		{
			l = mid + 1;
		}
		else
		{
			answer = mid;
			r = mid - 1;
		}
	}
	cout << answer << endl;

	return 0;
}