#include <iostream>

#include <fstream>

#include "List.hpp"

#include "Tree.hpp"

#include "DecodeText.hpp"

using namespace std;

int main()
{
    int const maxLength = 10000;
    char *text = new char [maxLength];

    ifstream fin("input.txt");
    List *list = createList();
    Tree *tree = createTree();

    buildTree(list, tree, text, fin);

    decodeText(text, tree);
    
    delete[] text;
    deleteTree(tree);
    deleteList(list);
    fin.close();
    return 0;
}
