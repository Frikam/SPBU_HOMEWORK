#pragma once

struct QueueElement
{
    int x;
    int y;
    QueueElement *next;
};

struct Queue
{
    QueueElement *first;
};

Queue *createQueue();
bool isEmpty (Queue *queue);
void remove(Queue *queue, int x, int y);
void add(Queue *queue, int x, int y);
void deleteQueue(Queue *queue);
