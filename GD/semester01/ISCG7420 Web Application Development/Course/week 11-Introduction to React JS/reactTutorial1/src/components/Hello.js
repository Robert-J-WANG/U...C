import React from "react";

function Hello(props) {

    function clickMe(){
        alert("clicked");
    }

    return (
        <div>
            <h1>{props.firstname} {props.lastname}</h1>
            <button className="btn btn-primary" onClick={clickMe}>Click me</button>
        </div>
    )
}

export default Hello