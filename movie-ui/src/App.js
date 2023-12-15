import './App.css';
import {useEffect, useState} from "react";
import api from "./api/axiosConfig";
function App() {

    const [movies, setMovies] = useState();

    const getMovies = async () => {

        try {
            const response = await api.get("api/movies/");
            //setMovies(response.data);
            console.log("kac",response.data);
        } catch (err) {
            console.log(err);
        }
    }

    useEffect(() => {
      getMovies();
    },[])

    return (
        <div className="App">
<p>LOOO</p>
        </div>
    );
}

export default App;
