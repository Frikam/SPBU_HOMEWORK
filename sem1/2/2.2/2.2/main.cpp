#include <iostream>

using namespace std;

int split(int position, int sum, int numb, int numbers[], int quantityOfNumb)
{
    for (int i = position; i < numb; i++)
    {
        numbers[quantityOfNumb] = i;
        
        if (numbers[quantityOfNumb] + sum == numb)
        {
            
            for (int j = 1; j <= quantityOfNumb; j++)
            {
                if (j > 1){
                    cout << " + " << numbers[j];
                }
                else{
                    cout << numbers[j];
                }
            }
            
            cout << endl;
        }
        else
        {
            if (numbers[i] + sum < numb){
                split(i, sum + i , numb, numbers, quantityOfNumb + 1);
            }
        }
    }
    
    return 0;
}
int main()
{
    cout << "The program will display possible representations of the number" << endl;
    int numb = 0;
    cout << "Enter your number : ";
    cin >> numb;
    int maxLength = 100000;
    int numbers[maxLength];
    int quantityOfNumb = 1;
    int sum = 0;

    split(1, sum, numb, numbers, quantityOfNumb);
    return 0;
}
