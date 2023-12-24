import React, {Fragment, useEffect, useState} from 'react';
import axios from "axios";
import {BaseUrl} from "../constants";
import {Link} from "react-router-dom";

function Category(props) {
    const [categories, setCategories] = useState([]);

    const [token, setToken] = useState("");
    const [hasToken, setHasToken] = useState(false);
    const [userID, setUserID] = useState(0);
    // if user is logged in, show the create a post button
    useEffect(() => {
        if (localStorage.getItem("token")) {
            setHasToken(true)
            setToken(localStorage.getItem("token"))
        }
    }, [token]);

    useEffect(() => {
        axios.get(BaseUrl + "post/category/")
            .then(response => {
                setCategories(response.data)
            }).catch(error => {
            console.log(error)
        })
    }, []);

    // set permission by userID
    useEffect(() => {
        if (localStorage.getItem("token")) {
            setHasToken(true);
            axios.get(BaseUrl + "post/user_id_search/", {
                headers:
                    {'Authorization': 'Token ' + localStorage.getItem("token")}
            })
                .then(response => {
                    setUserID(response.data.user_id)
                })
                .catch((error) => {
                    console.log(error);
                })
        }
    });


    return (

        <Fragment>
            {userID === 1? <Link to={"/createCategory"} className={"btn btn-success"}>Create a category</Link>
                :
                " "}
            {categories.map(category =>
                <option value={category.id} key={category.id}>{category.name}</option>
                )}
        </Fragment>

    );
}

export default Category;
