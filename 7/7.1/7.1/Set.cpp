#include "Set.hpp"

Set *createSet()
{
    return new Set {createTree()};
}

void add(Set *set, int number)
{
    add(set->tree, number);
}

void deleteSet(Set *set)
{
    deleteTree(set->tree);
}

void exist(Set *set, int number)
{
    exist(set->tree, number);
}

void printSet(Set *set)
{
    printTree(set->tree);
}

void printSetDescending(Set *set)
{
    printTreeDescending(set->tree);
}

void printSetAscending(Set *set)
{
    printTreeAscending(set->tree);
}

void deleteElement(Set *set, int number)
{
    deleteElement(set->tree, number);
}
