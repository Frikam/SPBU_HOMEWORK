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
    ofstream output("output.txt");
    char *text = new char[maxLength];
    HuffmanTree *tree = createHuffmanTree();
    
    while (!input.eof())
    {
        input.get(sign);
        if (!input.eof())
        {
            text[count] = sign;
            if (sign != '\n')
            {
                addSign(tree, sign);
            }
            count++;
        }
    }
    
    buildTree(tree);
    
    output << "Frequency of the symbols : " << endl;
    printFrequencyofSign(tree, output);
    
    output << endl << "Tree : ";
    printTree(tree, output);
    
    output << endl << "Code of the symbols : ";
    
    for (int i = 0; i < tree->size; i++)
    {
        output << endl << tree->tree[i]->sign << ' ';
        printCode(tree->tree[i], output);

    }
    
    output << endl << endl << "Encoded text : ";
    
    for (int i = 0; i < count; i++)
    {
        for (int j = 0; j < tree->size; j++)
        {
            if (tree->tree[j]->sign == text[i])
            {
                printCode(tree->tree[j], output);
            }
        }
    }
    
    deleteHuffmanTree(tree);
    delete[] text;
    return 0;
}
