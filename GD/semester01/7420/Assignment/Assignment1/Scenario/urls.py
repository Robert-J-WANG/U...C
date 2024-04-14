from django.urls import path

from Scenario import views
from Scenario.views import index, admin_home, \
    listSemester, createSemester, \
    updateSemester, deleteSemester, listClass, createClass, updateClass, deleteClass, listCourse, createCourse, \
    updateCourse, deleteCourse, listCollegeDay, createCollegeDay, updateCollegeDay, deleteCollegeDay, \
    CreateLecturer, ListLecturer, DeleteLecturer, \
    UpdateLecturer, ListStudent, DeleteStudent, UpdateStudent, CreateStudent, AssignLecturerToClass, Assign, Enrol, \
    EnrolStudentToClass, SendEmail, UploadFile, login_user, logout_user, student_home, lecturer_home


urlpatterns = [
    path("", login_user, name="login_user"),
    path("logout_user/", logout_user, name="logout_user"),
    path("", index, name="index"),
    path("admin_home/", admin_home, name="admin_home"),

    path("lecturer/list/", ListLecturer, name="lecturer_list"),
    path('lecturer/<int:pk>/delete/', DeleteLecturer, name="lecturer_delete"),
    path('lecturer/<int:pk>/update/', UpdateLecturer, name="lecturer_update"),
    path('lecturer/create/', CreateLecturer, name="lecturer_create"),

    path("student/list/", ListStudent, name="student_list"),
    path('student/<int:pk>/delete/', DeleteStudent, name="student_delete"),
    path('student/<int:pk>/update/', UpdateStudent, name="student_update"),
    path('student/create/', CreateStudent, name="student_create"),

    path('semesters/', listSemester.as_view(), name="semester_list"),
    path('semester/create/', createSemester.as_view(), name="semester_create"),
    path('semester/<int:pk>/update/', updateSemester.as_view(), name="semester_update"),
    path('semester/<int:pk>/delete/', deleteSemester.as_view(), name="semester_delete"),

    path('classs/', listClass.as_view(), name="class_list"),
    path('class/create/', createClass.as_view(), name="class_create"),
    path('class/<int:pk>/update/', updateClass.as_view(), name="class_update"),
    path('class/<int:pk>/delete/', deleteClass.as_view(), name="class_delete"),

    path('courses/', listCourse.as_view(), name="course_list"),
    path('course/create/', createCourse.as_view(), name="course_create"),
    path('course/<int:pk>/update/', updateCourse.as_view(), name="course_update"),
    path('course/<int:pk>/delete/', deleteCourse.as_view(), name="course_delete"),

    path('college_days/', listCollegeDay.as_view(), name="college_day_list"),
    path('college_day/create/', createCollegeDay.as_view(), name="college_day_create"),
    path('college_day/<int:pk>/update/', updateCollegeDay.as_view(), name="college_day_update"),
    path('college_day/<int:pk>/delete/', deleteCollegeDay.as_view(), name="college_day_delete"),

    path('class/<int:class_id>/assign/', Assign, name="assign"),
    path('class/assign_lecturer/<int:class_id>', AssignLecturerToClass, name="assign_lecturer"),

    path('class/<int:class_id>/enrol/', Enrol, name="enrol"),
    path('class/enrol_student/<int:class_id>', EnrolStudentToClass, name="enrol_student"),
    path('send_email/', SendEmail, name="send_email"),
    path("upload_file", UploadFile, name="upload_file"),

    path("student_home/", student_home, name="student_home"),
    path("lecturer_home/", lecturer_home, name="lecturer_home"),
]
