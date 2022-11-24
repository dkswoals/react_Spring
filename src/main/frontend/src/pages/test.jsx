import axios from "axios";
import { useState , useEffect } from "react";


function Forgot() {

   const [msg,setMsg] = useState([]);

var Member ={
    userId : "a4445656",
    name : "안재민",
    pwd : "ac8459",
    email : "a4445656@naver.com",
    schoolId : "20190946",
    phone : "01030967244",
    level : 1
}

    useEffect(() => {

        axios.post("/api/sign-up",Member
        ).then(response => {
           // console.log(response.data);
            setMsg(response.data);
            console.log(response);
            }
        )
     }, []);

  return (
    <div className="App">
        {msg.name}
    </div>
  );
}
export default Forgot;
