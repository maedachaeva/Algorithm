from sys import stdin

T = int(stdin.readline())

for x in range(1, T + 1):
    A, B = map(int, stdin.readline().split())
    print(f'Case #{x}: {A} + {B} = {A+B}')