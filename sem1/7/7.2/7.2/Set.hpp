#pragma once

#include "AvlTree.hpp"

struct Set
{
    Tree *tree;
};

Set *createSet();
void addElement(Set *set, int number);
void exist(Set *set, int number);
void deleteElement(Set *set, int number);
void printSet(Set *set);
void printSetAscending(Set *set);
void printSetDescending(Set *set);
void deleteSet(Set *set);
