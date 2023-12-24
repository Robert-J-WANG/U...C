import React from 'react';
import {Link, useLocation, useNavigate} from "react-router-dom";
import axios from "axios";
import {BaseURL} from "../components/constants";

function DeleteSemester(props) {
    const location = useLocation()
    const navigate = useNavigate()
    const { semesterID } = location.state

    const deleteSemester = () => {
        if(localStorage.getItem('token')) {
            axios.delete(BaseURL+'semester/'+semesterID+'/', {
                headers: {
                Authorization: "Token "+localStorage.getItem("token")
                }
            }).then((response) => {
                console.log(response)
                navigate('/semesters')
            }).catch((err) => {
                console.log(err)
                alert('Semester could not be deleted!')
            })
        } else {
            navigate('/login')
            alert('Please sign in to create semester!')
        }
    }

    return (
        <div className={'container'}>
            <h1 className={'display-6'} style={{margin: "30px"}}>Delete Semester</h1>
            <h3>Are you Sure you want to Delete?</h3>
            <Link to={'/semesters'} className={'btn btn-success'}>No</Link>
            <button onClick={deleteSemester} className={'btn btn-danger'} type="submit">Yes</button>
        </div>
    );
}

export default DeleteSemester;
