#include <iostream>

void findStudent(int *list, int number, int numberOfStudents, int NumberOfSmartStudent)
{
    for (int i = 4; i < numberOfStudents; i++)
    {
        if (list[i] == number)
        {
            findStudent(list, i, numberOfStudents, NumberOfSmartStudent);
            list[i] = NumberOfSmartStudent;
        }
    }
}

using namespace std;

int main()
{
    const int maxLength = 10000;
    int *list = new int [maxLength] {};
    int numberOfStudents = 0;
    int number = 0;
    cout << "Enter number of students : ";
    cin >> numberOfStudents;
    
    for (int i = 4; i <= numberOfStudents; i++)
    {
        cout << "The number of the student whose written off : ";
        cin >> number;
        list[i] = number;
    }
    
    for (int i = 4; i <= numberOfStudents; i++)
    {
        if (list[i] == 1 || list[i] == 2 || list[i] == 3)
        {
            findStudent(list, i, numberOfStudents, list[i]);
        }
    }
    
    for (int i = 4; i <= numberOfStudents; i++)
    {
        if (list[i] == -1)
        {
            cout << "A student with this number must be expelled" << i << endl;
        }
        else
        {
            cout << "Number of student : " << i << "The number of the student whose written off : " << list[i] << endl;
        }
    }
    
    delete[] list;
    return 0;
}
