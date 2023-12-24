from django import forms

from Scenario.models import Student, Lecturer, Semester, Class, Course, CollegeDay


# LecturerForm
class CreateLecturerForm(forms.ModelForm):
    class Meta:
        model = Lecturer
        fields = ["staff_id", "user", "DOB"]

        widgets = {
            "staff_id": forms.NumberInput(attrs={"class": "form-content", "placeholder": "staff_id"}),
            "user": forms.Select(attrs={"class": "form-content", "placeholder": "user"}),
            "DOB": forms.DateInput(attrs={"class": "form-content", "placeholder": "staff_id"}),
        }


class UpdateLecturerForm(forms.ModelForm):
    class Meta:
        model = Lecturer
        fields = ["staff_id", "user"]

        widgets = {
            "staff_id": forms.NumberInput(attrs={"class": "form-content", "placeholder": "student_id"}),
            "user": forms.Select(attrs={"class": "form-content", "placeholder": "user"}),
        }


# StudentForm
class CreateStudentForm(forms.ModelForm):
    class Meta:
        model = Student
        fields = ["student_id", "user"]

        widgets = {
            "student_id": forms.NumberInput(attrs={"class": "form-content", "placeholder": "student_id"}),
            "user": forms.Select(attrs={"class": "form-content", "placeholder": "user"}),
            # "college_day": forms.Select(attrs={"class": "form-content", "placeholder": "college_day"}),
        }


class UpdateStudentForm(forms.ModelForm):
    class Meta:
        model = Student
        fields = ["student_id", "user"]

        widgets = {
            "student_id": forms.NumberInput(attrs={"class": "form-content", "placeholder": "student_id"}),
            # "DOB": forms.SelectDateWidget(attrs={"class": "form-content", "placeholder": "YYYY-MM-DD"}),
            "user": forms.Select(attrs={"class": "form-content", "placeholder": "user"}),
            # "college_day": forms.Select(attrs={"class": "form-content", "placeholder": "college_day"}),
        }


# SemesterForm
class CreateSemesterForm(forms.ModelForm):
    class Meta:
        model = Semester
        fields = ["year", "semester"]

        widgets = {
            "year": forms.NumberInput(attrs={"class": "form-content", "placeholder": "year"}),
            "semester": forms.TextInput(attrs={"class": "form-content", "placeholder": "semester"}),
        }


class UpdateSemesterForm(forms.ModelForm):
    class Meta:
        model = Semester
        fields = ["year", "semester"]

        widgets = {
            "year": forms.NumberInput(attrs={"class": "form-content", "placeholder": "year"}),
            "semester": forms.TextInput(attrs={"class": "form-content", "placeholder": "semester"}),
        }


# ClassForm
class CreateClassForm(forms.ModelForm):
    class Meta:
        model = Class
        fields = ["number", "course", "semester", "lecturer", "student"]

        widgets = {
            "number": forms.NumberInput(attrs={"class": "form-content", "placeholder": "Class_No"}),
            "course": forms.Select(attrs={"class": "form-content", "placeholder": "course"}),
            "semester": forms.Select(attrs={"class": "form-content", "placeholder": "semester"}),
            "lecturer": forms.Select(attrs={"class": "form-content", "placeholder": "lecturer"}),
            "student": forms.SelectMultiple(attrs={"class": "form-content", "placeholder": "student"})}


class UpdateClassForm(forms.ModelForm):
    class Meta:
        model = Class
        fields = ["number", "course", "semester", "lecturer", "student"]

        widgets = {
            "number": forms.NumberInput(attrs={"class": "form-content", "placeholder": "Class_No"}),
            "course": forms.Select(attrs={"class": "form-content", "placeholder": "course"}),
            "semester": forms.Select(attrs={"class": "form-content", "placeholder": "semester"}),
            "lecturer": forms.Select(attrs={"class": "form-content", "placeholder": "lecturer"}),
            "student": forms.SelectMultiple(attrs={"class": "form-content", "placeholder": "student"})

        }


# Course Form
class CreateCourseForm(forms.ModelForm):
    class Meta:
        model = Course
        fields = ["code", "name", "semesters"]

        widgets = {
            "code": forms.TextInput(attrs={"class": "form-content", "placeholder": "code"}),
            "name": forms.TextInput(attrs={"class": "form-content", "placeholder": "name"}),
            "semesters": forms.SelectMultiple(attrs={"class": "form-content", "placeholder": "semesters"}),
        }


class UpdateCourseForm(forms.ModelForm):
    class Meta:
        model = Course
        fields = ["code", "name", "semesters"]

        widgets = {
            "code": forms.TextInput(attrs={"class": "form-content", "placeholder": "code"}),
            "name": forms.TextInput(attrs={"class": "form-content", "placeholder": "name"}),
            "semesters": forms.SelectMultiple(attrs={"class": "form-content", "placeholder": "semesters"}),
        }


# CollegeDay Form
class CreateCollegeDayForm(forms.ModelForm):
    class Meta:
        model = CollegeDay
        fields = ["date"]

        widgets = {
            "date": forms.SelectDateWidget(attrs={"class": "form-content", "placeholder": "date"}),
        }


class UpdateCollegeDayForm(forms.ModelForm):
    class Meta:
        model = CollegeDay
        fields = ["date"]

        widgets = {
            "date": forms.SelectDateWidget(attrs={"class": "form-content", "placeholder": "date"}),
        }


class AssignForm(forms.ModelForm):
    class Meta:
        model = Class
        fields = ["lecturer", "student"]

        widgets = {
            # "number": forms.NumberInput(attrs={"class": "form-content", "placeholder": "Class_No"}),
            # "course": forms.Select(attrs={"class": "form-content", "placeholder": "course"}),
            # "semester": forms.Select(attrs={"class": "form-content", "placeholder": "semester"}),
            # "college_day": forms.Select(attrs={"class": "form-content", "placeholder": "college_day"}),
            "student": forms.SelectMultiple(attrs={"class": "form-content", "placeholder": "student"}),
            "lecturer": forms.Select(attrs={"class": "form-content", "placeholder": "lecturer"}),
        }
