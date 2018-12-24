#pragma once

struct ListElement {
    int number;
    ListElement *next;
};

struct List {
    ListElement *top;
};

List *createList();
void listPush(List *list, int c);
void print(List *list);
void listPop(List *list);
void deleteList(List *list);
