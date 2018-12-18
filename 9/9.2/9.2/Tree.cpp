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

void add(Tree *tree, int number, char sign)
{
    TreeNode *previous = nullptr;
    TreeNode *current = tree->root;
    
    if (!current)
    {
        tree->root = new TreeNode {number, sign, nullptr, nullptr};
        return;
    }
    
    while (current)
    {
        if (current->value >= number)
        {
            previous = current;
            current = current->leftChild;
        }
        else
        {
            previous = current;
            current = current->rightChild;
        }
    }
    
    current = new TreeNode {number, sign, nullptr, nullptr};
    
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

void deleteElement(TreeNode *&current, int number)
{
    if (current->value == number)
    {
        if (current->rightChild == nullptr && current->leftChild == nullptr)
        {
            delete current;
            current = nullptr;
            return;
        }
        
        TreeNode *node = current;

        if (current->rightChild == nullptr)
        {
            current = current->leftChild;
            delete node;
        }
        
        else if (current->leftChild == nullptr)
        {
            current = current->rightChild;
            delete node;
        }
        
        else
        {
            TreeNode *previous = current;
            node = node->rightChild;
            
            while (node->leftChild)
            {
                previous = node;
                node = node->leftChild;
            }
            
            if (isLeftChild(previous, node->value))
            {
                current->value = node->value;
                previous->leftChild = (node)->leftChild;
            }
            
            else
            {
                current->value = node->value;
                previous->rightChild = node->rightChild;
            }
            
            delete node;
        }
    }
    
    else
    {
        if (current->value >= number)
        {
            deleteElement(current->leftChild, number);
        }
        else
        {
            deleteElement(current->rightChild, number);
        }
    }
}

void deleteElement(Tree *tree, int number)
{
    deleteElement(tree->root, number);
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


int takeMin(Tree *tree)
{
    int answer = 0;
    TreeNode *current = tree->root;
    
    while (current->leftChild)
    {
        current = current->leftChild;
    }
    
    answer = current->value;
    deleteElement(tree, answer);
    return answer;
}
