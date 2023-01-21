// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 배열 합치기
// https://www.acmicpc.net/problem/11728
// 힌트
// 1. 배열 A, B가 이미 정렬되어 있기 때문에, 투포인터를 이용해 A와 B의 가장 작은 0번째 수부터 비교해가면서 더 작은 수를 먼저 출력하면 된다.
// 2. 먼저 출력한 배열은 포인터를 +1 증가시키고 1의 과정을 되풀이 한다.
// 3. 이때 A나 B의 포인터 중 하나가 먼저 끝에 도달한다면, 나머지 포인터로 부터의 남은 배열을 모두 출력해주면 된다.
// 주의
// cpp의 경우 cin.tie(NULL); ios_base::sync_with_stdio(false);를 작성해주지 않으면 시간 초과발생
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main()
{
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    int N, M;
    cin >> N >> M;
    vector<int> A(N);
    vector<int> B(M);
    for (int i = 0; i < N; i++)
    {
        cin >> A[i];
    }
    for (int i = 0; i < M; i++)
    {
        cin >> B[i];
    }
    int indexA = 0;
    int indexB = 0;
    while (indexA <= N && indexB <= M)
    {
        // 두 index가 모두 배열의 범위를 초과하면 작업을 중지한다.
        if (indexA == N && indexB == M)
        {
            break;
            // A배열의 index가 이미 배열 범위를 초과하였다면 B배열의 남은 값들을 출력해준다.
        }
        if (indexA == N)
        {
            cout << B[indexB++] << " ";
            // B배열의 index가 이미 배열 범위를 초과하였다면 A배열의 남은 값들을 출력해준다.
        }
        else if (indexB == M)
        {
            cout << A[indexA++] << " ";
            // A와 B를 가르키는 포인터의 값 중 작은 값을 먼저 출력해주고 포인터를 옮겨 준다.
        }
        else if (A[indexA] < B[indexB])
        {
            cout << A[indexA++] << " ";
        }
        else
        {
            cout << B[indexB++] << " ";
        }
    }
    return 0;
}