#include <iostream>

#include <fstream>

#include "List.hpp"

#include "Tree.hpp"

using namespace std;

int main()
{
    int const maxLength = 10000;
    char *text = new char [maxLength];
    int count = 0;
    bool isFirstSign = true;
    int number = 0;
    char previousSign = ' ';
    char sign = ' ';
    ifstream fin("input.txt");
    List *list = createList();
    Tree *tree = createTree();
    fin.get(sign);

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
    
    while (!fin.eof())
    {
        fin >> sign;
        text[count] = sign;
        count++;
    }

    decodeText(text, tree);
    
    delete[] text;
    deleteTree(tree);
    deleteList(list);
    fin.close();
    return 0;
}
