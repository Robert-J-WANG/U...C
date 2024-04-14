import React from 'react';
import {Link, useNavigate} from "react-router-dom";
import {useEffect, useReducer, useState} from "react";
import axios from "axios";
import {BaseURL} from "../components/constants";

const initialState = {
    loading: false,
    collegeDays: {},
    error: ''
}

const reducer = (state, action) => {
    switch (action.type) {
        case 'success':
            return {
                loading: true,
                collegeDays: action.payload,
                error: ''
            }
        case 'error':
            return {
                loading: true,
                collegeDays: [],
                error: "Error when fetching data!"
            }
    }
}

function ListCollegeDays(props) {
    const [state, dispatch] = useReducer(reducer, initialState)
    const [token, setToken] = useState('')
    const navigate = useNavigate()

    useEffect(() => {
        if (localStorage.getItem("token")){
            setToken(localStorage.getItem("token"))
            axios.get(BaseURL +'collegeDay/', {
                headers: {
                    Authorization: "Token "+localStorage.getItem("token")
                }
            }).then(response => {
                dispatch({type: 'success', payload: response.data});
            }).catch(error => {
                dispatch({type: 'error'});
                console.log(error);
            })
        } else {
            setToken('')
            navigate('/login')
            alert('Please sign in to see collegeDays!')
        }
    }, [token]);

    return (
        <div className={'container'}>
            <h1 className={'display-6'} style={{margin:"30px"}}>College Days</h1>
            <table className={'table table-bordered'}>
                <thead>
                    <tr>
                        <th scope={'col'}>Date</th>
                        <th><Link to={'create'} className={'btn btn-primary'} style={{float: "right", width: "170px"}}>Create</Link></th>
                    </tr>
                </thead>
                <tbody>
                {
                    state.loading ? state.collegeDays.map(collegeDay => {
                        return(
                        <tr>
                            <td>{collegeDay.date}</td>
                            <td>
                                <Link to={'delete'} state={{ collegeDayID: collegeDay.id }} className={'btn btn-danger'} style={{float: "right"}}>Delete</Link>
                                <Link to={'update'} state={{ collegeDayID: collegeDay.id, collegeDayDate: collegeDay.date}} className={'btn btn-success'} style={{float: "right", marginRight: "20px"}}>Update</Link>
                            </td>
                        </tr>
                        )
                    }) : 'Loading...'
                }
                </tbody>
            </table>
        </div>
    );
}

export default ListCollegeDays;
