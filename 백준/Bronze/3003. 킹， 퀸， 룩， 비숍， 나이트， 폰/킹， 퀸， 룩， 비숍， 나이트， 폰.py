required_pieces = [1, 1, 2, 2, 2, 8]

current_pieces = list(map(int, input().split()))

result = []

for i in range(len(required_pieces)):
    difference = required_pieces[i] - current_pieces[i]
    result.append(difference)

print(' '.join(map(str, result)))
