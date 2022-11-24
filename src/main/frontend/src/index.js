import React from 'react';
import ReactDOM from 'react-dom/client';
import Mainproj from './mainproj';
import { BrowserRouter } from 'react-router-dom'

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(

  <React.StrictMode>
    <BrowserRouter>
      <Mainproj />
    </BrowserRouter>
  </React.StrictMode>

);

