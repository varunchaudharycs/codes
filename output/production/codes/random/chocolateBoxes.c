/*
 * C code that computes the number of chocolates in the boxes with each student given the condition that the boxes previous to odd number of chocolates will be destroyed
*/

#include <stdio.h>
#include <stdlib.h>

void main() {

	int n, i, box[1000], head;

	printf("Enter the no. of boxes: ");
	scanf("%d", &n);

	if(n <=0 || n > 10) {

		printf("Invalid input");
		exit(0);
	}

	head = 0;

	for(i = 1; i <= n; i++) {

		printf("Enter the no. of chocolates in box %d: ", i);
		scanf("%d", &box[i - 1]);

		if(i == 1 && (box[i - 1] % 2 == 1 || box[i - 1] < 0)){

			printf("Sorry!!! First box always should contain positive even no. of chocolates");
			exit(0);
		}

		if (box[i - 1] % 2 == 1) {

			head++;
		}
	}

	printf("No. of chocolates in each box: ");

	for(i = head; i < n; i++) {

		printf("%d ", box[i]);
	}

}