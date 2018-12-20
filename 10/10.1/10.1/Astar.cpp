#include "Astar.hpp"

using namespace std;

void aStar(Map *map, int **rightWay, int currentX, int currentY)
{
    bool wayIsExsit = true;
    rightWay[currentX][currentY] = 1;
    int previousX = 0;
    int previousY = 0;
    
    while (wayIsExsit && rightWay[map->x][map->y] != 1)
    {
        previousX = currentX;
        previousY = currentY;
        Queue *queue = createQueue();
        addNeighbors(map ,queue, rightWay, currentX, currentY);
        findRightPoint(map, queue, currentX, currentY);
        //cout << "Hello " << currentX << ' ' << currentY << endl;
        rightWay[previousX][previousY] = 1;
        if (isEmpty(queue))
        {
            wayIsExsit = false;
        }
        remove(queue, currentX, currentY);
    }
    
    if (!rightWay[map->x][map->y])
    {
        cout << "Path does not exist";
    }
    else
    {
        cout << endl << "Right way : ";
        for (int i = 0; i < map->sizeX; i++)
        {
            cout << endl;
            for (int j = 0; j < map->sizeY; j++)
            {
                cout << rightWay[i][j] << ' ';
            }
        }
    }
    
}

int h(int x1, int y1, Map *map)
{
    return (abs(map->x - x1) + abs(map->y - y1)) * 100;
}

void addNeighbors(Map *map, Queue *queue, int **rightWay, int currentX, int currentY)
{
    checkNewPoint(map, queue, rightWay, currentX + 1, currentY);
    checkNewPoint(map, queue, rightWay, currentX, currentY + 1);
    checkNewPoint(map, queue, rightWay, currentX, currentY - 1);
    checkNewPoint(map, queue, rightWay, currentX - 1, currentY);
}

void checkNewPoint(Map *map, Queue *queue, int **rightWay, int x, int y)
{
    if (x >=0 && y >= 0 && x < map->sizeX && y < map->sizeY && map->map[x][y] == 0 && rightWay[x][y] != 1)
    {
        add(queue, x, y);
    }
}

void findRightPoint(Map *map, Queue *queue, int &currentX, int &currentY)
{
    QueueElement *current = queue->first;
    int min = 100000000;
    while (current)
    {
        if (min >= h(current->x, current->y, map))
        {
            min =  h(current->x, current->y, map);
            currentX = current->x;
            currentY = current->y;
        }
        
        current = current->next;
    }
}

