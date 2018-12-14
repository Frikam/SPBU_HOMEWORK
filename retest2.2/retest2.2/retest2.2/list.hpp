#pragma once

struct ListElement
{
    int value;
    ListElement *next;
};

struct List {
    ListElement *first;
};

List *createList();
void deleteList(List *list);
void add(List *list, int number);
void print(List *list);
int size(List *list);
void sort(List *list, int length);

