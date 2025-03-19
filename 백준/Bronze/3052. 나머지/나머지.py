remainders = set()

for _ in range(10):
    number = int(input())
    remainders.add(number % 42)

print(len(remainders))
