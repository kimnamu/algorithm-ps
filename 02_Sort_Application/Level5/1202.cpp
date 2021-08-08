// 보석 도둑
// https://www.acmicpc.net/problem/1202
// 힌트
// 1.가방과 상자 정렬을 무게에 대해서 오름차순으로 정렬하자.
// 2. 허용 무게가 가장 작은 가방부터 가방에서 담을 수 있는 보석의 가치를 모두 담는다.
// 3. 담을 수 있는 가치 중에서 가장 비싼 것을 해당 가방에 넣는다. (이를 위해 우선순위 큐를 이용하면 편리하다.)
// 4. 2~3을 반복하며 가방에서 담을 수 있는 보석에 대한 index를 하나씩 키워가며 추가로 담을 수 있는 보석을 우선순위 큐에 넣어준다.
#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
vector<pair<int, int> > MV;
vector<int> bag;
int N, K, C;

bool cmp(pair<int, int> a, pair<int, int> b)
{
    return a.first < b.first;
}

int main()
{
    cin >> N >> K;
    int M, V, weight;
    for (int i = 0; i < N; i++)
    {
        cin >> M >> V;
        MV.push_back(make_pair(M, V));
    }
    for (int i = 0; i < K; i++)
    {
        cin >> weight;
        bag.push_back(weight);
    }
    sort(MV.begin(), MV.end(), cmp);
    sort(bag.begin(), bag.end());

    long long answer = 0;
    priority_queue<int> q;
    int index = 0;
    for (int i = 0; i < K; i++)
    {
        while (index < N && MV[index].first <= bag[i])
        {
            q.push(MV[index].second);
            index += 1;
        }
        if (q.size())
        {
            answer += q.top();
            q.pop();
        }
    }

    cout << answer << endl;
    return 0;
}
