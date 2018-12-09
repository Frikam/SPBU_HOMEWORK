#pragma once

#include "Tree.hpp"

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
void printFrequencyofSign(HuffmanTree *tree);
void addInBinTree(HuffmanTree *tree, Tree *binTree);
void encode(HuffmanTree *tree);
void printCode(HuffmanNode *node);
void printTree(HuffmanTree *tree);
void deleteHuffmanTree(HuffmanTree *tree);
