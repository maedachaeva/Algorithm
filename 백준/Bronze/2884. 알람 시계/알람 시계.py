hour, minute = map(int, input().split())

if minute < 45:
    new_minute = 60 - (45 - minute)
    if hour == 0:
        hour = 23
    else:
        hour -= 1
    print(f'{hour} {new_minute}')
else:
    print(f'{hour} {minute - 45}')