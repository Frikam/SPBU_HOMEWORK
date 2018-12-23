#pragma once

#include <iostream>

#include <string.h>

#include <fstream>

#include "List.hpp"

using namespace std;

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
void deleteElement(Tree *tree, int number);
void deleteTree(Tree *tree);
void addSign(Tree *tree, List *list, char sign);
void buildTree(List *list,Tree *tree, char *text, ifstream &fin);
