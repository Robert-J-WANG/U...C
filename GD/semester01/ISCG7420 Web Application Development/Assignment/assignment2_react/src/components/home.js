import React from 'react';

function Home(props) {
    return (
        <div style={{marginTop: "100px"}}>
            {
                localStorage.getItem("token") ?
                    <p className={'display-3'} >Welcome to Attendance System</p>
                    :
                    <p className={'display-3'}>
                    Welcome to the Attendance System <br />
                    Please login
                </p>
            }
        </div>
    );
}

export default Home;
