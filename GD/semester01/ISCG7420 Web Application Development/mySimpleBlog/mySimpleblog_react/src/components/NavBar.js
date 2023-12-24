import {Container, Nav, Navbar, NavDropdown} from "react-bootstrap";
import React, {Fragment, useEffect, useState} from 'react';



function NavBar(props) {
 const [token, setToken] = useState("")
 const [hasToken, setHasToken] = useState(false)

    useEffect(() => {
        if (localStorage.getItem("token")) {
            setHasToken(true)
            setToken(localStorage.getItem("token"))
        }
    },[token]);

    return (
       <Navbar bg="light" expand="lg">
      <Container>
        <Navbar.Brand href="/">SimpleBlog</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link href="home">Home</Nav.Link>
              <Nav.Link href="posts">Posts</Nav.Link>
            <Nav.Link href="category">Category</Nav.Link>
            {hasToken?
                <Nav.Link href="login">Logout</Nav.Link> :
                <Nav.Link href="login">Login</Nav.Link>
            }
            <NavDropdown title="Dropdown" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
              <NavDropdown.Item href="#action/3.2">
                Another action
              </NavDropdown.Item>
              <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
              <NavDropdown.Divider />
              <NavDropdown.Item href="#action/3.4">
                Separated link
              </NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    );
}

export default NavBar;
