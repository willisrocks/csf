//
//  main.cpp
//

#include <iostream>
#include "SkipList.h"

int main(int argc, const char * argv[])
{
    SkipList<int> myList;
    
    myList.printList();
    
    std::cout << std::endl;
    std::cout << "List Insert Tests" << std::endl;    
    myList.insert(4);
    myList.insert(1);
    myList.insert(2);
    myList.insert(1);
    myList.printList();
    
    std::cout << std::endl;
    std::cout << "List Find Tests" << std::endl;
    myList.find(4);
    myList.find(1);
    myList.find(5);
    
    std::cout << std::endl;
    std::cout << "List Remove Tests" << std::endl;
    myList.remove(2);
    myList.remove(7);
    myList.remove(3);
    myList.printList();
    
    std::cout << std::endl;
    std::cout << "List Empty Tests" << std::endl;
    myList.makeEmpty();
    myList.printList();
    
    return 0;
}
