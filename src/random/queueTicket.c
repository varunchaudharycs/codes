/*
 * C program to create a queue and implement a bank ticket system
 */

#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
 
void main()
{
    int queue[1000];
    int n, i, served, unserved;

    printf("Enter the number of customer takes the tickets:\n");
    scanf("%d", &n);

    if(n < 0) {

        printf("Invalid Number");
        exit(0);
    }

    printf("The tickets in the system are:\n");

    for(i = 1; i <= n; i++) {

        printf("%d ", i);
    }

    printf("\nEnter the number of tickers served:\n");
    scanf("%d", &served);

    if(served > n) {

        printf("Invalid Number");
        exit(0);
    }

    printf("\nThe served tickets are:\n");

        for(i = 1; i <= served; i++) {

            printf("%d ", i);
        }


    unserved = n - served;

    if(unserved == 0) {

        printf("\nNo more tickes to be served");
    }
    else {

        printf("\nThe unserved tickets are:\n");

        for(i = n - unserved + 1; i <= n; i++) {

            printf("%d ", i);
        }
    }
}