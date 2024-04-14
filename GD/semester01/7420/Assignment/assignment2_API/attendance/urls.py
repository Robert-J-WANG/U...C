from django.urls import path, include
from rest_framework.routers import DefaultRouter

from attendance.views import EnrolmentViewSet, StudentViewSet, AttendanceViewSet, CollegeDayViewSet, ClassViewSet, \
    LecturerViewSet, CourseViewSet, SemesterViewSet

router = DefaultRouter()

router.register('collegeDay', CollegeDayViewSet, 'collegeDay_viewSet')
router.register('semester', SemesterViewSet, 'semester_model_viewset')
router.register('course', CourseViewSet, 'course_model_viewset')
router.register('lecturer', LecturerViewSet, 'lecturer_model_viewset')
router.register('student', StudentViewSet, 'student_model_viewset')
router.register('class', ClassViewSet, 'class_model_viewset')

router.register('attendance', AttendanceViewSet, 'attendance_model_viewset')
router.register('enrolment', EnrolmentViewSet, 'enrolment')

urlpatterns = [
    path('api-auth/', include('rest_framework.urls')),
]
urlpatterns += router.urls
