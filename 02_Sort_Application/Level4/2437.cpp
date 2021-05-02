// 저울
// https://www.acmicpc.net/problem/2437
// 힌트
// 1. 오름차순으로 정렬
// 2. 정렬된 순서대로 추의 값을 더함
// 3. 현재까지 추의 합 + 1 이 다음의 추의 값보다 작으면
//    현재까지 추의 합 + 1 은 표현 못함.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N;
vector<int> arr(1000);

int main() {
	cin >> N;
	for (int i = 0; i < N; i++)
		cin >> arr[i];
	sort(arr.begin(), arr.begin() + N);

	int sum = 0;
	for (int i = 0; i < N; i++) {
		if (sum + 2 <= arr[i]) break;
		sum += arr[i];
	}
	cout << sum + 1 << endl;
	return 0;
}