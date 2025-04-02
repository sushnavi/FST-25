num_tuple = (1,5,10,81,90)
print("Entered list is ", num_tuple)

# Print elementnumbers that are divisible by 5
print("Numbers that are divisible by 5:")
for num in num_tuple:
    if (num % 5 == 0):
        print(num)