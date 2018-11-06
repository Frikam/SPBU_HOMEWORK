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
    cout << "Program will sorts the specified array" << endl;
    int quantity = 0;
    cout << "Enter lenght of array :";
    cin >> quantity;
    int maxLenght = 1000000;
    int num[maxLenght];
    
    for (int i = 0; i < quantity; i++)
    {
        cin >> num[i];
    }
    
    quickSort(num, 0, quantity - 1);
    
    cout << "Our array : ";
    
    for (int i = 0; i < quantity; i++)
    {
        cout << num[i] << ' ';
    }
    return 0;
}
