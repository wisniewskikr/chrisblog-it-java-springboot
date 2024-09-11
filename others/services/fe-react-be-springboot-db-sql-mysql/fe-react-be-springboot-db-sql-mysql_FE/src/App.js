import { useState, useEffect } from "react";

function App() {

  const [message, setMessage] = useState("");
  const [idBe, setIdBe] = useState("");
  const [portBe, setPortBe] = useState("");
  const idFe = "idFe";
  const portFe = "portFe";

  useEffect(() =>{

    const fetchData = async () => {

      const response = await fetch("https://localhost:8081/message/1");
      const result = await response.json();
      setMessage(result.message);
      setIdBe(result.idBe);
      setPortBe(result.portBe);

    };

    fetchData();

  }, []);

  return (
    <ul>
      <li>
          <span><b>Database Message: </b></span>
          <span> {{message}} </span>
      </li>
      <li>
          <span><b>Back-End Id: </b></span>
          <span> {{idBe}} </span>
      </li>
      <li>
          <span><b>Back-End Port: </b></span>
          <span> {{portBe}} </span>
      </li>
      <li>
          <span><b>Front-End Id: </b></span>
          <span> {{idFe}} </span>
      </li>
      <li>
          <span><b>Front-End Port: </b></span>
          <span> {{portFe}} </span>
      </li>
  </ul>
  );

}

export default App;