all_students = set(range(1, 31))

for _ in range(28):
    student_number = int(input())
    all_students.remove(student_number)

remaining_students = sorted(all_students)
for student in remaining_students:
    print(student)
