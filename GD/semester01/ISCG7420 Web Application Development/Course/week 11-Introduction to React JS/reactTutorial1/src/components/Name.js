import React, {Component} from "react";

class Name extends Component {

    constructor() {
        super();
        this.state = {
            name: "Lei Song"
        }
    }

    clickMe = () =>{
        this.setState(
            {
                // name:"Gerard Lovell"
                name:this.state.name === "Lei Song" ? "Gerard Lovell" : "Lei Song"
            }
        )
    }

    render() {
        return (
            <div>
                <h1 className="bg-primary text-white text-center">{this.state.name}</h1>
                <button onClick={this.clickMe} className="btn btn-success">Change name</button>
            </div>
        )
    }
}

export default Name;