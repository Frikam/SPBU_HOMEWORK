#pragma once

struct StackElement {
    int number;
    char sign;
    StackElement *next;
};
struct Stack {
    StackElement *top;
};

void stackPushSign(Stack *list, char sign);
void saveStack(Stack *list, char *postfixForm, int &index);
int stackPopNumber(Stack *list);
int size(Stack *list);
void clearList(Stack *list);
void stackPushNumber(Stack *list, int number);
Stack *createList();
void print(Stack *list);
void deleteStack(Stack *list);
char getFirstSign(Stack *list);
