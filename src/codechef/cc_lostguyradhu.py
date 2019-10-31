# https://www.codechef.com/FLPAST01/problems/MAY19F1/
# cook your dish here
t = int(input())


def get_a_solved(a_list, n):
    for index in range(1, n):
        if a_list[index] < a_list[index - 1]:
            a_list[index] = a_list[index - 1]
    return a_list


max_list = []

while t:
    n, q = input().split()
    n, q = int(n), int(q)
    # Below line read inputs from user using map() function
    a_list = list(map(int, input().strip().split()))[:n]
    q_list = list(map(int, input().strip().split()))[:q]
    a_solved = get_a_solved(a_list, n)
    for i in q_list:
        print(a_solved[i - 1])
    t -= 1
