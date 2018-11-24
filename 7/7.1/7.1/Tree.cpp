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

void deleteElement(Tree *tree, TreeNode *current, int number)
{
    if (current->value == number)
    {
        if (current->rightChild == nullptr && current->leftChild == nullptr)
        {
            delete current;
            current = nullptr;
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
            current = current->rightChild;
            
            while (current->leftChild)
            {
                previous = current;
                current = current->leftChild;
            }
            
            if (isLeftChild(previous, current->value))
            {
                node->value = current->value;
                current = (current)->leftChild;
            
            }
            else{
                if (tree->root->value == number)
                {
                    tree->root->value = current->value;
                    tree->root->rightChild = current->rightChild;
                }
                
                else
                {
                    node->value = current->value;
                    previous->rightChild = current->rightChild;
                }
            }
            
            delete current;
        }
    }
    
    else
    {
        if (current->value > number)
        {
            deleteElement(tree, current->leftChild, number);
        }
        
        else
        {
            deleteElement(tree ,current->rightChild, number);
        }
    }
}

void deleteElement(Tree *tree, int number)
{
    deleteElement(tree ,tree->root, number);
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

void printTree(TreeNode *current)
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

void printTree(Tree *tree)
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
