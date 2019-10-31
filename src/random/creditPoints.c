/*
 * Outputs the users that cannot be served at the present moment depending upon the given capacity
*/

#include <stdio.h>
#include <stdlib.h>

void main() {

	int n, i, capacity, points[1000];

	printf("Enter the no. of users:");
	scanf("%d", &n);

	if(n <= 0 || n > 1000) {

		printf("Invalid no. of users\n");
		exit(0);
	}

	for(i = 1; i <= n; i++) {

		printf("Enter the credit points for user %d: ", i);
		scanf("%d", &points[i - 1]);
	}

	printf("Enter the no. of users to serve: ");
	scanf("%d", &capacity);

	if(capacity <=0 || capacity > n) {

		printf("Invalid no. of users\n");
		exit(0);
	}

	if(n - capacity == 0) {

		printf("0 users to serve");
	}
	else {

		printf("The unserved user’s credit points are: ");

		for(i = capacity; i < n; i++) {

			printf("%d ", points[i]);
		}
	}
	
}