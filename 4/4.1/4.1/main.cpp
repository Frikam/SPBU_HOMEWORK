#include <iostream>

#include "CyclicList.hpp"

#include "killWarrioirs.hpp"

using namespace std;

int main()
{
    cout << "Enter numbers of Warriors : ";
    int numbOfWarriors = 0;
    cin >> numbOfWarriors;
    cout << "Kill every : ";
    int mustDead = 0;
    cin >> mustDead;
    int deadWarriors = 0;
    
    CyclicList *Warriors = createList();

    for (int i = 1; i <= numbOfWarriors; i++)
    {
        if (i == numbOfWarriors){
            add(Warriors, i, true);
        }
        else{
            add(Warriors, i, false);
        }
    }
    
    cout << "Survive warrior with index : ";
    findAndKill(Warriors, mustDead, numbOfWarriors, deadWarriors);
    deleteList(Warriors);
    return 0;
}
