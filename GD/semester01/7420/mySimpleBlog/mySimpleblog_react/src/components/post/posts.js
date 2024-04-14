import React, {useState, useEffect, Fragment} from 'react';
import axios from "axios";
import {BaseUrl} from "../constants";
import AuthorName from "../authorName";
import {Link} from "react-router-dom";
import Category from "../category/category";


function Posts(props) {
    const [posts, setPosts] = useState([]);
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
        axios.get(BaseUrl + '/post/post_viewSet/')
            .then((response) => {
                setPosts(response.data);
            })
            .catch((error) => {
                console.log(error);
            })
    }, [posts]);


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


    function deletePost(event) {
        let post_id = event.target.value
        axios.delete(BaseUrl + '/post/post_viewSet/'+post_id)
            .then(response => {
                alert("post deleted successfully")
            })
            .catch(error=>{
            console.log(error)
        })
    }

    return (
        <div>
            {hasToken ? <Link to={"/createPost"} className={"btn btn-success"}>Create a post</Link>
                :
                " "}
            {posts.map(post =>
                <p key={post.id}>

                    <Link to={"/postDetail"} state={{post_id: post.id}}>{post.title}</Link>
                    -
                    <AuthorName authorID={post.author}/> -
                    {post.body}-
                    {post.category}
                    {userID == post.author ?
                        <Fragment>
                            <Link to={"/UpdatePost"} state={{post_id: post.id}}
                                  className={"btn btn-primary"}>Update</Link>
                            <button onClick={deletePost} value={post.id} className={"btn btn-warning"}>Delete</button>
                        </Fragment>
                        :
                        ""}
                </p>)}
        </div>
    );
}

export default Posts;
