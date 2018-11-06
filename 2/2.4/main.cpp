#include <iostream>

using namespace std;

int lengthOfNumber(int numb)
{
    int count = 0;
    while(numb != 0)
    {
        count++;
        numb = numb / 10;
    }
    return count;
}

void quickSort(int array[], int left, int right)
{
    int pointer = array[left];
    int leftHold = left;
    int rightHold = right;
    
    while(left < right)
    {
        
        while((array[right] >= pointer) && (left < right))
        {
            right--;
        }
        
        if (left != right)
        {
            array[left] = array[right];
            left++;
        }
        
        while((array[left] <= pointer) && (left < right))
        {
            left++;
        }
        
        if (left != right)
        {
            array[right] = array[left];
            right--;
        }
    }
    
    array[left] = pointer;
    
    if (leftHold < left)
    {
        quickSort(array, leftHold, left - 1);
        
    }
    
    if (rightHold > left)
    {
        quickSort(array, left + 1, rightHold);
        
    }
    
}

int main()
{
    cout << "The program will be the minimum number of digits of the number" << endl;
    int lenght = 0;
    int numb = 0;
    
    cout << "Enter number: ";
    cin >> numb;
    cout << endl;
    
    int index = 0;
    lenght = lengthOfNumber(numb);
    int maxLength = 1000000;
    int allDigits[maxLength];
    
    while (numb > 0)
    {
        allDigits[index] = numb % 10;
        numb = numb / 10;
        index++;
    }
    
    quickSort(allDigits, 0, lenght - 1);
    
    for (int i = 0; i < lenght; i++)
    {
        cout << allDigits[i];
    }
    return 0;
}
