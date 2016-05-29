//
//  Node.h
//  skiplist
//
//  Created by David Babcock on 9/8/12.
//  Copyright (c) 2012 CS350. All rights reserved.
//

#ifndef _NODE_H_
#define _NODE_H_

// Skiplist node class
template <class T>
class Node
{
public:
    // Constructor
    Node(const T & theData = T(), int h = 1)
        : data(theData), height(h)
    {
        // Allocate pointer array
        next = new Node*[h];
        
        // Initialize pointers
        for(int i=0; i<h; i++)
        {
            next[i] = NULL;
        }
    }
        
    // Destructor
    ~Node()
    {
        // Deallocate pointer array
        delete[] next;
    }
        
    // Private members
    T data;
    int height;
    Node **next;
};

#endif
