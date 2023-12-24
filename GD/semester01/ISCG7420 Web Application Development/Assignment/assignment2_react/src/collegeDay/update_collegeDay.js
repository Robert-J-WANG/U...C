import {Link, useLocation, useNavigate} from "react-router-dom";
import {useState} from "react";
import axios from "axios";
import React from "react";
import {BaseURL} from "../components/constants";

function UpdateCollegeDay(props) {
    const location = useLocation()
    const { collegeDayID, collegeDayDate } = location.state

    const navigate = useNavigate()
    const [date, setDate] = useState(collegeDayDate.toString());

    const dateHandler = e => {
        setDate(e.target.value)
    }


    const updateCollegeDay = () => {
        if(localStorage.getItem('token')) {
            const data = {
                'date': date,

            }
            axios.put(BaseURL+'collegeDay/'+collegeDayID+'/', data, {
                headers: {
                    Authorization: "Token "+localStorage.getItem("token")
                }
            }).then((response) => {
                navigate('/collegeDay')
            }).catch((err) => {
                console.log(err)
                alert('collegeDay could not be updated!')
            })
        } else {
            navigate('/login')
            alert('Please sign in to create collegeDay!')
        }
    }

    return (
        <div className={'container'}>
            <h1 className={'display-6'} style={{margin: "30px"}}>Update College Day</h1>
            <div className="mb-3">
                <label htmlFor="date" className="form-label">Date</label>
                <input id={'name'} onChange={dateHandler} type={'date'} className={'form-control'} defaultValue={collegeDayDate} />
            </div>
            <button onClick={updateCollegeDay} className={'btn btn-primary'} type={'submit'}>Update</button>
            <Link to={'/collegeDay'} className={'btn btn-danger'}>Back</Link>
        </div>
    );
}
export default UpdateCollegeDay;
