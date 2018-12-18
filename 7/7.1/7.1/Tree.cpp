#include <iostream>

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

void add(Tree *tree, int number)
{
    TreeNode *previous = nullptr;
    TreeNode *current = tree->root;
    
    if (!current)
    {
        tree->root = new TreeNode {number, nullptr, nullptr};
        return;
    }
    
    while (current)
    {
        if (current->value > number)
        {
            previous = current;
            current = current->leftChild;
        }
        else if (current->value < number)
        {
            previous = current;
            current = current->rightChild;
        }
        else
        {
            cout << "That number is already in tree" << endl;
        }
    }
    
    current = new TreeNode {number, nullptr, nullptr};
    
    if (current->value > previous->value)
    {
        previous->rightChild = current;
        return;
    }
    
    previous->leftChild = current;
}

bool isLeftChild(TreeNode *current, int number)
{
    if (current->leftChild != nullptr && current->leftChild->value == number)
    {
        return true;
    }
    
    return false;
}

void exist(Tree *tree, int number)
{
    TreeNode *current = tree->root;
    
    while (current)
    {
        if (current->value == number)
        {
            cout << "Number is in tree" << endl;;
            return;
        }
        if (current->value > number)
        {
            current = current->leftChild;
        }
        else if (current->value < number)
        {
            current = current->rightChild;
        }
    }
    
    cout << "Number not in tree" << endl;
}


void deleteElement(TreeNode *&node)
{
    TreeNode *removing = node;

    if (!node->leftChild && !node->rightChild)
    {
        delete removing;
        node = nullptr;
    }
    else if (!node->leftChild && node->rightChild)
    {
        node = node->rightChild;
        delete removing;
    }
    else if(node->leftChild && !node->rightChild)
    {
        node = node->leftChild;
        delete removing;
    }
    else
    {
        TreeNode **minimalInRightSubtree = &node->rightChild;
        while ((*minimalInRightSubtree)->leftChild)
        {
            *minimalInRightSubtree = (*minimalInRightSubtree)->leftChild;
        }
        node->value = (*minimalInRightSubtree)->value;
        deleteElement(*minimalInRightSubtree);
    }
}

void deleteElement(TreeNode *&node, int number)
{
    if (node->value > number)
    {
        deleteElement(node->leftChild, number);
    }
    else if (node->value < number)
    {
        deleteElement(node->rightChild, number);
    }
    else
    {
        deleteElement(node);
    }
}

void printTreeAscending(TreeNode *current)
{
    if (current->leftChild)
    {
        printTreeAscending(current->leftChild);
    }
    cout << current->value << ' ';
    if (current->rightChild)
    {
        printTreeAscending(current->rightChild);
    }
}

void printTreeAscending(Tree *tree)
{
    if (tree->root)
    {
        printTreeAscending(tree->root);
    }
    else
    {
        cout << "Tree is empty";
    }
    cout << endl;
}

void printTreeDescending(TreeNode *current)
{
    if (current->rightChild)
    {
        printTreeDescending(current->rightChild);
    }
    cout << current->value << ' ';
    if (current->leftChild)
    {
        printTreeDescending(current->leftChild);
    }
}

void printTreeDescending(Tree *tree)
{
    if (tree->root)
    {
        printTreeDescending(tree->root);
    }
    else
    {
        cout << "Tree is empty";
    }
    cout << endl;
}

void printTree(TreeNode *node)
{
    cout << "(" << node->value << " ";
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
