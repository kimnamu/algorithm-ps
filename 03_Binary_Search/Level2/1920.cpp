// 수 찾기
// https://www.acmicpc.net/problem/1920
// 힌트
// 1. m개의 숫자들을 n개의 숫자내에서 완전 탐색으로 찾게되면 복잡도가 o(nm)이 되므로 완전탐색을 하면 시간초과가 난다.
// 2. 정렬 후 binary search를 통해 정렬 하고나서는 o(log n)에 찾을 수 있다.
// 3. cpp의 경우 ios_base::sync_with_stdio(false); cin.tie(NULL); 안해주면 시간 초과.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
vector<int> a;
int k;

bool bs()
{
    // l, r, m은 index 일뿐 실제 값을 a에서 찾아 비교해야 한다.
    int l = 0;
    int r = a.size() - 1;
    if (a[l] > k || a[r] < k)
        return false;
    while (l <= r)
    {
        int m = (l + r) / 2;
        if (a[m] == k)
        {
            return true;
        }
        else if (a[m] > k)
        {
            r = m - 1;
        }
        else
        {
            l = m + 1;
        }
    }
    return false;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n;
    a = vector<int>(n);
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }
    cin >> m;
    sort(a.begin(), a.end());
    for (int i = 0; i < m; i++)
    {
        cin >> k;
        if (bs())
            cout << "1\n";
        else
            cout << "0\n";
    }
    return 0;
}