import { useState, useEffect } from "react";

function HelloWorld() {

  const [message, setMessage] = useState("");
  const [portBe, setPortBe] = useState("");
  const portFe = window.location.port;

  useEffect(() =>{

    const apiUrl = process.env.REACT_APP_API_URL;
    
    const fetchData = async () => {

      const response = await fetch(`${apiUrl}/message/1`);
      const result = await response.json();
      setMessage(result.text);
      setPortBe(result.portBe);

    };

    fetchData();

  }, []);

  return (
    <ul>
      <li>
          <span><b>Database Message: </b></span>
          <span> {message} </span>
      </li>
      <li>
          <span><b>Back-End Port: </b></span>
          <span> {portBe} </span>
      </li>
      <li>
          <span><b>Front-End Port: </b></span>
          <span> {portFe} </span>
      </li>
    </ul>
  );

}

export default HelloWorld;