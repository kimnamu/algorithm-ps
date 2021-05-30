// 수들의 합 5
// https://www.acmicpc.net/problem/2018
// 힌트
// 1. 투 포인터 방식을 이용해 문제를 풀 수 있다.
// 2. 연속된 수들의 합을 표현하기 위해 연속된 두 수의 시작수와 끝 수를 투 포인터로 잡는다.
//    이때 두 수와 합을 1로 초기화 해주고 시작한다.
//    구간 사이의 합이 N보다 작으면 오른쪽 포인터를 키우면서 합에 더해주고,
//    구간 사이의 합이 N보다 크면 왼쪽 포인터를 키우면서 합에서 빼주면서,
//    합과 N이 같아지는 때를 카운트 해주면 된다.
#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int N;
    cin >> N;
    int left = 1, right = 1;
    int sum = 1;
    int answer = 0;
    while (left <= right && right <= N)
    {
        if (sum == N)
        {
            answer += 1;
            sum -= left;
            left += 1;
        }
        else if (sum > N)
        {
            sum -= left;
            left += 1;
        }
        else
        {
            right += 1;
            sum += right;
        }
    }
    cout << answer << endl;
    return 0;
}