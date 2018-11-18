#include "ArithmeticTree.hpp"

ArithmeticTree *createTree()
{
    return new ArithmeticTree {nullptr};
}

void addNumber(ArithmeticTree *tree, int number)
{
    ArithmeticTreeNode *current = tree->root;
    ArithmeticTreeNode *previous = tree->root;

    while(current->leftChild)
    {
        previous = current;
        current = current->leftChild;
    }
    
    if (!current->rightChild && current->value == 0)
    {
        current->rightChild = new ArithmeticTreeNode {' ', number, nullptr, nullptr};
    }
        
    else if (!current->leftChild && current->value == 0)
    {
        current->leftChild = new ArithmeticTreeNode {' ', number, nullptr, nullptr};
    }
    
    else
    {
        tree->root->rightChild = new ArithmeticTreeNode {' ', number, nullptr, nullptr};
    }
}

void addSign(ArithmeticTree *tree, char character)
{
    ArithmeticTreeNode *current = tree->root;
    ArithmeticTreeNode *previous = tree->root;
    
    if (!current)
    {
        tree->root = new ArithmeticTreeNode {character, 0, nullptr, nullptr};
    }
    
    else
    {
        while(current)
        {
            previous = current;
            current = current->leftChild;
        }
        
        current = new ArithmeticTreeNode {character, 0, nullptr, nullptr};
        previous->leftChild = current;
    }

}

int calculateExpression(ArithmeticTreeNode *current, int number)
{
    switch (current->sign)
    {
        case '*':
            return number * current->rightChild->value;
        case '+':
            return number + current->rightChild->value;
        case '-':
            return current->rightChild->value - number;
        case '/':
            return current->rightChild->value / number;
    }
    return 0;
}

int calculator(ArithmeticTreeNode *current, int answer)
{
    if (current->leftChild->leftChild)
    {
        answer = answer + calculateExpression(current ,calculator(current->leftChild, answer));
    }
    
    else
    {
        return calculateExpression(current, current->leftChild->value);
    }
    
    return answer;
}

int calculator(ArithmeticTree *tree)
{
    int answer = 0;
    return calculator(tree->root, answer);
}

void deleteTree(ArithmeticTreeNode *current)
{
    if (current->leftChild)
    {
        deleteTree(current->leftChild);
    }
    
    if (current->rightChild)
    {
        deleteTree(current->rightChild);
    }
    
    delete current;
}

void deleteTree(ArithmeticTree *tree)
{
    ArithmeticTreeNode *current = tree->root;
    deleteTree(current);
}
