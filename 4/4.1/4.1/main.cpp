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
    
    CyclicList *warriors = createList();

    for (int i = 1; i <= numbOfWarriors; i++)
    {
        if (i == numbOfWarriors){
            add(warriors, i);
        }
        else{
            add(warriors, i);
        }
    }
    
    cout << "Survive warrior with index : ";
    findAndKill(warriors, mustDead, numbOfWarriors, deadWarriors);
    deleteList(warriors);
    return 0;
}
