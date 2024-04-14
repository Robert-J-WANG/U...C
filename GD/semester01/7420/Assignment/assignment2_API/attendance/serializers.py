from django.contrib.auth.models import User, Group
from rest_framework import serializers
from rest_framework.authtoken.models import Token

from attendance.models import Semester, Course, Lecturer, Student, Class, CollegeDay, Attendance, Enrollment


class CollegeDaySerializer(serializers.ModelSerializer):
    class Meta:
        model = CollegeDay
        fields = "__all__"


class SemesterSerializer(serializers.ModelSerializer):
    class Meta:
        model = Semester
        fields = "__all__"


class CourseSerializer(serializers.ModelSerializer):
    class Meta:
        model = Course
        fields = "__all__"


class LecturerSerializer(serializers.ModelSerializer):
    class Meta:
        model = Lecturer
        fields = ['id', 'firstName', 'lastName', 'email', 'course', 'dateOfBirth']

    def create(self, validated_data):
        lecturer = Lecturer.objects.create(**validated_data)
        first_name = self.validated_data.get("firstName")
        last_name = self.validated_data.get("lastName")
        email = self.validated_data.get("email")

        try:
            user = User.objects.create_user(username=first_name.lower())
            user.set_password(first_name.lower())
            user.first_name = first_name
            user.last_name = last_name
            user.email = email

            lecturer_group = Group.objects.get(name='lecturer')
            user.groups.add(lecturer_group)

            lecturer.user = user
            lecturer.save()
            Token.objects.create(user=user)
            user.save()
        except Exception as e:
            print(e)

        return lecturer


class StudentSerializer(serializers.ModelSerializer):
    class Meta:
        model = Student
        fields = ['id', 'firstName', 'lastName', 'email', 'dateOfBirth']

    def create(self, validated_data):
        student = Student.objects.create(**validated_data)
        first_name = self.validated_data.get("firstName")
        last_name = self.validated_data.get("lastName")
        email = self.validated_data.get("email")

        try:
            user = User.objects.create_user(username=first_name.lower())
            user.set_password(first_name.lower())
            user.first_name = first_name
            user.last_name = last_name
            user.email = email
            student_group = Group.objects.get(name='student')
            user.groups.add(student_group)

            Token.objects.create(user=user)
            student.user = user
            student.save()
            user.save()
        except Exception as e:
            print(e)

        return student


class ClassSerializer(serializers.ModelSerializer):
    class Meta:
        model = Class
        fields = "__all__"


class AttendanceSerializer(serializers.ModelSerializer):
    class Meta:
        model = Attendance
        fields = "__all__"


class EnrollmentSerializer(serializers.ModelSerializer):
    class Meta:
        model = Enrollment
        fields = '__all__'
