from django.contrib.auth.models import User
from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.
from rest_framework import viewsets, status
from rest_framework.authentication import TokenAuthentication
from rest_framework.permissions import IsAuthenticated
from rest_framework.response import Response

from attendance.models import CollegeDay, Class, Student, Lecturer, Course, Semester, Attendance, Enrollment
from attendance.serializers import CollegeDaySerializer, ClassSerializer, StudentSerializer, LecturerSerializer, \
    CourseSerializer, SemesterSerializer, AttendanceSerializer, EnrollmentSerializer


class CollegeDayViewSet(viewsets.ModelViewSet):
    queryset = CollegeDay.objects.all()
    serializer_class = CollegeDaySerializer
    authentication_classes = (TokenAuthentication,)
    permission_classes = [IsAuthenticated]


class SemesterViewSet(viewsets.ModelViewSet):
    queryset = Semester.objects.all()
    serializer_class = SemesterSerializer
    authentication_classes = (TokenAuthentication,)
    permission_classes = [IsAuthenticated]


class CourseViewSet(viewsets.ModelViewSet):
    queryset = Course.objects.all()
    serializer_class = CourseSerializer
    authentication_classes = (TokenAuthentication,)
    permission_classes = [IsAuthenticated]


class LecturerViewSet(viewsets.ModelViewSet):
    queryset = Lecturer.objects.all()
    serializer_class = LecturerSerializer
    authentication_classes = (TokenAuthentication,)
    permission_classes = [IsAuthenticated]

    def destroy(self, request, *args, **kwargs):
        lecturer = self.get_object()
        username = lecturer.firstname.lower()
        user = User.objects.get(username=username)
        lecturer.delete()
        user.delete()
        return Response(data='Deleted Successfully!')


class StudentViewSet(viewsets.ModelViewSet):
    queryset = Student.objects.all()
    serializer_class = StudentSerializer
    authentication_classes = (TokenAuthentication,)
    permission_classes = [IsAuthenticated]

    def destroy(self, request, *args, **kwargs):
        student = self.get_object()
        student.user.delete()
        student.delete()
        return Response(data='Student Deleted Successfully!')


class ClassViewSet(viewsets.ModelViewSet):
    queryset = Class.objects.all()
    serializer_class = ClassSerializer
    authentication_classes = (TokenAuthentication,)
    permission_classes = [IsAuthenticated]


class AttendanceViewSet(viewsets.ModelViewSet):
    queryset = Attendance.objects.all()
    serializer_class = AttendanceSerializer
    authentication_classes = (TokenAuthentication,)
    permission_classes = [IsAuthenticated]


class EnrolmentViewSet(viewsets.ModelViewSet):
    queryset = Enrollment.objects.all()
    serializer_class = EnrollmentSerializer
    authentication_classes = (TokenAuthentication,)
    permission_classes = [IsAuthenticated]

    def get_queryset(self):
        groups = self.request.user.groups.values_list('name', flat=True)
        if self.request.user.is_superuser:
            enrolments = self.queryset.all()
            return enrolments
        elif 'lecturer' in groups:
            lecturer_queryset = self.queryset.filter(class1__lecturer__user=self.request.user)
            return lecturer_queryset
        elif 'student' in groups:
            student_queryset = self.queryset.filter(student__user=self.request.user)
            return student_queryset
