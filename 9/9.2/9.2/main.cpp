#include <iostream>

#include <fstream>

#include <string.h>

#include "HuffmanCode.hpp"

using namespace std;



int main()
{
    const int maxLength = 10000;
    int count = 0;
    char sign = '0';
    ifstream input("input.txt");
    char *text = new char[maxLength];
    HuffmanTree *tree = createHuffmanTree();
    
    while (!input.eof())
    {
        if (!input.eof())
        {
            input.get(sign);
            text[count] = sign;
            if (sign != '\n')
            {
                addSign(tree, sign);
            }
            count++;
        }
    }
    
    encode(tree);
    
    cout << "Frequency of the symbols : " << endl;
    printFrequencyofSign(tree);
    
    cout << endl << "Tree : ";
    printTree(tree);
    
    cout << endl << "Code of the symbols : ";
    
    for (int i = 0; i < tree->size; i++)
    {
        cout << endl << tree->tree[i]->sign << ' ';
        printCode(tree->tree[i]);

    }
    
    cout << endl << "Encoded text : ";
    
    for (int i = 0; i < count; i++)
    {
        for (int j = 0; j < tree->size; j++)
        {
            if (tree->tree[j]->sign == text[i])
            {
                printCode(tree->tree[j]);
            }
        }
    }
    
    deleteHuffmanTree(tree);
    delete[] text;
    return 0;
}
