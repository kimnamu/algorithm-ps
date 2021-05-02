// 부분수열의 합
// https://www.acmicpc.net/problem/1182
// 힌트
// 1. 부분수열은 꼭 연속한수의 집합이 아니여도 된다.
// 2. 모든 부분 수열을 탐색해야 한다.
#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> nums;
vector<bool> filter;

int solve(int index, int N, int S)
{
    int answer = 0;
    // 2. Filter를 만들어준다.
    // 만약 N==4라면, Filter는 다음과 같은 순서로 만들어 준다.
    // {0, 0, 0, 1}
    // {0, 0, 1, 1}
    // {0, 1, 1, 1}
    // {1, 1, 1, 1}
    filter[N-index-1] = true;

    // 3. filter 배열을 다음 순열로 바꿔가면서 filter의 값들위치를 바꿔주고,
    // 4. 해당 바뀐 위치의 값들만 더해준 sum이 S와 일치하면 정답으로 counting한다.
    do
    {
        int sum = 0;
        for (int i = 0; i < N; i++)
        {
            if (filter[i])
                sum += nums[i];
        }
        if (sum == S){
            answer++;
        }
    } while (next_permutation(filter.begin(), filter.end()));
    return answer;
}

int main()
{
    int N, S, answer = 0;
    cin >> N >> S;
    nums = vector<int>(N);
    filter = vector<bool>(N, false);
    // 1. 숫자를 입력 받는다.
    for (int i = 0; i < N; i++)
    {
        cin >> nums[i];
    }
    for (int i = 0; i < N; i++)
    {
        answer += solve(i, N, S);
    }
    cout << answer << '\n';
}
