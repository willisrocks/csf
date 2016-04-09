/**
 * Author: Chris Fenton
 * Assignment: Lab1
 * Section: From last quarter
 * Part: 7.53
 * Description: Array items sum equals k?
 */

#include <iostream>
#include <vector>
#include <cstdlib>

using namespace std;

template <typename Comparable>
bool sumEqual (vector<Comparable> & a, int k) {
  //bool result = false;
  for (int i=1; i < a.size(); i++) {
    if (a[i-1] + a[i] == k) {
      return true;
    }
  }
  return false;
}

int main(int argc, char* argv[]) {
  vector<int> v;
  
  for (int i=1; i <= 20; i++) {
    v.push_back(rand() % 10);
  }
  if (argc < 2) {
    cerr << "Usage: " << argv[0] << " K" << endl;
    return 1;
  }
  int k = stoi(argv[1]);
  cout << "Vector:" << endl;
  for (int i=0; i < 20; i++) {
    cout << v[i] << " ";
  }
  cout << endl << "K: " << k << endl;
  if ( sumEqual(v, k) ) {
    cout << "Two numbers in v produce the sum " << k << endl;
  }
  else {
    cout << "No mumbers in v produce the sum " << k << endl;
  }

  return 0;
}
