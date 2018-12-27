#pragma once

struct QueueElement
{
    int x;
    int y;
    int ParentX;
    int ParentY;
    QueueElement *next;
};

struct Queue
{
    QueueElement *first;
};

struct RightPoint
{
    int x;
    int y;
    QueueElement *parent;
    QueueElement *next;
};

struct FinalQueue
{
    RightPoint *first;
};

Queue *createQueue();
FinalQueue *createFinalQueue();

bool isEmpty (Queue *queue);
void remove(Queue *queue, int x, int y);
void add(Queue *queue, int x, int y, int x1, int y1);
void addInFinalQueue(FinalQueue *queue, int x, int y);
void deleteQueue(Queue *queue);
