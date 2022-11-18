import React, {useState, useEffect} from 'react';
import './App.css';
import axios from "axios";

function App () {
    const [message, setMessage] = useState("");

    useEffect(() => {
      axios.get('api/test')
          .then(Response)
    })
    return (
        <div className="App">
            <header className="App-header">
                <h1 className="App-title">{message}</h1>
            </header>
        </div>
    )
}

export default App;