#include <iostream>

#include "list.hpp"

#include "PhoneBook.hpp"

using namespace std;

int main()
{
    cout << "Cписок функций : " << endl;
    cout << "0 - выйти " << endl;
    cout << "1 - добавить запись (имя и телефон) " << endl;
    cout << "2 - найти телефон по имени " << endl;
    cout << "3 - найти имя по телефону " << endl;
    cout << "4 - сохранить текущие данные в файл" << endl;
    
    long long number = 0;
    const int maxLength = 1000;
    char fileName[maxLength] = "input.txt";
    char word[maxLength] {};
    
    List *phoneBook = createList();
    readFile(phoneBook, fileName);
    
    cout << "Напечатайте номер функции, которую хотите использовать" << endl;
    cout << "Номер функции : ";
    int whatFunction = 0;
    cin >> whatFunction;
    
    while(whatFunction != 0)
    {
        switch (whatFunction)
        {
            case 1:
                cout << "Введите номер : ";
                cin >> number;
                cout << "Введите имя в формате : Имя_Фамилия. Например, Иван_Иванов." << endl;
                cout << "Имя : ";
                cin >> word;
                add(phoneBook, number, word);
                break;
            case 2:
                cout << "Введите Имя_Фамилию человека, чей номер телефона вы хотите найти : ";
                cin >> word;
                number = findPhone(phoneBook, word);
                break;
            case 3:
                cout << "Введите номер телефона человека, которого вы хотите найти : ";
                cin >>number;
                findName(phoneBook, number, word);
                break;
            case 4:
                cout << "Данные сохраненны в файл." << endl;
                saveFile(phoneBook, fileName);
                break;
        }
        cout << "Номер функции : ";
        cin >> whatFunction;
    }
    cout << "Вы закончили работу с телефонным справочником.";
    deleteList(phoneBook);
}
