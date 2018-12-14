#include <iostream>

#include "list.h"

using namespace std;

int main()
{
    List *list = createList();
    int number = 0;
    cout << "Enter number : ";
    cin >> number;
    
    while (number != 0)
    {
        add(list, number);
        cout << "Enter number : ";
        cin >> number;
    }
    
    print(list);
    deleteList(list);
    return 0;
}
