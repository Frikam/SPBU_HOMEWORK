#pragma once

int priorityOfSign(char sign);
void deleteUntilOpenedBracketOrPriorityLower(List *list, char sign1, char *postfixForm, int *index);
void deleteUntilOpenedBracket(List *list, char *postfixForm, int *index);
void calculator(List *list, int firstNumber, int secondNumber, char sign);
int isNumber(char sign);

