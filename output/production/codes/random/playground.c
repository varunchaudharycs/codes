#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

/*
 * Computes area of cricket ground/basketball court
 */

struct circle
{
float radius;
};

struct rectangle
{
int length;
int breadth;
};

int main()
{
	int choice;
	
	printf("Shapes :\n1. Cricket Ground\n2. Basket Ball Ground\nEnter the choice:\n");
	scanf("%d", &choice);
	
	if(choice == 1)
	{
		struct circle cricket;
		
		printf("Enter the radius :\n");
		scanf("%f", &cricket.radius);
		
		if(cricket.radius < 0)
		{
			printf("Value Cannot be in Negative.");
		}
		else
		{
			printf("Area required to construct Cricket Ground : %.2fsqm", (3.14 * cricket.radius * cricket.radius));
		}
	}
	else
	{
		struct rectangle basketball;
		
		printf("Enter the length :\n");
		scanf("%d", &basketball.length);
		printf("Enter the breadth :\n");
		scanf("%d", &basketball.breadth);
		
		if(basketball.length < 0 || basketball.breadth < 0)
		{
			printf("Value Cannot be in Negative.");
		}
		else
		{
			printf("Area required to construct Basket Ball Ground : %dsqm", (basketball.length * basketball.breadth));
		}
	}
}
	
	
