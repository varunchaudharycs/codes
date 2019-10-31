/*
 * C program to create a linked list and display the number of occurences of an item
 */

#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
 
// structure of each node
struct node
    {
        int data;
        struct node *next;
    };
    typedef struct node NODE;

// returns number of occurences of an element thru recursion 
int findOccurences(NODE *head, int key, int occurences) {

	if(head == NULL) {

		return occurences;
	}
	else {

		if(head->data == key) {

			occurences++;
		}

		findOccurences(head->next, key, occurences);
	}
}

void main()
{
	// head - CURRENT node, first - FIRST NODE of the Linked List
    NODE *head, *first, *temp = NULL;
    first = NULL;
    int count = 0, i, n, key, occurences;

    printf("Enter the size of the list:");
    scanf("%d", &n);
 
    for(i = 1; i <= n; i++) {

        head  = (NODE *)malloc(sizeof(NODE));
        
        scanf("%d", &head-> data);
        head->next = NULL;

        if (first == NULL) {

        	first = temp = head;
        }
        else {

        	// temp points to previous node
            temp->next = head;
            temp = head;
        }

        fflush(stdin);
    }

    /*  reset temp to the beginning */
    temp = first;
    printf("Printing the list:\n");

    while (temp != NULL) {

        printf("%d ", temp->data);
        temp = temp -> next;
    }

    // accepting element to be found
    printf("\nEnter the key to find it's occurrence:");
    scanf("%d", &key);

    occurences = findOccurences(first, key, 0);

    // printing result
    printf("%d occurs for %d times.\n", key, occurences);
}