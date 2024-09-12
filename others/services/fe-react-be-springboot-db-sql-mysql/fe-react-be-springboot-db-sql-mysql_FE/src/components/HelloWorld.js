import { useState, useEffect } from "react";
import getFixedUUID from "../services/uuidService";

function HelloWorld() {

  const [message, setMessage] = useState("");
  const [idBe, setIdBe] = useState("");
  const [portBe, setPortBe] = useState("");
  const [idFe, setIdFe] = useState("");
  const portFe = window.location.port;

  useEffect(() =>{

    const uuid = getFixedUUID();
    setIdFe(uuid);
    const apiUrl = process.env.REACT_APP_API_URL;
    
    const fetchData = async () => {

      const response = await fetch(`${apiUrl}/message/1`);
      const result = await response.json();
      setMessage(result.text);
      setIdBe(result.idBe);
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
          <span><b>Back-End Id: </b></span>
          <span> {idBe} </span>
      </li>
      <li>
          <span><b>Back-End Port: </b></span>
          <span> {portBe} </span>
      </li>
      <li>
          <span><b>Front-End Id: </b></span>
          <span> {idFe} </span>
      </li>
      <li>
          <span><b>Front-End Port: </b></span>
          <span> {portFe} </span>
      </li>
    </ul>
  );

}

export default HelloWorld;