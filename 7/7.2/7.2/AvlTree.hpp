#pragma once

struct Node
{
    int value;
    int height;
    Node* leftChild;
    Node* rightChild;
};

struct Tree
{
    Node *root;
};

Tree *createTree();
int height(Tree *tree);
int balanceFactor(Tree *tree);
void updateHeight(Tree *tree);
void *balance(Tree *tree);
void *rotateLeft(Tree *root);
void *rotateRight(Tree *root);
void addElement(Tree *tree, int number);
void deleteElement(Tree *root, int number);
void exist(Tree *tree, int number);
void printTree(Tree *tree);
void printTreeAscending(Tree *tree);
void printTreeDescending(Tree *tree);
void deleteTree(Tree *tree);
