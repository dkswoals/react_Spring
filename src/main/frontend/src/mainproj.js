import React from 'react';
import {Routes , Route} from "react-router-dom";
import Forgot from "./pages/forgot";
import NotFound from "./pages/NotFound";
import Login from "./pages/login";
import Singup from "./pages/singup";
import Student from "./pages/student";
import Teachermain from "./pages/teachermain";
import Cheat from "./pages/cheat";
import Test from "./pages/test";
import Test2 from "./pages/test2";


function mainproj() {
  return (
    <Routes>
      <Route path="/login"  element={<Login/>} />
      <Route path="/singup"  element={<Singup/>} />
      <Route path="/forgot"  element={<Forgot/>} />
      <Route path="/test"  element={<Test/>} />
        <Route path="/test2"  element={<Test2/>} />
      <Route path="/teachermain"  element={<Teachermain/>} />
      <Route path="/studentmain"  element={<Student/>} />
      <Route path="/cheat"  element={<Cheat/>} />
      <Route path="/*"  element={<NotFound/>} />
    </Routes>
  );
}
export default mainproj;
