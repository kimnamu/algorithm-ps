// 음주 코딩
// https://www.acmicpc.net/problem/5676
// 힌트
// 1. 구간연산을 위해 Segment Tree를 활용한다.
#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#define MAX_NUM 100010

using namespace std;

int N, K;
int arr[MAX_NUM];
vector<int> segTree;
vector<pair<char, pair<int, int> > > control;
vector<char> answers;

int convert(int x)
{
    if (x == 0)
        return 0;
    else if (x < 0)
        return -1;
    else if (x > 0)
        return 1;
}

int init_tree(int node, int start, int end)
{
    if (start == end)
        return segTree[node] = convert(arr[start]);

    int mid = (start + end) / 2;
    int left_result = init_tree(node * 2, start, mid);
    int right_result = init_tree(node * 2 + 1, mid + 1, end);

    return segTree[node] = convert(left_result * right_result);
}

int update(int node, int start, int end, int Idx, int Value)
{
    if (Idx < start || Idx > end)
        return segTree[node];
    if (start == end)
        return segTree[node] = convert(Value);

    int mid = (start + end) / 2;
    int left_result = update(node * 2, start, mid, Idx, Value);
    int right_result = update(node * 2 + 1, mid + 1, end, Idx, Value);

    return segTree[node] = convert(left_result * right_result);
}

int query(int node, int start, int end, int left, int right)
{
    if (right < start || left > end)
        return 1;
    if (left <= start && end <= right)
        return segTree[node];

    int mid = (start + end) / 2;
    int left_result = query(node * 2, start, mid, left, right);
    int right_result = query(node * 2 + 1, mid + 1, end, left, right);
    return convert(left_result * right_result);
}

int main(void)
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    while (cin >> N >> K)
    {

        segTree.clear();
        control.clear();
        answers.clear();
        for (int i = 0; i < N; i++)
            cin >> arr[i];
        for (int i = 0; i < K; i++)
        {
            char C;
            cin >> C;
            int a, b;
            cin >> a >> b;
            control.push_back(make_pair(C, make_pair(a, b)));
        }
        int tree_height = (int)ceil(log2(N));
        int tree_size = (1 << (tree_height + 1));
        segTree.resize(tree_size);
        init_tree(1, 0, N - 1);

        for (int i = 0; i < control.size(); i++)
        {
            char C = control[i].first;
            if (C == 'C')
            {
                int Index = control[i].second.first - 1;
                int Value = control[i].second.second;
                update(1, 0, N - 1, Index, Value);
            }
            else
            {
                int Index = control[i].second.first - 1;
                int Index2 = control[i].second.second - 1;
                int Result = query(1, 0, N - 1, Index, Index2);

                if (Result == 0)
                    answers.push_back('0');
                else if (Result < 0)
                    answers.push_back('-');
                else
                    answers.push_back('+');
            }
        }
        for (int i = 0; i < answers.size(); i++)
            cout << answers[i];
        cout << "\n";
    }
    return 0;
}
