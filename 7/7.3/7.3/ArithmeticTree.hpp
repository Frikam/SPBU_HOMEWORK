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
int calculate(ArithmeticTree *tree);
int calculateExpression(ArithmeticTreeNode *current);
void deleteTree(ArithmeticTree *tree);
int calculateAnswer(ArithmeticTreeNode *current, int leftChild, int rightChild);
int calculateChild(ArithmeticTreeNode *current, int answer);
