#include <iostream>

#include "AvmTtree.hpp"

using namespace std;

int main()
{
    cout << "1 - exit" << endl;
    cout << "2 - add element in tree" << endl;
    cout << "3 - remove element in tree" << endl;
    cout << "4 - checks for an element in the tree" << endl;
    cout << "5 - print tree in ascending order" << endl;
    cout << "6 - print tree in descending order" << endl;
    cout << "7 - print tree in format (a b c)" << endl;
    
    Tree *tree = createTree();
    int whatFunction = 0;
    int value = 0;
    
    while (whatFunction != 1)
    {
        cout << "Enter number of function : ";
        cin >> whatFunction;
        
        switch (whatFunction)
        {
            case (2):
                cout << "Enter value : ";
                cin >> value;
                addElement(tree, value);
                break;
            case (3):
                cout << "Enter value : ";
                cin >> value;
                deleteElement(tree, value);
                break;
            case (4):
                cout << "Enter value : ";
                cin >> value;
                exist(tree, value);
                break;
            case (5):
                printTreeAscending(tree);
                break;
            case (6):
                printTreeDescending(tree);
                break;
            case (7):
                printTree(tree);
                break;
        }
    }
    
    cout << "You have completed the program";
    deleteTree(tree);
    return 0;
}
