#include "list.hpp"

Array *createArray(int n)
{
    Array *array = new Array;
    array->element = new ArrayElement *[n];
    
    for (int i = 0; i < n; i++)
    {
        array->element[i] = nullptr;
    }
    
    return array;
}

void add(Array *array, int index, int i, int j)
{
    ArrayElement *current = array->element[i];
    
    if (!current)
    {
        array->element[i] = new ArrayElement {i, j, nullptr};
        return;
    }
    
    while (current->next)
    {
        current = current->next;
    }
    
    current->next = new ArrayElement {i, j, nullptr};
}
