import './App.css';
import {useEffect, useState} from "react";
function App() {
  const [message, setMessage] = useState([]);

  useEffect(() => {
    fetch("/home")
        .then((response) => {
          return response.json();
        })
        .then(function (data) {
          setMessage(data);
        }); }, []);
  return (
      <div className="App">

        {message.map((text, index) =>
            <li key={`${index}-${text}`}>{text}
            </li>
        )}
      </div>
  ); }

export default App;