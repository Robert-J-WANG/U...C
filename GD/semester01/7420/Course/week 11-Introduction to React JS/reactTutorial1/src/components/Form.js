import React, {Component} from 'react';

class Form extends Component {
    constructor() {
        super();
        this.state={
            username:'',
            password:''
        }
    }

    componentDidMount() {
        this.setState({
            username:'lsong'
        })
    }

    usernameHandler = (event) => {
        this.setState({
            username:event.target.value
        })
    }

    passwordHandler = (event) => {
        this.setState({
            password:event.target.value
        })
    }

    render() {
        return (
            <div className="container">
                <p>Username: <input value={this.state.username} onChange={this.usernameHandler} className="form-control" type="text" /></p>
                <p>Password: <input onChange={this.passwordHandler} className="form-control" type="password"/></p>
                <p><button className="btn btn-success">Login</button></p>
            </div>
        );
    }
}

export default Form;