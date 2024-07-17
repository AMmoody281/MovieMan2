
import React,{useEffect, useState} from 'react';
import axios from 'axios';

const MovieList = () => {
    const[movies,setMovies] = useState([]);

    useEffect(()=>{
    axios.get('http://localhost:8081/movies')
        .then(response => {
            .setMovies(response.data)
        })
        .catch(error => {
            console.error('Error finding movies:', error);
        });

    }, []);

    return (
        <div>
        <h2>Movie List</h2>
            <ul>
            {movies.map(movie => (
                    <li key={movie.id}>
                        <h3>{movie.title} ({movie.year})</h3>
        //                <ReviewsList movieId={movie.id}
                    </li>
                ))}
            </ul>
        </div>
    );

};

export default MoviesList;