import './App.css';
import {useEffect, useState} from "react";
function App() {
  const [message, setMessage] = useState([]);

  //useEffect의 첫번째 파라미터는 함수, 두번째 파라미터는 의존값이 들어있는 배열(deps)를 넣는다.
  //만약 deps를 비우면 컴포넌트가 처음 나타날 때에만 useEffect에 등록한 함수가 호출된다
  useEffect(() => {
      //fetch 함수는 API를 사용하여 백엔드 서버와 비동기 요청을 하는 방식 중 하나.
    fetch("/home")
        .then((response) => {
          return response.json(); // json으로 줘도 json을 표기해야 데이터가 나옴
        })
        .then(function (data) {
          setMessage(data);
        }); }, []);
  return (
      <div className="App">

        {message.map((text, index) =>
            <li key={`${index}-${text}`}>{text} <h3> {text}에 setmessage한 백엔드 데이터가 나옴</h3>
            </li>
        )}
      </div>
  ); }

export default App;