from django.contrib import admin

# Register your models here.
from attendance.models import Semester, Course, Lecturer, Class, Student, Attendance, Enrollment, CollegeDay

admin.site.register(Semester)
admin.site.register(Course)
admin.site.register(Lecturer)
admin.site.register(Class)
admin.site.register(Student)
admin.site.register(Attendance)
admin.site.register(CollegeDay)
admin.site.register(Enrollment)
