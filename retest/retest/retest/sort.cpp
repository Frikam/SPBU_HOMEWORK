#include "sort.hpp"

void addInRightPlace(List *list, int number)
{
    ListElement *current = list->first;
    
    if (current->value > number)
    {
        list->first = new ListElement{number, list->first};
        return;
    }
    
    while (current->next && current->next->value < number)
    {
        current = current->next;
    }
    
    ListElement *newElement = new ListElement{number, current->next};
    current->next = newElement;
}

void sort(List *list)
{
    ListElement *previous = list->first;
    ListElement *current = list->first->next;
    int length = size(list);
    
    for (int i = 1; i < length; i++)
    {
        if (current->value < previous->value)
        {
            ListElement *newElement = current;
            previous->next = current->next;
            addInRightPlace(list, current->value);
            delete newElement;
            current = previous->next;
            
        }
        else
        {
            previous = current;
            current = current->next;
        }
    }
}
