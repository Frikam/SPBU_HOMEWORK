#pragma once

struct ListElement
{
    int value;
    ListElement *next;
};

struct CyclicList {
    ListElement *first;
};

CyclicList *createList();
void add(CyclicList *list, int value);
void deleteElement(ListElement *current);
void deleteList(CyclicList *list);
void printElement(ListElement *current);
void makeNewFirstElement(CyclicList *list, ListElement *current);
ListElement *getPointerOnFirstElement(CyclicList *list);
void pointerOnNextWarrior(ListElement *&current);
