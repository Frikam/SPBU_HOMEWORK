#pragma once

#include <fstream>

#include "Tree.hpp"

using namespace std;

struct HuffmanNode
{
    HuffmanNode *parent;
    HuffmanNode *left;
    HuffmanNode *right;
    char sign;
    int value;
};

struct HuffmanTree
{
    int size;
    HuffmanNode **tree;
};


HuffmanTree *createHuffmanTree();
void deleteHuffmanTree(HuffmanTree *tree);
void addSign(HuffmanTree *tree, char sign);
void printFrequencyofSign(HuffmanTree *tree, ofstream &output);
void buildTree(HuffmanTree *tree);
void printCode(HuffmanNode *node, ofstream &output);
void printTree(HuffmanTree *tree, ofstream &output);
void deleteHuffmanTree(HuffmanTree *tree);
void readFile(HuffmanTree *tree, char *text, ifstream &input, int &count);
