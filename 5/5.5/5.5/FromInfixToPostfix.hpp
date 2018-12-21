#pragma once

#include "stack.hpp"

#include "Calculator.hpp"

void deleteUntilOpenedBracketOrPriorityLower(Stack *list, char sign1, char *postfixForm, int &index);
void deleteUntilOpenedBracket(Stack *list, char *postfixForm, int &index);
void addElementInStack(Stack *stackSign, char *list, char *postfixForm, int i, int &index);
