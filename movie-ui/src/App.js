import './App.css';
import React, {useEffect, useState} from "react";
import api from "./api/AxiosConfig";
import Layout from "./components/Layout";
import {Route, Routes} from "react-router-dom";
import Home from "./components/home/Home";
import Header from "./components/header/Header";
import Trailer from "./components/trailer/Trailer";

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
            <Header/>
            <Routes>
                <Route path="/" element={<Layout/>}>
                    <Route path="/" element={<Home movies={movies} />} ></Route>
                    <Route path="/Trailer/:ytTrailerId" element={<Trailer/>}></Route>
                    {/*<Route path="/Reviews/:movieId" element ={<Reviews getMovieData = {getMovieData} movie={movie} reviews ={reviews} setReviews = {setReviews} />}></Route>
                    <Route path="*" element = {<NotFound/>}></Route>*/}
                </Route>
            </Routes>

        </div>
    );
}

export default App;
