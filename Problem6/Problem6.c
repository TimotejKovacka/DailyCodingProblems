// This problem was asked by Google.
// An XOR linked list is a more memory efficient doubly linked list. Instead of each node holding next and prev fields,
// it holds a field named both, which is an XOR of the next node and the previous node. Implement an XOR linked list;
// it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

#include <stdint.h>
#include <stdlib.h>
#include <limits.h>

typedef struct problem6_node {
    int data;
    struct problem6_node* xor;
} XORNode;

typedef struct problem6_xorLinkedList {
    struct problem6_node* head;
} XORLL;

XORNode* XOR(XORNode* x, XORNode* y){
    return (XORNode*)((uintptr_t) x ^ (uintptr_t) y);
}

void add(XORNode** head, int data){
    XORNode* new = (XORNode*)malloc(sizeof(XORNode));
    new->data = data;
    new->xor = XOR(*head, NULL);
    if(*head){
        (*head)->xor = XOR(new, XOR((*head)->xor, NULL));
    }
    *head = new;
}

// returns value of node at index "index" or INT_MAX if "index" out of bound for Linked List
int get(XORNode* head, int index){
    int currentIndex = 0;
    XORNode *currentNode, *previousNode, *nextNode;
    currentNode = head;
    previousNode = NULL;
    while (currentIndex != index){
        if (!currentNode) return INT_MAX;
        nextNode = XOR(previousNode, currentNode->xor);
        previousNode = currentNode;
        currentNode = nextNode;
        currentIndex++;
    }
    return currentNode->data;
}

int main() {
    int array[] = {13, 8, 175, 15, 43};
    int n = sizeof(array)/sizeof(array[0]);
    XORLL* linkedList = (XORLL*)malloc(sizeof(XORLL));
    linkedList->head = NULL;
    for (int i=n-1; i >= 0; i--){
        add(&linkedList->head, array[i]);
    }
    printf("%d", get(linkedList->head, 3));
}