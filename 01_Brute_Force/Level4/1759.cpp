// Copyright@2023 Jihoon Lucas Kim <jihoon.lucas.kim@gmail.com>
// 암호 만들기
// https://www.acmicpc.net/problem/1759
// 힌트
// 1. 문자를 순서대로 정렬한 후, dfs를 활용하여 완전탐색을 하며 만들어지는 문자열들 중
//    모음수, 자음수 조건을 만족하는 문자열을 저장한 후 순서대로 출력한다.
#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
#include <string>
using namespace std;

vector<char> alphas;
stack<char> alphas_stack;
vector<string> answers;

int vowel = 0;
int consonant = 0;

// 모음인지 판단
bool isVowel(char a)
{
    if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
        return true;
    else
        return false;
}

void dfs(int index, int L)
{
    // index가 문자열 수를 초과하면 return
    if (index == alphas.size())
        return;
    // 문자열 수가 L만큼 모두 채워지면 answer에 등록시킴
    if (L == 0)
    {
        // 단 자음, 모음 수 조건을 만족하지 않으면 return
        if (consonant < 2 || vowel < 1)
            return;
        stack<char> temp = alphas_stack;
        string s = "";
        while (temp.size())
        {
            s.push_back(temp.top());
            temp.pop();
        }
        answers.push_back(s);
        return;
    }

    // 다음 index값을 포함시키면서 탐색하는 경우
    alphas_stack.push(alphas[index + 1]);
    if (isVowel(alphas[index + 1]))
        vowel += 1;
    else
        consonant += 1;
    dfs(index + 1, L - 1);
    alphas_stack.pop();
    if (isVowel(alphas[index + 1]))
        vowel -= 1;
    else
        consonant -= 1;

    // 다음 index값을 포함시키지 않고 탐색하는 경우
    dfs(index + 1, L);
}

int main()
{
    int L, C;
    cin >> L >> C;
    alphas = vector<char>(C);
    for (int i = 0; i < C; i++)
    {
        cin >> alphas[i];
    }
    // 1. 문자열을 Stack에 저장할 것이기 때문에,
    //    구현상의 편의를 위해 내림차순으로 정렬해준다.
    //    그리고 stack이 다 차면 top에서부터 하나씩 빼주면서 string을 만들면 오름차순의 string이 만들어 진다.
    sort(alphas.begin(), alphas.end(), greater<int>());
    for (int i = 0; i < C; i++)
    {
        // 2. i번째 알파벳(alphas[i])을 포함시키는 경우,
        // 2.1 alphas_stack에 정답이 될 문자열 끝 문자를 넣어준다.
        alphas_stack.push(alphas[i]);
        // 2.2 모음 여부를 먼저 판단하여 자음 혹은 모음에 counting해준다.
        if (isVowel(alphas[i]))
            vowel += 1;
        else
            consonant += 1;
        // 2.3 dfs로 다음 위치의 문자 탐색
        dfs(i, L - 1);
        // 2.4 모음 여부를 먼저 판단하여 자음 혹은 모음에서 빼준다.
        if (isVowel(alphas[i]))
            vowel -= 1;
        else
            consonant -= 1;
        // 2.5 alphas_stack에 넣어둔 문자를 빼준다.
        alphas_stack.pop();
    }
    sort(answers.begin(), answers.end());
    for (int i = 0; i < answers.size(); i++)
    {
        cout << answers[i] << "\n";
    }
    return 0;
}