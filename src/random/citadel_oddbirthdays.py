


n = int(input())

nums = [int(x) for x in input().split(" ")]

odds = 0
d_count = {}

for num in nums:

	if num in d_count:
		d_count[num] = d_count[num] + 1
	else:
		d_count[num] = 1

for k, v in d_count.items():

	if v & 1 == 1:
		odds = odds + 1

print(odds)