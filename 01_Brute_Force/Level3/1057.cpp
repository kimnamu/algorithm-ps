// 토너먼트
// https://www.acmicpc.net/problem/1057
#include <iostream>
using namespace std;

int main()
{
    int N, a, b;
    int answer = 1;
    cin >> N >> a >> b;
    // 1. a < b로 swap 해준다.
    if (a > b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
    // 2. 토너먼트에서 지정된 두 사람이 만나기 위해서는, 번호가 낮은사람이 홀수, 번호가 큰사람이 그보다 1큰 짝수 일때 대결을 하게 된다.
    while (true)
    {
        if (a % 2 == 1 && b - a == 1)
        {
            break;
        }
        a = (a + 1) / 2;
        b = (b + 1) / 2;
        answer += 1;
    }
    cout << answer << endl;
    return 0;
}