// 회문
// https://www.acmicpc.net/problem/17609
// 힌트
// 1. 문자열의 왼쪽끝과 오른쪽 끝에서부터 하나씩 비교하면서 회문인지 확인한다.
// 2. 유사회문이 될 수 있으므로 서로 다른 문자를 비교하게 되면 왼쪽 포인터를 오른쪽으로 한칸 옮기고 마저 비교하거나,
//    오른쪽 포인터를 하나 건너띄고 비교하면 된다.
// 3. 왼쪽에서 건너띌지 오른쪽에서 건너뛸지 알수 없기 때문에 각각 수행해준다.
#include <iostream>
#include <algorithm>
#include <string>
using namespace std;

int main()
{
    int T;
    cin >> T;
    while (T--)
    {
        string s;
        cin >> s;
        int left = 0;
        int right = s.size() - 1;
        int cnt = 0;
        
        while (left < right)
        {
            if (s[left] == s[right])
            {
                left += 1;
                right -= 1;
            }
            else
            {
                // 일치 하지 않는 문자가 나왔을때 왼쪽 포인터부터 한칸 건너 뛴다.
                if (cnt == 1)
                {
                    cnt = 2;
                    break;
                }
                else
                {
                    left += 1;
                    cnt += 1;
                }
            }
        }
        if (cnt == 0)
        {
            cout << 0 << endl;
            continue;
        }
        else if (cnt == 1)
        {
            cout << 1 << endl;
            continue;
        }
        // 왼쪽 포인터부터 건너뛰었을때 일반 문자열로 나온다면,
        // 오른쪽 포인터부터 건너뛰었을때 유사회문이 될 수 있는지 추가로 비교해야한다.
        left = 0;
        right = s.size() - 1;
        cnt = 0;
        while (left < right)
        {
            if (s[left] == s[right])
            {
                left += 1;
                right -= 1;
            }
            else
            {
                if (cnt == 1)
                {
                    cnt = 2;
                    break;
                }
                else
                {
                    right -= 1;
                    cnt += 1;
                }
            }
        }
        if (cnt == 1)
            cout << 1 << endl;
        else
            cout << 2 << endl;
    }
    return 0;
}