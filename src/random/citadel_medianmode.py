

nums = [int(x) for x in input().split(" ")]
n = len(nums)

total = sum(nums)

mean = total / n


d_count = {}

max_freq = 0

for num in nums:

	if num in d_count:
		d_count[num] = d_count[num] + 1
	else:
		d_count[num] = 1

	max_freq = max(max_freq, d_count[num])


mode = float('inf')

for k, v in d_count.items():

	if v == max_freq:

		mode = min(mode, k)



print("{:.4f} {:d}".format(mean, mode))

