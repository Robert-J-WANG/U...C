import React, {Component} from 'react';

class Maps extends Component {

    myElements(names) {
            return names.map(name =>
                <div key={name}>
                    {`${name}`}
                </div>
            )
        }

    render() {

        return (
            <div>
                {this.myElements(this.props.names)}
            </div>
        );
    }
}

export default Maps;