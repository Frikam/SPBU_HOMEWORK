#include <iostream>

using namespace std;

void swap(int *a, int *b)
{
    int replace = 0;
    replace = *a;
    *a = *b;
    *b = replace;
}

void shiftDown(int *number, int size, int pointer)
{
    int maxChild = 0;
    bool done = false;
    
    while (pointer * 2 <= size && !done)
    {
        if (pointer * 2 == size){
            maxChild = pointer * 2;
        }
        else
        {
            if (number[pointer * 2] > number[pointer * 2 + 1]){
                maxChild = pointer * 2;
            }
            else{
                maxChild = pointer * 2 + 1;
            }
        }
        if (number[pointer] < number[maxChild])
        {
            swap(number[pointer], number[maxChild]);
            pointer = maxChild;
        }
        else{
            done = true;
        }
    }
}

void sort(int *number, int size)
{
    for (int i = size / 2 - 1; i >= 0; i--)
    {
        shiftDown(number, size, i);
    }
    
    for (int i = size - 1; i > 0; i--)
    {
        swap(number[0], number[i]);
        shiftDown(number, i - 1, 0);
    }
}
int main()
{
    cout << "The program sort your array";
    int maxLength = 10000;
    int number[maxLength];
    int size = 0;
    cout << "Enter size of array : ";
    cin >> size;
    
    cout << "Enter array : ";
    for (int  i = 0; i < size; i++)
    {
        cin >> number[i];
    }
    
    sort(number, size);
    
    for (int  i = 0; i < size; i++)
    {
        
        cout << number[i] << ' ';
    }
    return 0;
}
