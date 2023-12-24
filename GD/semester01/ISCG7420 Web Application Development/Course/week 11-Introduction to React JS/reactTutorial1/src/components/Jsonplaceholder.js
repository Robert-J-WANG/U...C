import React, {Component} from 'react';

class Jsonplaceholder extends Component {

    constructor() {
        super();
        this.state = {
            posts:[]
        }
    }

    componentDidMount() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response =>response.json())
            .then(data => {
                this.setState({posts:data})
            })
    }

    render() {
        return (
            <div>
                {this.state.posts.map(post=>
                <h2 key={post.id}>{post.title}</h2>
                )}
            </div>
        );
    }
}

export default Jsonplaceholder;