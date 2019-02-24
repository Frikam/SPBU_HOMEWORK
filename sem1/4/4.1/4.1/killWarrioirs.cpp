#include <iostream>

#include "killWarrioirs.hpp"

using namespace std;

void findAndKill(CyclicList *list, int mustDead, int numbOfWarriors, int deadWarriors)
{
    int count = 1;
    ListElement *current = getPointerOnFirstElement(list);
    
    while (numbOfWarriors - deadWarriors > 2)
    {
        if ((count + 1) % mustDead == 0)
        {
            deleteElement(current);
            deadWarriors++;
        }
        else{
            pointerOnNextWarrior(current);
        }
        count++;
    }
    
    count = 1;
    
    while (count % mustDead != 0 )
    {
        pointerOnNextWarrior(current);
        count++;
    }
    
    makeNewFirstElement(list, current);
    printElement(current);
}
