import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container"
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import {NavLink} from "react-router-dom";
import {faVideoSlash} from "@fortawesome/free-solid-svg-icons/faVideoSlash";

const Header = () => {
    return (
        <Navbar bg="dark" variant="dark" expand="lg">
            <Container fluid>
                <Navbar.Brand href="/" style={{"color": "gold"}}>
                    <FontAwesomeIcon icon={faVideoSlash}/>Gold
                </Navbar.Brand>
                <Nav
                    className="me-auto my-2 my-lg-0"
                    style={{maxHeight: "100px"}}
                    id="navbarScroll">
                    <NavLink className="nav-link" to="/" style={{width:"50px"}}>Home</NavLink>
                    <NavLink className="nav-link" to="/watchList" style={{width:"100px"}}>Watch List</NavLink>
                </Nav>
                <Button variant="outline-info" className="me-2">Login</Button>
                <Button variant="outline-info" className="me-2">Register</Button>
            </Container>
        </Navbar>)
}

export default Header;