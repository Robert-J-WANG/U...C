import React from 'react';
import {Link, useLocation, useNavigate} from "react-router-dom";
import axios from "axios";
import {BaseURL} from "../components/constants";

function DeleteStudent(props) {
    const location = useLocation()
    const navigate = useNavigate()
    const { studentID } = location.state

    const deleteStudent = () => {
        if(localStorage.getItem('token')) {
            axios.delete(BaseURL+'student/'+studentID+'/', {
                headers: {
                Authorization: "Token "+localStorage.getItem("token")
                }
            }).then((response) => {
                navigate('/students')
            }).catch((err) => {
                console.log(err)
                alert('Student could not be deleted!')
            })
        } else {
            navigate('/login')
            alert('Please sign in to create student!')
        }
    }

    return (
        <div className={'container'}>
            <h1 className={'display-6'} style={{margin: "30px"}}>Delete Student</h1>
            <h3>Are you Sure you want to Delete?</h3>
            <Link to={'/students'} className={'btn btn-success'}>No</Link>
            <button onClick={deleteStudent} className={'btn btn-danger'} type="submit">Yes</button>
        </div>
    );
}

export default DeleteStudent;
