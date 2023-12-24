import React from 'react';
import {Link, useNavigate} from "react-router-dom";
import axios from "axios";
import {useState} from "react";
import {BaseURL} from "../components/constants";

function CreateCollegeDay(props) {
    const navigate = useNavigate()
    const [date, setDate] = useState('');

    const dateHandler = e => {
        setDate(e.target.value)
    }
    const createCollegeDay = () => {
        if(localStorage.getItem('token')) {
            const data = {
                'date': date,
            }
            axios.post(BaseURL+'collegeDay/', data, {
                headers: {
                    Authorization: "Token "+localStorage.getItem("token")
                }
            }).then((response) => {
                navigate('/collegeDay')
            }).catch((err) => {
                console.log(err)
                alert('collegeDay could not be created!')
            })
        } else {
            alert('Please sign in to create collegeDay!')
            navigate('/login')
        }
    }

    return (
        <div className={'container'}>
            <h1 className={'display-6'} style={{margin: "30px"}}>Create College Day</h1>
            <div className="mb-3">
                <label htmlFor="date" className="form-label">Date</label>
                <input id={'date'} onChange={dateHandler} type={'date'} className={'form-control'} />
            </div>
            <button onClick={createCollegeDay} className={'btn btn-primary'} type={'submit'}>Create</button>
            <Link to={'/collegeDay'} className={'btn btn-danger'}>Back</Link>
        </div>
    );
}

export default CreateCollegeDay;
