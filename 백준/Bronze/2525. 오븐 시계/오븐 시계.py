hour, minute = map(int, input().split())
add_minutes = int(input())

minute += add_minutes

hour += minute // 60
minute = minute % 60

hour = hour % 24

print(hour, minute)