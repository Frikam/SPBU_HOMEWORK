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
void add(CyclicList *list, int value, bool isNext);
void deleteElement(ListElement *current);
void deleteList(CyclicList *list);
