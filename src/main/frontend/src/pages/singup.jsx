import '../pages/pages_css/singup.css';
import TextField from '@mui/material/TextField';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import Button from '@mui/material/Button';
import { useState } from 'react';
import axios from "axios";


function Singup() {

  
 /////////////////////////////////////////////
    const [name, setname ]= useState("");
    const [id, setid ]= useState("");
    const [pw, setpw ]= useState("");
    const [pw1, setpw1 ]= useState("");
    const [level, setlevel ]= useState("");
    const [email, setemail ]= useState("");
    const [phone, setphone ]= useState("");
//////////////////////////////////////////////
    const onnameHandler = (e) => {
        setname(e.target.value);
    };

    const onidHandler = (e) => {
        setid(e.target.value);
    };

    const onpwHandler = (e) => {
        setpw(e.target.value);
    };

    const onpw1Handler = (e) => {
        setpw1(e.target.value);
    };

    const onlevelHandler = (e) => {
        setlevel(e.target.value);
    };

    const onemailHandler = (e) => {
        setemail(e.target.value);
    };

    const onphoneHandler = (e) => {
        setphone(e.target.value);
    };
///////////////////////////////////////////////
 
  ///////////////////////////////////////////////  
    const onSubmitHandler = (e) =>{
      

      axios.post('api/sign-up', {
        Name: name,    //key , value
        USERID: id,
        PWD : pw,
        LEVEL: level,
        EMAIL: email,
        PHONE: phone,
      })
      .then(function (response) {
        //값 받아오기
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      });
    };
    
  ///////////////////////////////////////////////////////////////    
     





  return (
    <div className="App">
      <div className="singup_container">
        
        <div className="head">
          
          <h2>
            회원가입
          </h2>

        </div>

        <form onSubmit={onSubmitHandler}>
          <div className="singup_tain">

            <div className='name_tain'>
              <TextField  label="이름" type="text" variant="outlined"required fullWidth
                value={name} onChange={onnameHandler}
              />
            </div>

            <div className='id_tain'>
              <TextField  label="아이디" type="text" variant="outlined"required
                value={id} onChange={onidHandler}
              
              />
              <div className='idchek'>
                <Button  variant="contained">
                중복확인
                </Button>
              </div>
            </div>

            <div className='pw_tain'>
              <TextField  label="비밀번호" type="password" variant="outlined" required fullWidth
               value={pw} onChange={onpwHandler}
               
               
               />
            </div>

            <div className='pw1_tain'>
              <TextField  label="비밀번호 확인" type="password" variant="outlined"
               required fullWidth
               value={pw1} onChange={onpw1Handler}
               />
               <p className='pwalr'>비밀번호가 일치하지 않습니다.!</p>
            </div>

            <div className='chek_tain'>
              <FormControl>
                <FormLabel >레벨</FormLabel>
                <RadioGroup row aria-labelledby="demo-row-radio-buttons-group-label" name="row-radio-buttons-group" 
                    value={level} onChange={onlevelHandler}>
                  <FormControlLabel value="student" control={<Radio value="0" />} label="학생" />
                  <FormControlLabel value="teacher" control={<Radio value="1"/>} label="선생님" />
                </RadioGroup>
              </FormControl>
            </div>

            <div className='mail_tain'>
              <TextField  label="이메일" type="email" variant="outlined"
               fullWidth required autoComplete="email"
               value={email} onChange={onemailHandler}
               
               />
            </div>

            <div className='phone_tain'>
              <TextField label="전화번호" type="text"
               variant="outlined" fullWidth required 
               value={phone}
               onChange={onphoneHandler}
               
               />
            </div>

            <div className='btn_container'>
              <Button type="submit" fullWidth variant="contained"  >
               회원가입
              </Button>
            </div>

          </div>
        </form>

    
      </div>

    </div>
  );
}

export default Singup;
