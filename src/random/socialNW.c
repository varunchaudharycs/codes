/*
 * Computes the number of friends of each member of a "social network/circle"
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void main() {

	int start, end, n, connections, i;
	char friends[1000][1000], user[1000], final[100];

	printf("Enter the no. of users: ");
	scanf("%d", &n);

	for(i = 1; i <= n; i++) {

		strcpy(friends[i], "");
	}

	printf("Enter the no. of connections: ");
	scanf("%d", &connections);

	for(i = 1; i <= connections; i++) {

		printf("Enter the start node and end node in the connection %d: ", i);
		scanf("%d %d", &start, &end);

		if(i == 1) {

			strcpy(final, "");
		}
		else {

			strcpy(final, " ");
		}
		sprintf(user, "%d", end);
		strcat(final, user);
		strcat(friends[start], final);

		if(i == 1) {

			strcpy(final, "");
		}
		else {

			strcpy(final, " ");
		}
		sprintf(user, "%d", start);
		strcat(final, user);
		strcat(friends[end], final);
	}

	printf("The friends list of all users:\n");

	for(i = 1; i <= n; i++) {

		if(strcmp(friends[i], "") == 0) {

			printf("%d->0\n", i);
		}
		else {

			printf("%d->%s\n", i, friends[i]);
		}
	}
}