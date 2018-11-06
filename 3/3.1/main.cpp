#include <iostream>

using namespace std;

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
    cout << "Program find max element  that occurs more than 1 time." << endl;
    const int maxLength = 100000;
    int allNumbers[maxLength];
    int quantityOfNumbers = 0;
    cout << "Enter lenght of array : ";
    cin >> quantityOfNumbers;
    
    cout << "Enter array : ";
    for (int i = 0; i < quantityOfNumbers; i++)
    {
        cin >> allNumbers[i];
    }
    
    quickSort(allNumbers, 0, quantityOfNumbers - 1);
    
    int maximum = allNumbers[0];
    bool isEqualWithPreviousNumber = false;
    
    for (int i = quantityOfNumbers - 1; i >= 1 ; i--)
    {
        if (allNumbers[i] == allNumbers[i-1])
        {
            isEqualWithPreviousNumber = true;
        }
        else
        {
            if (isEqualWithPreviousNumber && allNumbers[i] > maximum)
            {
                maximum = allNumbers[i];
            }
            
            isEqualWithPreviousNumber = false;
        }
    }
    
    cout << "Max element : ";
    cout << maximum;
    return 0;
}
