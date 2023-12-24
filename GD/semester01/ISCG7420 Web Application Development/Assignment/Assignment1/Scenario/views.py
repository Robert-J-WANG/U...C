import datetime

from django.contrib.auth import authenticate, login, logout
from django.contrib.auth.models import User
from django.core.files.storage import FileSystemStorage
from django.core.mail import send_mail
from django.http import HttpResponseRedirect
from django.shortcuts import render, redirect

# Create your views here.
from django.urls import reverse_lazy, reverse
from django.views.generic import ListView, DetailView, CreateView, UpdateView, DeleteView

from Scenario.forms import \
    CreateSemesterForm, UpdateSemesterForm, UpdateClassForm, CreateClassForm, CreateCourseForm, UpdateCourseForm, \
    CreateCollegeDayForm, UpdateCollegeDayForm, AssignForm
from Scenario.models import Lecturer, Student, Class, Course, Semester, CollegeDay, Attendance
import pandas as pd


def login_user(request):
    if request.method == "POST":
        user_type = request.POST['user_type']
        username = request.POST['username']
        password = request.POST['password']
        user = authenticate(username=username, password=password)
        if user is not None:
            if user.is_active:
                login(request, user)
                if user_type == 'Login As Student':
                    return redirect('student_home')
                elif user_type == 'Login As Lecturer':
                    return redirect('lecturer_home')
                elif user_type == 'Login As Administrator':
                    return redirect('admin_home')
            else:
                return render(request, 'login_user.html', {'error': 'Your Account has been disabled'})
        else:
            return render(request, 'login_user.html', {'error_message': 'Invalid login'})
    return render(request, 'login_user.html', {'error_message': 'Invalid login'})


def logout_user(request):
    logout(request)
    return redirect('login_user')


def index(request):
    context = {"title": "Home Page"}
    return render(request, 'index.html', context)


def admin_home(request):
    lecturers = Lecturer.objects.all()
    students = Student.objects.all()
    classes = Class.objects.all()
    courses = Course.objects.all()
    semesters = Semester.objects.all()
    context = {
        "titles": "admin_home",
        "students": students,
        "lecturers": lecturers,
        "classes": classes,
        "semesters": semesters,
        "courses": courses,
    }
    return render(request, 'admin_home.html', context)


# Lecturer functions:

def ListLecturer(request):
    lecturer_list = Lecturer.objects.all()
    return render(request, "lecturer_list.html", context={"lecturers": lecturer_list})


def CreateLecturer(request):
    if request.method == 'GET':
        return render(request, 'lecturer_create.html')
    else:
        staff_id = request.POST.get('staff_id')
        dob = str(datetime.date.today())
        username = request.POST.get('username')
        password = "000000"
        first_name = request.POST.get('first_name')
        last_name = request.POST.get('last_name')
        email = request.POST.get('email')
        user = User.objects.create(username=username, password=password, first_name=first_name, last_name=last_name,
                                   email=email)
        Lecturer.objects.create(staff_id=staff_id, DOB=dob, user=user)

        return redirect("/lecturer/list")


def DeleteLecturer(request, pk):
    lecturer = Lecturer.objects.get(id=pk)
    lecturer.user.delete()
    lecturer.delete()
    return redirect('/lecturer/list/')


def UpdateLecturer(request, pk):
    if request.method == "GET":
        lecturer = Lecturer.objects.filter(id=pk).first()
        return render(request, 'lecturer_update.html', {"lecturers": lecturer})
    else:
        staff_id = request.POST.get("staff_id")
        username = request.POST.get("username")
        first_name = request.POST.get("first_name")
        last_name = request.POST.get("last_name")
        email = request.POST.get("email")
        DOB = str(datetime.date.today())
        user = Lecturer.objects.filter(id=pk).first().user
        user.username = username
        user.first_name = first_name
        user.last_name = last_name
        user.email = email
        user.save()
        Lecturer.objects.filter(id=pk).update(DOB=DOB, staff_id=staff_id, user=user)
        return redirect("/lecturer/list/")


# Student functions:

def ListStudent(request):
    student_list = Student.objects.all()
    return render(request, "student_list.html", context={"students": student_list})


def CreateStudent(request):
    if request.method == 'GET':
        return render(request, 'student_create.html')
    else:
        student_id = request.POST.get('student_id')
        dob = str(datetime.date.today())
        username = request.POST.get('username')
        password = "000000"
        first_name = request.POST.get('first_name')
        last_name = request.POST.get('last_name')
        email = request.POST.get('email')
        user = User.objects.create(username=username, password=password, first_name=first_name, last_name=last_name,
                                   email=email)
        Student.objects.create(student_id=student_id, DOB=dob, user=user)

        return redirect("/student/list")


def DeleteStudent(request, pk):
    student = Student.objects.get(id=pk)
    student.user.delete()
    student.delete()
    return redirect('/student/list/')


def UpdateStudent(request, pk):
    if request.method == "GET":
        student = Student.objects.filter(id=pk).first()
        return render(request, 'student_update.html', {"students": student})
    else:
        student_id = request.POST.get("student_id")
        username = request.POST.get("username")
        first_name = request.POST.get("first_name")
        last_name = request.POST.get("last_name")
        email = request.POST.get("email")
        DOB = str(datetime.date.today())
        user = Student.objects.filter(id=pk).first().user
        user.username = username
        user.first_name = first_name
        user.last_name = last_name
        user.email = email
        user.save()
        Student.objects.filter(id=pk).update(DOB=DOB, student_id=student_id, user=user)
        return redirect("/student/list/")


# Semester functions:

class listSemester(ListView):
    model = Semester
    template_name = "semester_list.html"


class createSemester(CreateView):
    model = Semester
    template_name = "semester_create.html"
    form_class = CreateSemesterForm
    success_url = reverse_lazy("semester_list")


class updateSemester(UpdateView):
    model = Semester
    template_name = "semester_update.html"
    form_class = UpdateSemesterForm
    success_url = reverse_lazy("semester_list")


class deleteSemester(DeleteView):
    model = Semester
    template_name = "semester_delete.html"
    success_url = reverse_lazy("semester_list")


# Class functions:

class listClass(ListView):
    model = Class
    template_name = "class_list.html"


class createClass(CreateView):
    model = Class
    template_name = "class_create.html"
    form_class = CreateClassForm
    success_url = reverse_lazy("class_list")


class updateClass(UpdateView):
    model = Class
    template_name = "class_update.html"
    form_class = UpdateClassForm
    success_url = reverse_lazy("class_list")


class deleteClass(DeleteView):
    model = Class
    template_name = "class_delete.html"
    success_url = reverse_lazy("class_list")


# Course functions:

class listCourse(ListView):
    model = Course
    template_name = "course_list.html"


class createCourse(CreateView):
    model = Course
    template_name = "course_create.html"
    form_class = CreateCourseForm
    success_url = reverse_lazy("course_list")


class updateCourse(UpdateView):
    model = Course
    template_name = "course_update.html"
    form_class = UpdateCourseForm
    success_url = reverse_lazy("course_list")


class deleteCourse(DeleteView):
    model = Course
    template_name = "course_delete.html"
    success_url = reverse_lazy("course_list")


# CollegeDay functions:
class listCollegeDay(ListView):
    model = CollegeDay
    template_name = "college_day_list.html"


class createCollegeDay(CreateView):
    model = CollegeDay
    template_name = "college_day_create.html"
    form_class = CreateCollegeDayForm
    success_url = reverse_lazy("college_day_list")


class updateCollegeDay(UpdateView):
    model = CollegeDay
    template_name = "college_day_update.html"
    form_class = UpdateCollegeDayForm
    success_url = reverse_lazy("college_day_list")


class deleteCollegeDay(DeleteView):
    model = CollegeDay
    template_name = "college_day_delete.html"
    success_url = reverse_lazy("college_day_list")


# assign_lecturer
def AssignLecturerToClass(request, class_id):
    select_class = Class.objects.get(id=class_id)
    lecturers = Lecturer.objects.all()
    return render(request, 'assign_lecturer.html', {'lecturers': lecturers, "class": select_class})


def Assign(request, class_id):
    lecturer_id = request.POST["lecturer"]

    lecturer = Lecturer.objects.get(id=lecturer_id)

    select_class = Class.objects.get(id=class_id)
    select_class.lecturer = lecturer
    select_class.save()

    return HttpResponseRedirect(reverse('class_list'))


# enrol students
def EnrolStudentToClass(request, class_id):
    select_class = Class.objects.get(id=class_id)
    students = Student.objects.all()
    return render(request, 'enrol_student.html', {'students': students, "class": select_class})


def Enrol(request, class_id):
    student_id = request.POST["student"]

    student = Student.objects.get(id=student_id)

    select_class = Class.objects.get(id=class_id)
    select_class.student.add(student)
    select_class.save()

    return HttpResponseRedirect(reverse('class_list'))


def SendEmail(request):
    users = User.objects.all()
    if request.method == "POST":
        subject = request.POST.get("subject")
        body = request.POST.get("body")
        receiver = User.objects.get(id=request.POST.get("user"))
        senderEmail = "gabriel_sl19798@hotmail.com"
        try:
            send_mail(subject, body, senderEmail, [receiver.email],
                      fail_silently=False)
            return render(request, "send_email.html", {
                "message": "email has been sent out",
                "users": users
            })
        except:
            return render(request, "send_email.html", {
                "message": "email sending failed",
                "users": users
            })
    return render(request, "send_email.html", {
        "message": "",
        "users": users

    })


def UploadFile(request):
    if request.method == "POST" and request.FILES["myfile"]:
        myfile = request.FILES["myfile"]
        fs = FileSystemStorage()
        filename = fs.save(myfile.name, myfile)
        upload_file_url = fs.url(filename)
        excel_data = pd.read_excel(myfile)
        data = pd.DataFrame(excel_data)
        usernames = data["Username"].tolist()
        firstnames = data["First Name"].tolist()
        lastnames = data["Last Name"].tolist()
        emails = data["Email"].tolist()
        dobs = data["DOB"].tolist()
        i = 0
        while i < len(usernames):
            username = usernames[i]
            firstname = firstnames[i]
            lastname = lastnames[i]
            email = emails[i]
            dob = str(dobs[i]).split(" ")[0].replace("-", "")
            user = User.objects.create_user(username=username)
            user.first_name = firstname
            user.last_name = lastname
            user.email = email
            user.set_password(dob)
            user.groups.add(1)
            user.save()
            i = i + 1
        return render(request, 'upload_file.html', {
            "upload_file_url": upload_file_url
        })
    return render(request, 'upload_file.html')


def student_home(request):
    class_list = Class.objects.all()
    return render(request, "student_home.html", context={"classes": class_list})


def lecturer_home(request):
    class_list = Class.objects.all()
    return render(request, "lecturer_home.html", context={"classes": class_list})
