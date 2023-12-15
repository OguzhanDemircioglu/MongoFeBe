import './App.css';
import React, {useEffect, useState} from "react";
import api from "./api/AxiosConfig";
import Layout from "./components/Layout";
import {Route, Routes} from "react-router-dom";
import Home from "./components/home/Home";

function App() {

    const [movies, setMovies] = useState();

    const getMovies = async () => {

        try {
            const response = await api.get("movies/");
            setMovies(response.data);
            console.log("kac", response.data);
        } catch (err) {
            console.log(err);
        }
    }

    useEffect(() => {
        getMovies();
    }, [])

    return (
        <div className="App">
            <p>LOOOOOOOOOOOOOOOO</p>
            <Routes>
                <Route path="/" element={<Layout/>}>
                <Route path="/" element={<Home movies={movies}/>}/>
                </Route>

            </Routes>

        </div>
    );
}

export default App;
