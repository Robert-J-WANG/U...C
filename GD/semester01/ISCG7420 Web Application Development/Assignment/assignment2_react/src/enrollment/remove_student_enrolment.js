import React from 'react';
import {Link, useLocation, useNavigate} from "react-router-dom";
import axios from "axios";
import {BaseURL} from "../components/constants";

function RemoveStudentEnrolment(props) {
    const location = useLocation()
    const navigate = useNavigate()
    const { enrolmentID } = location.state

    const deleteCourse = () => {
        if(localStorage.getItem('token')) {
            axios.delete(BaseURL+'student_enrolment/'+enrolmentID+'/', {
                headers: {
                    Authorization: "Token "+localStorage.getItem("token")
                }
            }).then((response) => {
                navigate('/students/enrolments')
            }).catch((err) => {
                console.log(err)
                alert('Enrolment could not be removed!')
            })
        } else {
            navigate('/login')
            alert('Please sign in to remove enrollment!')
        }
    }

    return (
        <div className={'container'}>
            <h1 className={'display-6'} style={{margin: "30px"}}>Remove Enrolment</h1>
            <h3>Are you Sure you want to Delete?</h3>
            <Link to={'/students/enrolments'} className={'btn btn-success'}>No</Link>
            <button onClick={deleteCourse} className={'btn btn-danger'} type="submit">Yes</button>
        </div>
    );
}

export default RemoveStudentEnrolment;
