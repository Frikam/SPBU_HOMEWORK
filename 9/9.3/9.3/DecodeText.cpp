#include <iostream>

#include <string.h>

#include "DecodeText.hpp"

using namespace std;

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
