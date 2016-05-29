//
//  SkipList.cpp
//

#include "SkipList.h"
#include "Flags.h"

/* **************************************************************** */

#if CONSTRUCTOR || ALL
template <class T>
SkipList<T>::SkipList() {
  int h = SkipList<T>::maxHeight;
  this->head = new Node<T>(h);
  this->head->height = 1;
}
#endif

/* **************************************************************** */

#if DESTRUCTOR || ALL
template <class T>
SkipList<T>::~SkipList() {
  Node<T> *node = this->head;
  while (node != NULL) {
    Node<T> *last = node;
    node = node->next[0];
    delete last;
  }
}
#endif

/* **************************************************************** */

#if FIND || ALL
// TODO: find() method
#endif

/* **************************************************************** */

#if INSERT || ALL
// Compiles but gets stuck in an infinite loop
template <class T>
void SkipList<T>::insert(const T & newValue) {
	int level = randomLevel();
	Node<T> *node = this->head;
	Node<T> *insertNode = new Node<T>(newValue, level);

	while ((level - 1) >= 0) {
		while (node->next[level] != NULL && node->next[level]->data < newValue) {
			node = node->next[level];
		}
		insertNode->next[level] = node->next[level];
		node->next[level] = insertNode;
	}
}
#endif

/* **************************************************************** */

#if REMOVE || ALL
// TODO: remove() method
#endif

/* **************************************************************** */

#if ISEMPTY || ALL
// TODO: isEmpty() method
#endif

/* **************************************************************** */

#if MAKEEMPTY || ALL
// TODO: makeEmpty() method
#endif

/* **************************************************************** */

#if RANDOMLEVEL || ALL
// TODO: randomLevel() method
#endif

/* **************************************************************** */



/* **************************************************************** */
// Do NOT modify anything below this line
/* **************************************************************** */

#ifndef BUILD_LIB
// random number generator
template <class T>
double SkipList<T>::getRandomNumber()
{
    static int i = 0;
    static double a[10] = {0.32945,0.85923,0.12982,0.16250,0.56537,0.64072,0.27597,0.83957,0.75531,0.22502};
    
    return a[(i++)%10];
}


// printList() method
template <class T>
void SkipList<T>::printList()
{
    Node<T> *n = head;
    
    if (isEmpty())
    {
        std::cout << "Empty List" << std::endl;
    } else {
        while(n->next[0] != NULL)
        {
            n = n->next[0];
            // Print node data
            std::cout << "Node " << n->data << " height " << n->height << ": ";
            
            // Print levels
            for (int i=(n->height - 1); i >= 0; i--) {
                std::cout << "Level " << i << " -> ";
                if (n->next[i] != NULL) {
                    std::cout << n->next[i]->data;
                } else {
                    std::cout << "NULL";
                }
                std::cout << ",";
            }
            std::cout << std::endl;
        }
        std::cout << std::endl;
    }
}
#endif

template class SkipList<int>;


