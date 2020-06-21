import React, { Component } from 'react';
import './App.css';
import { Route, Switch } from "react-router";
import Closet from "./containers/Closet";
import Setting from "./components/Setting";
import Nav from "./containers/Nav";
import AppBar from '@material-ui/core/AppBar';
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import CssBaseline from "@material-ui/core/CssBaseline";

class App extends Component {
  render() {
    return (
      <div className="App" style={{ paddingLeft: 240 }}>
        <CssBaseline />
        <AppBar position="fixed" style={{ left: 240 }}>
          <Toolbar>
            <Typography variant="h6" noWrap>
              Clothe House
            </Typography>
          </Toolbar>
        </AppBar>

        <Nav />
        <Switch style={{ marginTop: 64, padding: 32}}>
          <Route exact path="/" component={Closet} />
          <Route path="/settings" component={Setting} />
        </Switch>
      </div>
    )
  }
}

export default App;
