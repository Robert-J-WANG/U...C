import React from 'react';
import {Link, useLocation, useNavigate} from "react-router-dom";
import axios from "axios";
import {BaseURL} from "../components/constants";

function DeleteClass(props) {
    const location = useLocation()
    const navigate = useNavigate()
    const { classID } = location.state

    const deleteClass = () => {
        if(localStorage.getItem('token')) {
            axios.delete(BaseURL+'class/'+classID+'/', {
                headers: {
                Authorization: "Token "+localStorage.getItem("token")
                }
            }).then((response) => {
                navigate('/classes')
            }).catch((err) => {
                console.log(err)
                alert('Class could not be deleted!')
            })
        } else {
            navigate('/login')
            alert('Please sign in to create class!')
        }
    }

    return (
        <div className={'container'}>
            <h1 className={'display-6'} style={{margin: "30px"}}>Delete Class</h1>
            <h3 style={{margin: "30px"}}>Are you Sure you want to Delete?</h3>
            <Link to={'/classes'} className={'btn btn-success'}>No</Link>
            <button onClick={deleteClass} className={'btn btn-danger'} type="submit">Yes</button>
        </div>
    );
}

export default DeleteClass;
