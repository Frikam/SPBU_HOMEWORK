#pragma once

struct BinaryTreeNode
{
    int value;
    BinaryTreeNode *leftChild;
    BinaryTreeNode *rightChild;
};

struct BinaryTree
{
    BinaryTreeNode *root;
};

BinaryTree *createTree();
void add(BinaryTree *tree, int number);
void exist(BinaryTree *tree, int number);
void deleteElement(BinaryTree *tree, int number);
void printTree(BinaryTree *tree);
void printTreeAscending(BinaryTree *tree);
void printTreeDescending(BinaryTree *tree);


