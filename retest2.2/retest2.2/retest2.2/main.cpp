#include <iostream>

#include "list.hpp"

using namespace std;

int main()
{
    List *list = createList();
    cout << "Enter number of elements : ";
    int length = 0;
    cin >> length;
    int number = 0;
    
    if (length > 0)
    {
        for (int i = 0; i < length; i++)
        {
            cout << "Enter number : ";
            cin >> number;
            add(list, number);
        }
        
        cout << "List before sorting : ";
        print(list);
        
        if (length != 1)
        {
            sort(list, length);
        }
        
        cout << "List after sorting : ";
        print(list);
    }
    else
    {
        cout << "List is empty";
    }
    
    deleteList(list);
    return 0;
}
