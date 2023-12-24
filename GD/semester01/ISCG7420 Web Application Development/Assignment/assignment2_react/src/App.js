import './App.css';
import {Routes, Route, useNavigate, NavLink} from "react-router-dom";
import {useState} from "react";
import Home from "./components/home";
import ListSemesters from "./semester/list_semesters";
import CreateSemester from "./semester/create_semester";
import UpdateSemester from "./semester/update_semester";
import DeleteSemester from "./semester/delete_semester";
import Login from "./components/login";
import ListClasses from "./class/list_classes";
import CreateClass from "./class/create_class";
import UpdateClass from "./class/update_class";
import DeleteClass from "./class/delete_class";
import AssignLecturer from "./class/assign_lecturer";
import ListCourses from "./course/list_courses";
import CreateCourse from "./course/create_course";
import UpdateCourse from "./course/update_course";
import DeleteCourse from "./course/delete_course";
import ListLecturers from "./lecturer/list_lecturers";
import CreateLecturer from "./lecturer/create_lecturer";
import UpdateLecturer from "./lecturer/update_lecturer";
import DeleteLecturer from "./lecturer/delete_lecturer";
import ListStudents from "./student/list_students";
import CreateStudent from "./student/create_student";
import UpdateStudent from "./student/update_student";
import DeleteStudent from "./student/delete_student";
import UploadStudent from "./student/upload_student";
import SemestersAttendance from "./attendance/semesters_attendance";
import ClassesAttendance from "./attendance/classes_attendance";
import StudentListAttendance from "./attendance/student_list_attendance";
import ListStudentEnrolment from "./enrollment/list_student_enrolment";
import EnrolStudent from "./enrollment/enrol_student";
import RemoveStudentEnrolment from "./enrollment/remove_student_enrolment";
import CollegeDays from "./collegeDay/list_collegeDays";
import CreateCollegeDay from "./collegeDay/create_collegeDay";
import UpdateCollegeDay from "./collegeDay/update_collegeDay";
import DeleteCollegeDay from "./collegeDay/delete_collegeDay";

function App() {
  const username = localStorage.getItem("username")
  const navigate = useNavigate()
  const [isLoggedIn, setIsLoggedIn] = useState(false)

  const logout = () => {
    localStorage.removeItem("token")
    localStorage.removeItem("username")
    localStorage.removeItem("userGroup")
    setIsLoggedIn(false)
    navigate('/')
  }

  return (
    <div className="App">
      <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
        <div className={'container-fluid'}>
          <NavLink to={"/"} className={'navbar-brand'}>Home</NavLink>
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            {
              (() => {
                if(localStorage.getItem("token") && username === 'admin') {
                  return(<div style={{display: "flex"}}>

                        <li className={'nav-item'}>
                        <NavLink to={'collegeDay'} className={'nav-link'} aria-current={'page'}>CollegeDay</NavLink>
                      </li>
                      <li className={'nav-item'}>
                        <NavLink to={'attendance'} className={'nav-link'} aria-current={'page'}>Attendance</NavLink>
                      </li>
                      <li className={'nav-item'}>
                        <NavLink to={'semester'} className={'nav-link'} aria-current={'page'}>Semesters</NavLink>
                      </li>
                      <li className={'nav-item'}>
                        <NavLink to={'course'} className={'nav-link'} aria-current={'page'}>Courses</NavLink>
                      </li>
                      <li className={'nav-item'}>
                        <NavLink to={'lecturer'} className={'nav-link'} aria-current={'page'}>Lecturers</NavLink>
                      </li>
                      <li className={'nav-item'}>
                        <NavLink to={'student'} className={'nav-link'} aria-current={'page'}>Students</NavLink>
                      </li>
                      <li className={'nav-item'}>
                        <NavLink to={'class'} className={'nav-link'} aria-current={'page'}>Classes</NavLink>
                      </li></div>
                  )
                } else if (localStorage.getItem("token") && username !== 'admin') {
                  return (
                      <li className={'nav-item'}>
                        <NavLink to={'attendance'} className={'nav-link'} aria-current={'page'}>Attendance</NavLink>
                      </li>
                  )
                } else if (!localStorage.getItem("token")) {

                }
              })()
            }
            </ul>
            <ul className={'navbar-nav ml-auto'}>
              {
                localStorage.getItem("token") ? <div style={{display: "flex"}}><li className="nav-item">
                      <div className={'nav-link'}>{username} -</div>
                    </li>
                    <li className={'nav-item'}>
                      <button className={'nav-link btn btn-danger'} style={{color: "white"}} aria-current={"page"} onClick={logout}>Logout</button>
                    </li></div> : <li className={'nav-item'}>
                <NavLink to={'login'} className={'nav-link btn btn-success'} style={{color: "white"}} aria-current={'page'}>Login</NavLink>
              </li>
              }
            </ul>
        </div>
      </nav>
      <Routes>
        <Route path={'/'} element={<Home />}></Route>
        <Route path={'login'} element={<Login isLoggedIn={isLoggedIn} setIsLoggedIn={setIsLoggedIn} />}></Route>

        <Route path={'collegeDay'} element={<CollegeDays />}></Route>
        <Route path={'collegeDay/create'} element={<CreateCollegeDay />}></Route>
        <Route path={'collegeDay/update'} element={<UpdateCollegeDay />}></Route>
        <Route path={'collegeDay/delete'} element={<DeleteCollegeDay />}></Route>

        <Route path={'semester'} element={<ListSemesters />}></Route>
        <Route path={'semester/create'} element={<CreateSemester />}></Route>
        <Route path={'semester/update'} element={<UpdateSemester />}></Route>
        <Route path={'semester/delete'} element={<DeleteSemester />}></Route>

        <Route path={'course'} element={<ListCourses />}></Route>
        <Route path={'course/create'} element={<CreateCourse />}></Route>
        <Route path={'course/update'} element={<UpdateCourse />}></Route>
        <Route path={'course/delete'} element={<DeleteCourse />}></Route>

        <Route path={'lecturer'} element={<ListLecturers />}></Route>
        <Route path={'lecturer/create'} element={<CreateLecturer />}></Route>
        <Route path={'lecturer/update'} element={<UpdateLecturer />}></Route>
        <Route path={'lecturer/delete'} element={<DeleteLecturer />}></Route>

        <Route path={'student'} element={<ListStudents />}></Route>
        <Route path={'student/create'} element={<CreateStudent />}></Route>
        <Route path={'student/update'} element={<UpdateStudent />}></Route>
        <Route path={'student/delete'} element={<DeleteStudent />}></Route>
        <Route path={'student/upload'} element={<UploadStudent />}></Route>
        <Route path={'student/enrolments'} element={<ListStudentEnrolment />}></Route>
        <Route path={'student/enrolments/enrol'} element={<EnrolStudent />}></Route>
        <Route path={'student/enrolments/remove'} element={<RemoveStudentEnrolment />}></Route>

        <Route path={'class'} element={<ListClasses />}></Route>
        <Route path={'class/create'} element={<CreateClass />}></Route>
        <Route path={'class/update'} element={<UpdateClass />}></Route>
        <Route path={'class/delete'} element={<DeleteClass />}></Route>
        <Route path={'class/assign_lecturer'} element={<AssignLecturer />}></Route>

        <Route path={'attendance'} element={<SemestersAttendance />}></Route>
        <Route path={'attendance/class'} element={<ClassesAttendance />}></Route>
        <Route path={'attendance/student'} element={<StudentListAttendance />}></Route>
      </Routes>
    </div>
  );
}

export default App;
