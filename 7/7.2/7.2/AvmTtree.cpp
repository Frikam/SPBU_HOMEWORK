#include <iostream>

#include "AvmTtree.hpp"

using namespace std;

Tree *createTree()
{
    return new Tree {nullptr};
}

int height(Node *tree)
{
    if (tree)
    {
        return tree->height;
    }
    return 0;
}

void deleteTree(Node *current)
{
    if (!current)
    {
        return;
    }
    
    if (current->leftChild)
    {
        deleteTree(current->leftChild);
    }
    
    cout << current->value << ' ';
    if (current->rightChild)
    {
        deleteTree(current->rightChild);
    }
    delete current;
}

void deleteTree(Tree *tree)
{
    Node *current = tree->root;
    deleteTree(current);
}

int balanceFactor(Node *tree)
{
    return height(tree->rightChild) - height(tree->leftChild);
}

void updateHeight(Node *tree)
{
    int heightLeft = height(tree->leftChild);
    int heightRight = height(tree->rightChild);
    if (heightLeft > heightRight)
    {
        tree->height = heightLeft + 1;
    }
    else
    {
        tree->height = heightRight + 1;
    }
}

void rotateRight(Node *&root)
{
    Node *right = root->leftChild;
    root->leftChild = right->rightChild;
    right->rightChild = root;
    updateHeight(root);
    updateHeight(right);
    root = right;
}

void rotateLeft(Node *&root)
{
    Node *left = root->rightChild;
    root->rightChild = left->leftChild;
    left->leftChild = root;
    updateHeight(root);
    updateHeight(left);
    root = left;
}

void balance(Node *&tree)
{
    updateHeight(tree);
    
    if (balanceFactor(tree) == 2)
    {
        if (balanceFactor(tree->rightChild) < 0)
        {
            rotateRight(tree->rightChild);
        }
        rotateLeft(tree);
    }
    
    if (balanceFactor(tree) == -2)
    {
        if (balanceFactor(tree->leftChild) > 0)
        {
            rotateLeft(tree->leftChild);
        }
        
        rotateRight(tree);
    }
}

void addElement(Node *&tree, int number)
{
    if (!tree)
    {
        tree = new Node {number, 1, nullptr, nullptr};
        balance(tree);
        return;
    }
    if (number < tree->value)
    {
        addElement(tree->leftChild, number);
    }
    else
    {
        addElement(tree->rightChild, number);
    }
    balance(tree);
}

void addElement(Tree *tree, int number)
{
    addElement(tree->root, number);
}

void exist(Tree *tree, int number)
{
    Node *current = tree->root;
    
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

bool isLeftChild(Node *current, int number)
{
    if (current->leftChild != nullptr && current->leftChild->value == number)
    {
        return true;
    }
    
    return false;
}

void deleteElement(Node *current, int number)
{
    if (current->value ==   number)
    {
        if (current->rightChild == nullptr && current->leftChild == nullptr)
        {
            delete current;
            current = nullptr;
            return;
        }
        
        Node *node = current;

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
            Node *previous = current;
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
            
            updateHeight(node);
            balance(node);
            delete current;
            current = nullptr;
        }
    }
    
    else
    {
        if (current->value > number)
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

void printTreeAscending(Node *current)
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

void printTreeDescending(Node *current)
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
void printTree(Node *current)
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
