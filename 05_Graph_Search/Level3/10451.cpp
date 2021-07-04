// 순열 사이클
// https://www.acmicpc.net/problem/10451
// 힌트
// 1. 방향서이 있기 때문에 연결된 graph의 table을 만들게 된다면, 행과 열의 역할을 구분지어야한다.
// 2. 행은 from, 열은 to 관계일때, DFS를 통해 한쪽 방향으로 검출하도록 하자.
//    이때, 한번 방문하게된 노드는 따로 표시를 해두고, 새롭게 시작되는 노드의 갯수를 구하기가 시작되면 사이클의 갯수를 구하기 쉬울 것이다.
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int T, N;
vector<vector<bool> > table;
vector<bool> check;

void DFS(int k)
{
    for (int i = 1; i < N + 1; i++)
    {
        if (table[k][i] && check[i])
        {
            check[i] = false;
            DFS(i);
        }
    }
}

int main()
{
    cin >> T;
    while (T--)
    {
        cin >> N;
        table = vector<vector<bool> >(N + 1, vector<bool>(N + 1, false));
        check = vector<bool>(N + 1, true);
        for (int i = 1; i <= N; i++)
        {
            int temp;
            cin >> temp;
            table[i][temp] = true;
        }
        int answer = 0;
        for (int i = 1; i < N + 1; i++)
        {
            if (check[i])
            {
                check[i] = false;
                answer += 1;
                DFS(i);
            }
        }
        cout << answer << endl;
    }
    return 0;
}