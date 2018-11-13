#include <iostream>

#include "BinaryTree.hpp"

using namespace std;

BinaryTree *createTree()
{
    return new BinaryTree {nullptr};
}

void add(BinaryTree *tree, int number)
{
    BinaryTreeNode *previous = nullptr;
    BinaryTreeNode *current = tree->root;
    
    if (!current)
    {
        tree->root = new BinaryTreeNode {number, nullptr, nullptr};
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
    
    current = new BinaryTreeNode {number, nullptr, nullptr};
    
    if (current->value > previous->value)
    {
        previous->rightChild = current;
        return;
    }
    
    previous->leftChild = current;
}

bool isLeftChild(BinaryTreeNode *current, int number)
{
    if (current->leftChild != nullptr && current->leftChild->value == number)
    {
        return true;
    }
    
    return false;
}

void exist(BinaryTree *tree, int number)
{
    BinaryTreeNode *current = tree->root;
    
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

void deleteElement(BinaryTree *tree, int number)
{
    BinaryTreeNode *current = tree->root;
    BinaryTreeNode *previous = nullptr;

    while (current->value != number)
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
    }
    
    if (current->leftChild == nullptr && current->rightChild == nullptr)
    {
        if (tree->root->value == number)
        {
            tree->root = nullptr;
        }
        else if (isLeftChild(previous, number))
        {
            previous->leftChild = nullptr;
        }
        else
        {
            previous->rightChild = nullptr;
        }
        delete current;
    }
    else if (current->leftChild == nullptr)
    {
        if (isLeftChild(previous, number))
        {
            previous->leftChild->value = current->rightChild->value;
            current->rightChild = nullptr;
            delete current->rightChild;
        }
        else
        {
            previous->rightChild->value = current->rightChild->value;
            current->rightChild = nullptr;
            delete current->rightChild;
        }
    }
    else if (current->rightChild == nullptr)
    {
        if (isLeftChild(previous, number))
        {
            previous->leftChild->value = current->leftChild->value;
            current->leftChild = nullptr;
            delete current->leftChild;
        }
        else
        {
            previous->rightChild->value = current->leftChild->value;
            current->leftChild = nullptr;
            delete current->leftChild;
        }
    }
    else
    {
        BinaryTreeNode *node = current;
        previous = current;
        current = current->rightChild;
        
        while (current->leftChild)
        {
            previous = current;
            current = current->leftChild;
        }
        if (isLeftChild(previous, current->value))
        {
            node->value = current->value;
            previous->leftChild = current->rightChild;
        }
        else{
            node->value = current->value;
            previous->rightChild = current->rightChild;
        }
        delete current;
    }
}

void printTreeAscending(BinaryTreeNode *current)
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

void printTreeAscending(BinaryTree *tree)
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

void printTreeDescending(BinaryTreeNode *current)
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

void printTreeDescending(BinaryTree *tree)
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
void printTree(BinaryTreeNode *current)
{
    cout << current->value << ' ';
    if (current->leftChild)
    {
        cout << '(';
        printTree(current->leftChild);
    }
    else
    {
        cout << " null";
    }
    
    if (current->rightChild)
    {
        cout << '(';
        printTree(current->rightChild);
    }
    else
    {
        cout << " null) ";
    }
}

void printTree(BinaryTree *tree)
{
    if (tree->root)
    {
        printTree(tree->root);
    }
    else
    {
        cout << "Tree is empty" << endl;
    }
    cout << endl;
}
