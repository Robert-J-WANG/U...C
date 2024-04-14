import React from 'react';
import {Link, useLocation, useNavigate} from "react-router-dom";
import axios from "axios";
import {BaseURL} from "../components/constants";

function DeleteLecturer(props) {
    const location = useLocation()
    const navigate = useNavigate()
    const { ID } = location.state

    const deleteLecturer = () => {
        if(localStorage.getItem('token')) {
            axios.delete(BaseURL+'lecturer/'+ID+'/', {
                headers: {
                Authorization: "Token "+localStorage.getItem("token")
                }
            }).then((response) => {
                navigate('/lecturers')
            }).catch((err) => {
                console.log(err)
                alert('Lecturer could not be deleted!')
            })
        } else {
            navigate('/login')
            alert('Please sign in to create lecturer!')
        }
    }

    return (
        <div className={'container'}>
            <h1 className={'display-6'} style={{margin: "30px"}}>Delete Lecturer</h1>
            <h3>Are you Sure you want to Delete?</h3>
            <Link to={'/lecturers'} className={'btn btn-success'}>No</Link>
            <button onClick={deleteLecturer} className={'btn btn-danger'} type="submit">Yes</button>
        </div>
    );
}

export default DeleteLecturer;
