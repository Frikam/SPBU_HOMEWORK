#include "Astar.hpp"

using namespace std;

void aStar(Map *map, bool **isUsed, int currentX, int currentY, Coordinate **rightWay)
{
    bool wayIsExsit = true;
    isUsed[currentX][currentY] = 1;
    int previousX = 0;
    int previousY = 0;
    int startX = currentX;
    int startY = currentY;
    Queue *queue = createQueue();
    
    while (wayIsExsit && isUsed[map->x][map->y] != 1)
    {
        previousX = currentX;
        previousY = currentY;
        addNeighbors(map ,queue, isUsed, currentX, currentY);
        findRightPoint(map, queue, currentX, currentY, rightWay);
        isUsed[currentX][currentY] = true;
        if (isEmpty(queue))
        {
            wayIsExsit = false;
        }
        else
        {
            remove(queue, currentX, currentY);
        }
    }
    
    if (!isUsed[map->x][map->y])
    {
        cout << "Path does not exist";
    }
    else
    {
        while (startX != currentX || startY != currentY)
        {
            previousX = currentX;
            previousY = currentY;
            map->map[currentX][currentY] = -1;
            currentX = rightWay[previousX][previousY].x;
            currentY = rightWay[previousX][previousY].y;
        }
        
        map->map[currentX][currentY] = -1;
        cout << endl << "Right way : ";
        for (int i = 0; i < map->sizeX; i++)
        {
            cout << endl;
            for (int j = 0; j < map->sizeY; j++)
            {
                if (map->map[i][j] == -1)
                {
                    cout << '#' << ' ';
                }
                else
                {
                    cout << map->map[i][j] << ' ';
                }
            }
        }
    }
    
    deleteQueue(queue);
    
}

int h(int x1, int y1, int x2, int y2)
{
    return (abs(x2 - x1) + abs(y2 - y1)) * 100;
}

void addNeighbors(Map *map, Queue *queue, bool **isUsed, int currentX, int currentY)
{
    checkNewPoint(map, queue, isUsed, currentX + 1, currentY, currentX, currentY);
    checkNewPoint(map, queue, isUsed, currentX, currentY + 1, currentX, currentY);
    checkNewPoint(map, queue, isUsed, currentX, currentY - 1, currentX, currentY);
    checkNewPoint(map, queue, isUsed, currentX - 1, currentY, currentX, currentY);
}

void checkNewPoint(Map *map, Queue *queue, bool **isUsed, int x, int y, int x1, int y1)
{
    if (x >=0 && y >= 0 && x < map->sizeX && y < map->sizeY && map->map[x][y] == 0 && isUsed[x][y] != true)
    {
        add(queue, x, y, x1, y1);
    }
}

void findRightPoint(Map *map, Queue *queue, int &currentX, int &currentY, Coordinate **rightWay)
{
    QueueElement *current = queue->first;
    int parentX = 0;
    int parentY = 0;
    int min = 100000000;
    while (current)
    {
        if (min > h(current->x, current->y, map->x, map->y))
        {
            min =  h(current->x, current->y, map->x, map->y);
            currentX = current->x;
            currentY = current->y;
            parentX = current->ParentX;
            parentY = current->ParentY;

        }
        
        current = current->next;
    }
    rightWay[currentX][currentY].x = parentX;
    rightWay[currentX][currentY].y = parentY;
}

