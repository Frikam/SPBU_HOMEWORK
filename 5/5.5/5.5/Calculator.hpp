#pragma once

void calculate(Stack *list, int firstNumber, int secondNumber, char sign);
int priorityOfSign(char sign);
void calculateAnswer(char *postfixForm);
void infixToPostfix(char *line, char *postfixForm);
