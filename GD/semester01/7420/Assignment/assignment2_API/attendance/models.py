from django.db import models
from django.core.validators import MinValueValidator
from datetime import date

from django.http import JsonResponse
from django.urls import reverse


class CollegeDay(models.Model):
    # classID = models.ManyToManyField(Class, through='Attendance')
    date = models.DateField()

    def __str__(self):
        return self.date.__str__()


class Semester(models.Model):
    this_year = int(date.today().year)
    year = models.IntegerField(validators=[MinValueValidator(this_year)], default=this_year)
    semester = models.CharField(max_length=2, null=False, blank=False)

    def __str__(self):
        return str(self.year) + " " + self.semester

    def get_absolute_url(self):
        return reverse('index')


class Course(models.Model):
    code = models.CharField(max_length=10, null=False, blank=False)
    name = models.CharField(max_length=100, null=False, blank=False)

    def __str__(self):
        return self.code + " " + self.name

    def get_absolute_url(self):
        return reverse('index')


class Lecturer(models.Model):
    firstName = models.CharField(max_length=100, null=False, blank=False)
    lastName = models.CharField(max_length=100, null=False, blank=False)
    email = models.EmailField(max_length=200)
    course = models.ManyToManyField(Course, null=True, blank=False)
    dateOfBirth = models.DateField(null=False, blank=False)

    def __str__(self):
        return self.firstname + " " + self.lastname

    def get_absolute_url(self):
        return reverse('index')


class Student(models.Model):
    firstName = models.CharField(max_length=100, null=False, blank=False)
    lastName = models.CharField(max_length=100, null=False, blank=False)
    email = models.EmailField(max_length=200)
    dateOfBirth = models.DateField(null=False, blank=False)

    def __str__(self):
        return self.firstname + " " + self.lastname

    def get_absolute_url(self):
        return reverse('index')


class Class(models.Model):
    number = models.CharField(max_length=10, null=False, blank=False, unique=True)
    semester = models.ForeignKey(Semester, null=False, blank=False, on_delete=models.CASCADE)
    course = models.ForeignKey(Course, null=False, blank=False, on_delete=models.CASCADE)
    lecturer = models.ForeignKey(Lecturer, models.SET_NULL, blank=True, null=True)

    def __str__(self):
        return str(self.number) + " " + self.course.name

    def get_absolute_url(self):
        return reverse('index')


class Enrollment(models.Model):
    studentID = models.ForeignKey(Student, on_delete=models.CASCADE)
    classID = models.ForeignKey(Class, on_delete=models.CASCADE)

    def __str__(self):
        return str(self.classID) + " " + str(self.studentID)


class Attendance(models.Model):
    studentID = models.ForeignKey(Student, on_delete=models.CASCADE)
    classID = models.ForeignKey(Class, on_delete=models.CASCADE)
    college_day = models.ForeignKey(CollegeDay, on_delete=models.CASCADE)
    status = models.BooleanField(default=False)

    def __str__(self):
        return str(self.studentID.firstname) + " " + str(self.studentID.lastname)
