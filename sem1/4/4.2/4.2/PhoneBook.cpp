#include <iostream>

#include "PhoneBook.hpp"

#include "list.hpp"

#include <fstream>

using namespace std;

void findName(List *list, long long numb, char *word)
{
    bool weFoundNumber = false;
    int length = 0;
    ListElement *current = list->first;
    
    while(current)
    {
        if (numb == current->number)
        {
            length = strlen(current->name);
            
            for (int i = 0; i < length; i++)
            {
                word[i] = current->name[i];
            }
            
            weFoundNumber = true;
        }
        current = current->next;
    }
    
    if (weFoundNumber)
    {
        length = strlen(word);
        cout << "Искомое имя : ";
        for(int i = 0; i < length; i++)
        {
            cout << word[i];
        }
        cout << endl;
    }
    else{
        cout << "Такого номера нет в книге" << endl;
    }
}

int findPhone(List *list, char word[])
{
    bool isEqual = true;
    ListElement *current = list->first;
    while(current)
    {
        
        if (strcmp(current->name, word) == 0){
            cout << "Искомый номер телефона  : " << current->number << endl;
            return current->number;
        }
        isEqual = true;
        current = current->next;
        
    }
    cout << "Такого номера не существует";
    return 0;
}

void readFile(List *list, char fileName[])
{
    const int maxLength = 1000;
    long long number = 0;
    char space;
    char name[maxLength] {};
    ifstream fin;
    fin.open(fileName);
    fin >> number;
    while(fin >> name)
    {
        add(list, number, name);
        fin >> number;
    }
    fin.close();
}


void saveFile(List *list, char fileName[])
{
    ListElement *current = list->first;
    ofstream fout;
    fout.open(fileName, std::ios::out | std::ios::in);
    while (current)
    {
        fout << current->number << ' ';
        fout << current->name << ' ';
        fout << endl;
        current = current->next;
    }
    fout.close();
}
