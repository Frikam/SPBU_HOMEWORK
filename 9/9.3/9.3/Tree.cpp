#include <iostream>

#include <string.h>

#include "Tree.hpp"

using namespace std;

Tree *createTree()
{
    return new Tree {nullptr};
}

void deleteTree(TreeNode *current)
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

void deleteTree(Tree *tree)
{
    TreeNode *current = tree->root;
    if (!current)
    {
        return;
    }
    deleteTree(current);
}

void add(Tree *tree, int number, List *list)
{
    TreeNode *previous = nullptr;
    TreeNode *current = tree->root;
    ListElement *pointer = list->top;
    bool isLeft = true;
    
    if (!current)
    {
        tree->root = new TreeNode {number, '#', nullptr, nullptr};
        return;
    }
    
    while (pointer)
    {
        previous = current;
        
        if (pointer->number == 0)
        {
            isLeft = true;
            if (current->leftChild)
            {
                current = current->leftChild;
            }
        }
        else
        {
            isLeft = false;
            if (current->rightChild)
            {
                current = current->rightChild;
            }
        }
        
        pointer = pointer->next;
    }
    
    if (isLeft)
    {
        previous->leftChild = new TreeNode {number, '#', nullptr, nullptr};
    }
    else
    {
        previous->rightChild = new TreeNode {number, '#', nullptr, nullptr};
    }
}

void addSign(Tree *tree, List *list, char sign)
{
    TreeNode *previous = nullptr;
    TreeNode *current = tree->root;
    ListElement *pointer = list->top;
    
    while (pointer)
    {
        if (pointer->number == 0)
        {
            current = current->leftChild;
        }
        else
        {
            current = current->rightChild;
        }
        
        pointer = pointer->next;
    }
    
    current->sign = sign;
}

bool isLeftChild(TreeNode *current, int number)
{
    if (current->leftChild != nullptr && current->leftChild->value == number)
    {
        return true;
    }
    
    return false;
}

void printTree(TreeNode *node)
{
    cout << "(" << node->value << " ";
    
    if (!node->leftChild && !node->rightChild)
    {
        cout << node->sign << ' ';
    }
    
    if (node->leftChild)
    {
        printTree(node->leftChild);
    }
    else
    {
        cout << "null ";
    }
    if (node->rightChild)
    {
        printTree(node->rightChild);
    }
    else
    {
        cout << "null";
    }
    cout << ")";
}


void printTree(Tree *tree)
{
    TreeNode *current = tree->root;
    if (current)
    {
        printTree(current);
        cout << endl;
    }
    else
    {
        cout << "No elements!" << endl;
    }
}

void decodeText(char *text, Tree *tree)
{
    TreeNode *current = tree->root;
    long length = strlen(text);
    
    for (int i = 0 ; i < length; i++)
    {
        if (text[i] == '0')
        {
            current = current->leftChild;
        }
        else
        {
            current = current->rightChild;
        }
        
        if (current->sign != '#')
        {
            cout << current->sign;
            current = tree->root;
        }
    }
}
