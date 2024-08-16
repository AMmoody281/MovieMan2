import React, { useState, useEffect } from 'react';
import axios from 'axios';
import '../MoviesList.css';
import MovieDetails from './MovieDetails';
import Modal from 'react-modal';

const MoviesList = () => {
  const [movies, setMovies] = useState([]);
  const [selectedMovie, setSelectedMovie] = useState(null);
  const [isModalOpen, setIsModalOpen] = useState(false); // Add modal state

   useEffect(() => {
      // Fetch movies
      const fetchMovies = async () => {
        try {
          const response = await axios.get('http://localhost:8081/movies');
          setMovies(response.data);
        } catch (error) {
          console.error('Error finding movies:', error);
        }
      };

      fetchMovies();


    }, []);

  const handleMovieClick = (movie) => {
    setSelectedMovie(movie);
    setIsModalOpen(true); // Open the modal
  };

  const closeModal = () => {
    setIsModalOpen(false); // Close the modal
  };

  return (
    <div className="movies-container">
      {movies.map(movie => (
        <div
          className="movie-card"
          key={movie.id}
          onClick={() => handleMovieClick(movie)}
        >
          {/* Render movie card content */}
          <div className="movie-poster">
            {/* Future insert image here */}
          </div>
          <div className="movie-details">
            <h2>{movie.title}</h2>
            <p>{movie.rating}</p>
          </div>
        </div>
      ))}
      {/* Render MovieDetails in a modal */}
      <Modal
        isOpen={isModalOpen}
        onRequestClose={closeModal}
        contentLabel="Movie Details"
      >
        {selectedMovie && <MovieDetails movie={selectedMovie} />}
        <button onClick={closeModal}>Close</button>
      </Modal>
    </div>
  );
};

export default MoviesList;
