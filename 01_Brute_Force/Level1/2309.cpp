// 일곱 난쟁이
// https://www.acmicpc.net/problem/2309
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// 두 명의 키를 제외하고 모두 더하기
int solution(vector<int> heights, int n1, int n2)
{
    int ret = 0;
    for (int i = 0; i < heights.size(); i++)
    {
        if (i == n1 || i == n2)
            continue;
        ret += heights[i];
    }
    return ret;
}

int main()
{
    vector<int> heights(9, 0);
    for (int i = 0; i < heights.size(); i++)
    {
        cin >> heights[i];
    }
    // 1. 9명 중 2명을 제외하는 모든 방법들을 탐색하며, 나머지 7명 키의 합이 100이 되는 때를 찾는다.
    int n1, n2;
    for (int i = 0; i < 9; i++)
    {
        for (int j = i + 1; j < 9; j++)
        {
            if (100 == solution(heights, i, j))
            {
                n1 = i;
                n2 = j;
            }
        }
    }
    // 3. n1 < n2이므로 n2, n1순으로 제거해 준다.
    heights.erase(heights.begin() + n2, heights.begin() + n2 + 1);
    heights.erase(heights.begin() + n1, heights.begin() + n1 + 1);

    // 4. 정렬 후 출력
    sort(heights.begin(), heights.end());
    for (int i = 0; i < heights.size(); i++)
    {
        cout << heights[i] << endl;
    }
    return 0;
}