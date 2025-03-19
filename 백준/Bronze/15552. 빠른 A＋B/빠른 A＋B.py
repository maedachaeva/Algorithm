from sys import stdin

T = int(stdin.readline())

for tc in range(T):
    A, B = map(int, stdin.readline().split())
    print(A+B)