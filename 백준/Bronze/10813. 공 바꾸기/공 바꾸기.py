N, M = map(int, input().split())

array = [i + 1 for i in range(N)]

for _ in range(M):
    i, j = map(int, input().split())
    array[i - 1], array[j - 1] = array[j - 1], array[i - 1]

print(' '.join(map(str, array)))
