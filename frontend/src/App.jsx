import React from 'react';
import './App.css';
import { Route, Switch } from "react-router";
import { Link } from "react-router-dom";
import Closet from "./components/Closet";
import Setting from "./components/Setting";

function App() {
  return (
    <div className="App">
      <ul>
        <li><Link to="/">Closet</Link></li>
        <li><Link to="/settings">Setting</Link></li>
      </ul>
      <Switch>
        <Route exact path="/" component={Closet} />
        <Route path="/settings" component={Setting} />
      </Switch>
    </div>
  )
}

export default App;
