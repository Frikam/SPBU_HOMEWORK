#pragma once

#include "stack.hpp"

void deleteUntilOpenedBracketOrPriorityLower(List *list, char sign1, char *postfixForm, int *index);
void deleteUntilOpenedBracket(List *list, char *postfixForm, int *index);
int priorityOfSign(char sign);
