/*
 * C code that replaces a character in a string
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void replace(char *s, char from, char to) {

	int len = strlen(s);
    int i;

    char *final = malloc(len+1);

    for(i=0; i<=len; i++) {      

        if(s[i] == from)
            final[i] = to;
        else
            final[i] = s[i];
    }

    printf("The modified string is %s", final);
}

void main() {

	char from, to, *s;

	printf("Enter the string\n");
	scanf("%s", s);

	printf("Enter the character to be replaced\n");
	scanf(" %c", &from);

	printf("Enter the character to be replaced with\n");
	scanf(" %c", &to);

	replace(s, from, to);
}