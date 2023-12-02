// import logo from './logo.svg';
import React from 'react';
import './App.css';
import SearchIcon from './search.svg'
import { useState, useEffect } from 'react';
import MovieCard from './MovieCard.jsx';

// ad408c02

const API_URL='http://www.omdbapi.com?apikey=ad408c02';

const App = () => {
  const [movies, setMovies] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

  const searchMovies = async (title) => {
    const response = await fetch(`${API_URL}&s=${title}`);
    const data = await response.json();
    console.log(data.Search);
    setMovies(data.Search);
  }

  useEffect(() => {searchMovies('Jurassic Park')}, []);
  
  return (
    <div className = "App">
      <h1>why does this fade out like that</h1>

      <div className = "search">
        <input
          placeholder = "Search for movies"
          value = {searchTerm}
          onChange = {(e) => setSearchTerm(e.target.value)}
        />
        <img
          src = {SearchIcon}
          alt = "search"
          onClick = {() => searchMovies(searchTerm)}
        />
      </div>

      {
        movies?.length > 0
          ? (
            <div className = "container">
              {movies.map((movie) => (
                <MovieCard movie = {movie}/>
              ))}
            </div>
          )
          : (
            <div className = "empty">
              <h2>No movies found</h2>
            </div>
          )
      }

      
    </div>
  );
}

export default App;
