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

TreeNode *specifyLeftChild(TreeNode *&node)
{
    if (!node->leftChild)
    {
        return node;
    }
    else
    {
        return specifyLeftChild(node->leftChild);
    }
    return 0;
}

void deleteElement(TreeNode *&node, int value)
{
    if (node)
    {
        if (value == node->value)
        {
            TreeNode *deletedElement = node;
            if ((node->leftChild) && (node->rightChild))
            {
                deletedElement = specifyLeftChild(node->rightChild);
                node->value = deletedElement->value;
                deleteElement(node->rightChild, deletedElement->value);
                return;
            }
            else
            {
                if (!((node->leftChild) || (node->rightChild)))
                {
                    node = nullptr;
                }
                else
                {
                    if (node->leftChild)
                    {
                        node = deletedElement->leftChild;
                    }
                    else
                    {
                        node = deletedElement->rightChild;
                    }
                }
            }
            delete deletedElement;
        }
        else
        {
            if (value > node->value)
            {
                deleteElement(node->rightChild, value);
            }
            else
            {
                deleteElement(node->leftChild, value);
            }
        }
    }
}

void deleteElement(Tree *tree, int value)
{
    deleteElement(tree->root, value);
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
