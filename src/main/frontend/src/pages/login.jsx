import '../pages/pages_css/login.css';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Checkbox from '@mui/material/Checkbox';
import FormControlLabel from '@mui/material/FormControlLabel';
import {Link} from "react-router-dom";

function login() {

  return (
    <div className="App">

      <div className="login_container">

        <div className='img_area'>
          <img src="/login/loginmain.jpg" width="300px" height="300px"></img>
        </div>

        <div className="login_form">

          <div>
            <h2>로그인</h2>
          </div>

          <form >

            <div className='id_container'>
              <TextField name="id" label="아이디"  type="text" autoFocus fullWidth require/>
            </div>  

            <div className='pw_container'>
              <TextField name="pw" label="비밀번호"  required type="password"  fullWidth  
            
              />
            </div>


            <div className='idremem'>
              <FormControlLabel
                control={<Checkbox value="remember" color="primary" />}
                label="아이디 기억하기"
              />
            </div>


            <div className='bt_container'>
              <Button variant="contained" disableElevation type="submit" fullWidth >
               로그인
              </Button>
            </div>
          </form>


          <div className='rink_container'>
            <Grid container>
                <Grid item xs>
                    <Link to="/Singup">
                        아이디/비밀번호 찾기
                   </Link>
                </Grid>

                <Grid item xs>
                  <Link to="/Singup">
                    회원가입
                  </Link>
                </Grid>
            </Grid>
          </div>

        </div>

      </div>
      
    </div>
  );
}

export default login;
