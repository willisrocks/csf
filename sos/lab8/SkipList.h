#ifndef _SKIPLIST_H_
#define _SKIPLIST_H_

#include <iostream>
#include "Node.h"

// Skiplist class
template <class T>
class SkipList
{
public:
    SkipList();
    ~SkipList();
    
    // Public interface methods
    bool find(const T & x) const;
    void insert(const T & x);
    void remove(const T & x);
    bool isEmpty() const;
    void makeEmpty();
    void printList();
    
    // (Private) Head array
    Node<T> *head;
    static const int maxHeight = 5;
    
    // (Private) utility methods
    int randomLevel();
    double getRandomNumber();
};

#endif
