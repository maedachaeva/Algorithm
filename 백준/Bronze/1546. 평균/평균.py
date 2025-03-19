subject = int(input())
scores = list(map(int, input().split()))

M = max(scores)

new_scores = [(score / M) * 100 for score in scores]

total_score = sum(new_scores)
average_score = total_score / subject

print(average_score)