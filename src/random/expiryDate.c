#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

/*
 * Compares manufacturing and expiry date to find the difference in days and select/reject accordingly
 */
 
const int monthDays[12] = {31, 28, 31, 30, 31, 30,
                           31, 31, 30, 31, 30, 31};
                           
struct date 
	{
		int day, month, year;
	};
	
int countLeapYears(struct date d)
{
    int years = d.year;
 
    if (d.month <= 2)
        years--;
 
    return years / 4 - years / 100 + years / 400;
}

int getDifference(struct date start, struct date end)
{
    long int n1 = start.year*365 + start.day;
 
    for (int i=0; i<start.month - 1; i++)
        n1 += monthDays[i];
 
    n1 += countLeapYears(start);
  
    long int n2 = end.year*365 + end.day;
    
    for (int i=0; i<end.month - 1; i++)
        n2 += monthDays[i];
    
    n2 += countLeapYears(end);
 
    return (n2 - n1);
}

int main()
{
                           
	struct date start;
		
	printf("Enter the date of manufacturing\n");
	
	printf("Enter the starting day\n");
	scanf("%d", &start.day);
	
	printf("Enter the starting month\n");
	scanf("%d", &start.month);
	
	printf("Enter the starting year\n");
	scanf("%d", &start.year);
	
	struct date end;
	
	printf("Enter the expiry date\n");
	
	printf("Enter the ending day\n");
	scanf("%d", &end.day);
	
	printf("Enter the ending month\n");
	scanf("%d", &end.month);
	
	printf("Enter the ending year\n");
	scanf("%d", &end.year);
	
	
	int diffInDays = getDifference(start, end);
	
	if(diffInDays < 0)
	{
		printf("Incorrect expiry date!");
		exit(0);
	}	
	
	if(diffInDays > 730)
	{
		printf("Total number of days is %d. Sorry Your application has been rejected.", diffInDays);
	}
	else
	{
		printf("Total number of days is %d. Your application has been accepted.", diffInDays);
	}	
}
