from django.contrib.auth.models import User, AbstractUser
from django.db import models


class Semester(models.Model):
    year = models.IntegerField(null=True, blank=True)
    semester = models.CharField(max_length=255, null=True, blank=True)

    def __str__(self):
        return str(self.year) + '-' + str(self.semester)


class Course(models.Model):
    code = models.CharField(max_length=255, null=True, blank=True)
    name = models.CharField(max_length=255, null=True, blank=True)
    semesters = models.ManyToManyField(Semester, blank=True)

    def __str__(self):
        return self.name


class Lecturer(models.Model):
    staff_id = models.IntegerField(null=True, blank=True)
    DOB = models.DateField(null=True, blank=True)
    user = models.OneToOneField(User, on_delete=models.CASCADE)

    def __str__(self):
        return self.user.first_name + " " + self.user.last_name


class Student(models.Model):
    student_id = models.IntegerField(null=True, blank=True)
    DOB = models.DateField(null=True, blank=True)
    user = models.OneToOneField(User, on_delete=models.CASCADE)

    def __str__(self):
        return self.user.first_name + " " + self.user.last_name


class Class(models.Model):
    number = models.IntegerField(null=True, blank=True)
    course = models.ForeignKey(Course, null=True, on_delete=models.CASCADE)
    semester = models.ForeignKey(Semester, null=True, on_delete=models.CASCADE)
    lecturer = models.ForeignKey(Lecturer, null=True, on_delete=models.CASCADE)
    student = models.ManyToManyField(Student, blank=True)

    def __str__(self):
        return str(self.number)


class CollegeDay(models.Model):
    date = models.DateField(null=True, blank=True)
    _class = models.ForeignKey(Class, on_delete=models.CASCADE, null=True, blank=True)
    student = models.ManyToManyField(Student, related_name="Student")

    def __str__(self):
        return str(self.date)


class Attendance(models.Model):
    lecturer = models.ForeignKey(Lecturer, on_delete=models.CASCADE, null=True, blank=True)
    course = models.ForeignKey(Course, on_delete=models.CASCADE, null=True, blank=True)
    student = models.ForeignKey(Student, on_delete=models.CASCADE, null=False, blank=False)
    college_day = models.ForeignKey(CollegeDay, on_delete=models.CASCADE, null=True, blank=True)
    attendance = models.IntegerField()
