#include <iostream>

#include "killWarrioirs.hpp"

using namespace std;

void findAndKill(CyclicList *list, int mustDead, int numbOfWarriors, int deadWarriors)
{
    int count = 1;
    ListElement *current = list->first;
    
    while (numbOfWarriors - deadWarriors > 2)
    {
        if ((count + 1) % mustDead == 0)
        {
            deleteElement(current);
            deadWarriors++;
        }
        else{
            current = current->next;
        }
        count++;
    }
    
    count = 1;
    while (count % mustDead != 0 )
    {
        current = current->next;
        count++;
    }
    list->first = current;
    printf("%d\n", current->value);
}
