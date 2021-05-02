// 부분수열의 합
// https://www.acmicpc.net/problem/14225
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<bool> visited;
vector<int> nums;
int n;
void dfs(int num, int sum)
{
    if (num == n)
    {
        visited[sum] = true;
        return;
    }
    // 해당 number를 사용하는 경우
    dfs(num + 1, sum + nums[num]);
    // 해당 number를 사용하지 않는 경우
    dfs(num + 1, sum);
}
int main()
{
    cin >> n;
    visited = vector<bool>(n * 100000, false);
    nums = vector<int>(n);
    for (int i = 0; i < n; ++i)
    {
        cin >> nums[i];
    }
    
    // dfs로 완전 탐색
    dfs(0, 0);

    // 1부터 방문하여 부분수열의 합으로 만들수 없는 최초의 수를 출력
    for (int i = 1; i < visited.size(); i++)
    {
        if (!visited[i])
        {
            cout << i << endl;
            break;
        }
    }
    return 0;
}