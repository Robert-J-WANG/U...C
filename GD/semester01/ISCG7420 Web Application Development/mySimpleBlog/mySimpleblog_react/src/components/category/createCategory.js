// import React, {useEffect, useState} from 'react';
// import Category from "./category";
// import axios from "axios";
// import {BaseUrl} from "../constants";
//
//
// function CreateCategory(props) {
//     const [token, setToken] = useState("")
//     const [hasToken, setHasToken] = useState(false)
//
//     useEffect(() => {
//         if (localStorage.getItem("token")) {
//             setToken(localStorage.getItem("token"));
//             setHasToken(true);
//         }
//     }, [])
//
//
//     function createCategory() {
//
//         let login_token = localStorage.getItem("token");
//         let data = {
//             name: document.getElementById("name").value
//         };
//         axios.post(BaseUrl + "/post/category/", data, {
//             headers: {
//                 "Authorization": "Token " + login_token,
//             }
//         }).then(response => {
//             alert("Create category successfully")
//         }).catch(error => {
//             console.error(error)
//         })
//     }
//
//     return (
//         <div>
//             <p>Name:<input type={"text"} id={"name"}/></p>
//
//             <button onClick={createCategory} className={"btn btn-success"}>Create</button>
//         </div>
//     );
// }
//
// export default CreateCategory;
