import logo from './logo.svg';
import './App.css';
import MoviesList from './components/MoviesList.js';
import MovieDetails from './components/MovieDetails.js';
function App() {
  return (
    <div className="App">
      <header className="App-header">
            <h1> Reviews</h1>
      </header>
      <main>
        <MoviesList />
      </main>
    </div>

  );
}

export default App;
