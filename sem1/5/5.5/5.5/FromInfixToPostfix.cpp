#include "FromInfixToPostfix.hpp"

void deleteUntilOpenedBracketOrPriorityLower(Stack *list, char sign1, char *postfixForm, int &index)
{
    StackElement *current = list->top;
    
    while (current && current->sign != '(' && priorityOfSign(sign1) <= priorityOfSign(current->sign))
    {
        postfixForm[index] = current->sign;
        index++;
        StackElement *nextElement = current->next;
        list->top = current->next;
        delete current;
        current = nextElement;
    }
}

void deleteUntilOpenedBracket(Stack *list, char *postfixForm, int &index)
{
    StackElement *current = list->top;
    
    while ( current->sign != '(')
    {
        postfixForm[index] = current->sign;
        index++;
        StackElement *nextElement = current->next;
        list->top = current->next;
        delete current;
        current = nextElement;
    }
    
    StackElement *nextElement = current->next;
    list->top = nextElement;
    delete current;
}

void addElementInStack(Stack *stackSign, char *line, char *postfixForm, int i, int &index)
{
    if (line[i] != ' ')
    {
        if (line[i] == '('){
            stackPushSign(stackSign, line[i]);
        }
        else if (line[i] == ')'){
            deleteUntilOpenedBracket(stackSign, postfixForm, index);
        }
        else if (priorityOfSign(line[i]) == 0){
            postfixForm[index] = line[i];
            index++;
        }
        else
        {
            if (size(stackSign) == 0 || getFirstSign(stackSign) == '('){
                stackPushSign(stackSign, line[i]);
            }
            else{
                if (priorityOfSign(line[i]) > priorityOfSign(getFirstSign(stackSign))){
                    stackPushSign(stackSign, line[i]);
                }
                else{
                    deleteUntilOpenedBracketOrPriorityLower(stackSign, line[i], postfixForm, index);
                    stackPushSign(stackSign, line[i]);
                }
            }
        }
    }
}
