#include <iostream>

#include "list.hpp"

#include "sort.hpp"

using namespace std;

int main()
{
    List *list = createList();
    int size = 0;
    int number = 0;
    cout << "Enter size of list : ";
    cin >> size;
    
    for (int i = 0; i < size; i++)
    {
        cout << "Enter number : ";
        cin >> number;
        add(list, number);
    }
    
    sort(list);
    cout << "Sorted list : ";
    print(list);
    deleteList(list);
    return 0;
}
