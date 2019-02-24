#include <iostream>

#include "Set.hpp"

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
    
    Set *set = createSet();
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
                addElement(set, value);
                break;
            case (3):
                cout << "Enter value : ";
                cin >> value;
                deleteElement(set, value);
                break;
            case (4):
                cout << "Enter value : ";
                cin >> value;
                exist(set, value);
                break;
            case (5):
                printSetAscending(set);
                break;
            case (6):
                printSetDescending(set);
                break;
            case (7):
                printSet(set);
                break;
        }
    }
    
    cout << "You have completed the program";
    deleteSet(set);
    return 0;
}
