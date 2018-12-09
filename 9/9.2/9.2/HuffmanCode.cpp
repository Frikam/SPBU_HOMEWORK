#include <iostream>

#include "HuffmanCode.hpp"

#include "Tree.hpp"

using namespace std;

HuffmanTree *createHuffmanTree()
{
    HuffmanTree *tree = new HuffmanTree;
    tree->size = 1000;
    tree->tree = new HuffmanNode *[tree->size];
    for (int i = 0; i < tree->size; i++)
    {
        tree->tree[i] = nullptr;
    }
    
    return tree;
}

void addSign(HuffmanTree *tree, char sign)
{
    int index = 0;
    
    while (tree->tree[index] && tree->tree[index]->sign != sign)
    {
        index++;
    }
    
    if (!tree->tree[index])
    {
        if (tree->size == 1000)
        {
            tree->size = 0;
        }
        
        tree->size++;
        tree->tree[index] = new HuffmanNode;
        tree->tree[index]->parent = nullptr;
        tree->tree[index]->sign = sign;
        tree->tree[index]->value = 1;
        tree->tree[index]->left = nullptr;
        tree->tree[index]->right = nullptr;
    }
    else
    {
        tree->tree[index]->value++;
    }
}

void addInBinTree(HuffmanTree *tree, Tree *binTree)
{
    for (int i = 0; i < tree->size; i++)
    {
        add(binTree, tree->tree[i]->value);
    }
}

void printFrequencyofSign(HuffmanTree *tree)
{
    for (int i = 0; i < tree->size; i++)
    {
        cout << tree->tree[i]->value << ' ' << tree->tree[i]->sign << endl;
    }
}

void dfs(HuffmanNode *node)
{
    if (node)
    {
        if (node->sign != '%')
        {
            cout << ' ' << node->sign << endl;
        }
        
        if (node->left)
        {
            cout << '0';
            dfs(node->left);
        }
        if (node->right)
        {
            cout << '1';
            dfs(node->right);
        }
    }
}

int getMainNumber(HuffmanNode *current)
{
    while (current->parent)
    {
        current = current->parent;
    }
    
    return current->value;
}

void makeNewParent(HuffmanNode *current, HuffmanNode *newNode, bool isLeft)
{
    while (current->parent)
    {
        current = current->parent;
    }
    if (isLeft)
    {
        newNode->left = current;
    }
    else
    {
        newNode->right = current;
    }
    
    current->parent = newNode;
}

void printCode(HuffmanNode *node)
{
    bool isLeft = false;
    
    if (node->parent)
    {
        if (node->parent->left->value == node->value && node->parent->left->sign == node->sign)
        {
            isLeft = true;
        }
        
        printCode(node->parent);
        
        if (isLeft)
        {
            cout << '0';
        }
        else
        {
            cout << '1';
        }
    }
}

void encode(HuffmanTree *tree)
{
    HuffmanNode *mainNode;
    Tree *binTree = createTree();
    addInBinTree(tree, binTree);
    int index = tree->size;
    int firstMin = 0;
    int secondMin = 0;
    
    while (index != 1)
    {
        bool leftUsed = false;
        bool rightUsed = false;
        firstMin = takeMin(binTree);
        secondMin = takeMin(binTree);
        add(binTree, firstMin + secondMin);
        HuffmanNode *newNode = new HuffmanNode;
        newNode->sign = '%';
        newNode->value = firstMin + secondMin;
        
        for (int i = 0; i < tree->size; i++)
        {
            if (getMainNumber(tree->tree[i]) == firstMin && !leftUsed)
            {
                leftUsed = true;
                newNode->left = tree->tree[i];
                makeNewParent(tree->tree[i], newNode, true);
            }
            
            if (getMainNumber(tree->tree[i]) == secondMin && !rightUsed)
            {
                rightUsed = true;
                newNode->right = tree->tree[i];
                makeNewParent(tree->tree[i], newNode, false);
            }
        }
        
        index--;
        mainNode = newNode;
    }
    
    deleteTree(binTree);
}

void printTree(HuffmanNode *node)
{
    cout << "(" << node->value << " ";
    if (node->left)
    {
        printTree(node->left);
    }
    else
    {
        cout << "null ";
    }
    if (node->right)
    {
        printTree(node->right);
    }
    else
    {
        cout << "null";
    }
    cout << ")";
}

void printTree(HuffmanTree *tree)
{
    HuffmanNode *current = tree->tree[0];
    while (current->parent)
    {
        current = current->parent;
    }
    
    printTree(current);
    cout << endl;
}

void deleteTree(HuffmanNode *current)
{
    if (current->left)
    {
        deleteTree(current->left);
    }
    
    if (current->right)
    {
        deleteTree(current->right);
    }
    
    delete current;
}

void deleteHuffmanTree(HuffmanTree *tree)
{
    HuffmanNode *current = tree->tree[0];
    
    if (!current)
    {
        return;
    }
    deleteTree(current);
}
