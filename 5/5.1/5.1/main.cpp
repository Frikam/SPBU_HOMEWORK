#include <iostream>

#include <cstdlib>

using namespace std;

void printArray(int **numbers, int num)
{
    int step = 0;
    int index1 = num / 2;
    int index2 = num / 2;
    cout << numbers[index1][index2] << ' ';

    while(index1 != 0 || index2 != num - 1)
    {
        step++;
        for (int j = 0; j < step; j++){
            index2--;
            cout << numbers[index1][index2] << ' ';
        }
        
        for (int j = 0; j < step; j++){
            index1++;
            cout << numbers[index1][index2] << ' ';
        }
        
        step++;
        for (int j = 0; j < step; j++){
            index2++;
            cout << numbers[index1][index2] << ' ';
        }
        
        for (int j = 0; j < step; j++){
            index1--;
            cout << numbers[index1][index2] << ' ';
        }
    }
    
    for (int j = 0; j < step; j++){
        index2--;
        cout << numbers[index1][index2] << ' ';
    }
    
    cout << endl;

}
int main()
{
    cout << "This program print array elements at round it on a spiral, since the center" << endl;
    cout << "Array (N x N)" << endl;
    cout << "Enter the N - ";
    int num = 0;
    cin >> num;
    
    int **numbers = new int*[num];

    for (int i = 0; i < num; i++){
        numbers[i] = new  int[num];
    }
    
    int p = 0;
    for (int i = 0; i < num; i++){
        for (int j = 0; j < num; j++){
            p++;
            cout << p << ' ';
            numbers[i][j] = p;
        }
        cout << endl;
    }
    
    cout << "Print on a spiral:" << endl;
    printArray(numbers, num);
    
    for (int i = 0; i < num; ++i) {
        delete[] numbers[i];
    }
    delete [] numbers;
    return 0;
}
