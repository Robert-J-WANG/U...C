import React, {Component} from "react";

class MyClass extends Component {

    // clicked(){
    //     alert('class component button clicked')
    // }
    render() {
        return (
            <div>
                <h1>This is class component</h1>
                <h2>{this.props.firstname}</h2>
                <h2>{this.props.lastname}</h2>
                <button className="btn btn-success" onClick={this.props.myclick}>Click me</button>
            </div>
        )
    }
}

export default MyClass