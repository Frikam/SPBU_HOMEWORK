#pragma once

#include "List.hpp"

struct TreeNode
{
    int value;
    char sign;
    TreeNode *leftChild;
    TreeNode *rightChild;
};

struct Tree
{
    TreeNode *root;
};

Tree *createTree();
void add(Tree *tree, int number, List *list);
void exist(Tree *tree, int number);
void deleteElement(Tree *tree, int number);
void printTree(Tree *tree);
void printTreeAscending(Tree *tree);
void printTreeDescending(Tree *tree);
void deleteTree(Tree *tree);
void addSign(Tree *tree, List *list, char sign);
void decodeText(char *text, Tree *tree);
