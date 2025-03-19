from sys import stdin

N = int(input())
N_list = list(map(int, input().split()))
v = int(input())

count = N_list.count(v)
print(count)