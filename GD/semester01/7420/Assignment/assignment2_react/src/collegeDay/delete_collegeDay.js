import React from 'react';
import {Link, useLocation, useNavigate} from "react-router-dom";
import axios from "axios";
import {BaseURL} from "../components/constants";

function DeleteCollegeDay(props) {
    const location = useLocation()
    const navigate = useNavigate()
    const { collegeDayID } = location.state

    const deleteCollegeDay = () => {
        if(localStorage.getItem('token')) {
            axios.delete(BaseURL+'collegeDay/'+collegeDayID+'/', {
                headers: {
                Authorization: "Token "+localStorage.getItem("token")
                }
            }).then((response) => {
                navigate('/collegeDay')
            }).catch((err) => {
                console.log(err)
                alert('collegeDay could not be deleted!')
            })
        } else {
            navigate('/login')
            alert('Please sign in to create collegeDay!')
        }
    }

    return (
        <div className={'container'}>
            <h1 className={'display-6'} style={{margin: "30px"}}>Delete College Day</h1>
            <h3 style={{marginBottom: "30px"}}>Are you Sure you want to Delete?</h3>
            <Link to={'/collegeDay'} className={'btn btn-success'}>No</Link>
            <button onClick={deleteCollegeDay} className={'btn btn-danger'} type="submit">Yes</button>
        </div>
    );
}

export default DeleteCollegeDay;
