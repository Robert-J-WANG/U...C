from django.contrib import admin

# Register your models here.
from Scenario.models import Class, Course, CollegeDay, Lecturer, Student, Semester

admin.site.register(Course)
admin.site.register(Lecturer)
admin.site.register(Student)
admin.site.register(Semester)
admin.site.register(Class)
admin.site.register(CollegeDay)
# admin.site.register(User)
