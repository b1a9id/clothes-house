import React from 'react';
import './App.css';
import { Route, Switch } from "react-router";
import Closet from "./components/Closet";
import Setting from "./components/Setting";
import Nav from "./containers/Nav";

function App() {
  return (
    <div className="App">
      <Nav />
      <Switch>
        <Route exact path="/" component={Closet} />
        <Route path="/settings" component={Setting} />
      </Switch>
    </div>
  )
}

export default App;
