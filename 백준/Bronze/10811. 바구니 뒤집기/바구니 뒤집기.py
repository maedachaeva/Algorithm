N, M = map(int, input().split())

baskets = [i for i in range(1, N + 1)]

for _ in range(M):
    i, j = map(int, input().split())
    i -= 1
    j -= 1
    baskets[i:j+1] = reversed(baskets[i:j+1])

print(' '.join(map(str, baskets)))
