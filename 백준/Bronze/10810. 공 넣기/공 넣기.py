N, M = map(int, input().split())    

# i번 ~ j번 바구니에 k번 번호가 적힌 공을 넣는다.

arr = [0] * N

for _ in range(M):
    i, j, k = map(int, input().split())
    for idx in range(i - 1, j):  
        arr[idx] = k

print(' '.join(map(str, arr)))