#include "Tree.hpp"

Tree *createTree()
{
    return new Tree {nullptr};
}

void buildTree(List *list,Tree *tree, char *text, ifstream &fin)
{
    int count = 0;
    bool isFirstSign = true;
    int number = 0;
    char previousSign = ' ';
    char sign = ' ';
    
    fin.get(sign);
    
    while (sign != '(')
    {
        fin.get(sign);
    }
    
    while (sign != '\n')
    {
        if (sign == '(')
        {
            if (previousSign == ')')
            {
                listPush(list, 1);
            }
            else if (!isFirstSign)
            {
                listPush(list, 0);
            }
            
            fin >> number;
            
            add(tree, number, list);
            isFirstSign = false;
            
            fin.get(sign);
            fin.get(sign);
            
            if (sign != '(')
            {
                previousSign = sign;
                fin.get(sign);
                
                if (sign != 'u')
                {
                    addSign(tree, list, previousSign);
                }
            }
            
            previousSign = '(';
        }
        else
        {
            if (sign == ')')
            {
                if (list->top)
                {
                    listPop(list);
                }
                previousSign = sign;
            }
            
            fin.get(sign);
        }
    }
    
    while (count != 2)
    {
        fin >> sign;
        if (sign == ':')
        {
            count++;
        }
    }
    
    count = 0;
    while (!fin.eof())
    {
        fin >> sign;
        if (!fin.eof())
        {
            text[count] = sign;
            count++;
        }
    }
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
        delete tree;
        return;
    }
    deleteTree(current);
    delete tree;
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
