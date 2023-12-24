import React from 'react';
import {Link, useLocation, useNavigate} from "react-router-dom";
import axios from "axios";
import {BaseURL} from "../components/constants";

function DeleteCourse(props) {
    const location = useLocation()
    const navigate = useNavigate()
    const { courseID } = location.state

    const deleteCourse = () => {
        if(localStorage.getItem('token')) {
            axios.delete(BaseURL+'course/'+courseID+'/', {
                headers: {
                Authorization: "Token "+localStorage.getItem("token")
                }
            }).then((response) => {
                navigate('/courses')
            }).catch((err) => {
                console.log(err)
                alert('Course could not be deleted!')
            })
        } else {
            navigate('/login')
            alert('Please sign in to create course!')
        }
    }

    return (
        <div className={'container'}>
            <h1 className={'display-6'} style={{margin: "30px"}}>Delete Course</h1>
            <h3>Are you Sure you want to Delete?</h3>
            <Link to={'/courses'} className={'btn btn-success'}>No</Link>
            <button onClick={deleteCourse} className={'btn btn-danger'} type="submit">Yes</button>
        </div>
    );
}

export default DeleteCourse;
