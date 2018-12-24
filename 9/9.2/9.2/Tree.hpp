#pragma once

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
void add(Tree *tree, int number, char sign);
void exist(Tree *tree, int number);
void deleteElement(Tree *tree, int number);
void printTree(Tree *tree);
void printTreeAscending(Tree *tree);
void printTreeDescending(Tree *tree);
void deleteTree(Tree *tree);
int takeMin(Tree *tree);
void deleteElement3(TreeNode *&node);
