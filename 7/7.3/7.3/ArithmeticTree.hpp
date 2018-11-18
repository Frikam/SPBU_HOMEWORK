#pragma once

struct ArithmeticTreeNode
{
    char sign;
    int value;
    ArithmeticTreeNode *leftChild;
    ArithmeticTreeNode *rightChild;
};

struct ArithmeticTree
{
    ArithmeticTreeNode *root;
};

ArithmeticTree *createTree();
void addNumber(ArithmeticTree *tree, int number);
void addSign(ArithmeticTree *tree, char character);
int calculator(ArithmeticTree *tree);
int calculateExpression(ArithmeticTreeNode *current);
void deleteTree(ArithmeticTree *tree);
