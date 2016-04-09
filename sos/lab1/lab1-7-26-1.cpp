/**
 * Author: Chris Fenton
 * Assignment: Lab1
 * Section: Modifications to quicksort
 * Part: 7.26 step 1
 * Description: 1st recursive call on small partition
 */

#include <iostream>
#include <vector>

using namespace std;

/**
 * Simple insertion sort.
 */
template <typename Comparable>
void insertionSort( vector<Comparable> & a, int left, int right )
{
  int j;

  for( int p = left; p <= right;p++ )
  {
    Comparable tmp = a[ p ];
    for( j = p; j > 0 && tmp < a[ j - 1 ]; j-- )
      a[ j ] = a[ j - 1 ];
    a[ j ] = tmp;
  }
}

/**
 * Return median of left, center, and right.
 * Order these and hide the pivot.
 */
template <typename Comparable>
const Comparable & median3( vector<Comparable> & a, int left, int right )
{
  int center = ( left + right ) / 2;
  if( a[ center ] < a[ left ] )
    swap( a[ left ], a[ center ] );
  if( a[ right ] < a[ left ] )
    swap( a[ left ], a[ right ] );
  if( a[ right ] < a[ center ] )
    swap( a[ center ], a[ right ] );

  // Place pivot at position right - 1
  swap( a[ center ], a[ right - 1 ] );
  return a[ right - 1 ];
}

/**
 * Internal quicksort method that makes recursive calls.
 * Uses median-of-three partitioning and a cutoff of 10.
 * a is an array of Comparable items.
 * left is the left-most index of the subarray.
 * right is the right-most index of the subarray.
 */
template <typename Comparable>
void quicksort( vector<Comparable> & a, int left, int right )
{
  if( left + 10 > right )
  {
    insertionSort( a, left, right );
  }
  else
  {
    Comparable pivot = median3( a, left, right );

    // Begin partitioning
    int i = left, j = right - 1;
    for( ; ; )
    {
      while( a[ ++i ] < pivot ) { }
      while( pivot < a[ --j ] ) { }
      if( i < j )
        swap( a[ i ], a[ j ] );
      else
        break;
    }

    swap( a[ i ], a[ right - 1 ] );  // Restore pivot

    // Recurse on smaller parition first
    if ( ((j-1)-left) < (right-(j+1)) )
    {
      quicksort( a, left, j - 1 );
      quicksort( a, j + 1, right );
    }
    else
    {
      quicksort( a, j + 1, right );
      quicksort( a, left, j - 1 );
    }
  }
}

/**
 * Quicksort algorithm (driver).
 */
template <typename Comparable>
void quicksort( vector<Comparable> & a )
{
  quicksort( a, 0, a.size( ) - 1 );
}

/**
 * Main method
 */
int main() {
  vector<int> v;

  for(int i = 19; i >= 0; i--) {
    v.push_back(i);
  }

  cout << "Original vector:" << endl;

  for(int i = 0; i < 20; i++){
    //cout << "value of v[" << i << "] = " << v[i] << " ";
    cout << v[i] << " ";
  }

  quicksort(v);

  cout << endl << "Sorted vector:" << endl;

  for(int i = 0; i < 20; i++){
    //cout << "value of v[" << i << "] = " << v[i] << " ";
    cout << v[i] << " ";
  }

  cout << endl;

  return 0;
}
