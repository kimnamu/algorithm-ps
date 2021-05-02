#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;
vector<string> word;
vector<int> alpha(26);
int result = 0;

// 각 알파벳 별로 다 합쳤을때 얼마나 기여하는지 계산
void solve() {
	for (int i = 0; i < word.size(); i++) {
		int pow = 1;
		for (int j = word[i].size() - 1; j >= 0; j--) {
			int val = word[i][j] - 'A';
			alpha[val] += pow;
			pow *= 10;
		}
	}
    // 기여도가 높은 내림차순으로 정렬하여 9부터 대입시켜준 합을 구함.
	sort(alpha.begin(), alpha.end(), greater<int>());
	int num = 9;
	for (int i = 0; i < 26; i++) {
		if (alpha[i] == 0) break;
		result += (alpha[i] * num);
		num--;
	}
}

int main() {
	int num;
	string s;
	cin >> num;
	for (int i = 0; i < num; i++) {
		cin >> s;
		word.push_back(s);
	}
	solve();
	cout << result << endl;
	return 0;
}