#pragma once

struct StackElement {
    int number;
    StackElement *next;
};

struct Stack {
    StackElement *top;
};

Stack *createList();
void stackPush(Stack *list, int c);
void print(Stack *list);
int stackPop(Stack *list);
void deleteStack(Stack *list);
