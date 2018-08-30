import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {

  state = {
    isLoading: false,
    isAuthenticated: false,
    currentUser: null,
  }

  __loadCurrentUser() {

    const body = {
      url: "http://localhost:8080/user/currentUser",
      method: 'GET'
    };

    this.setState({
      isLoading: true,
    });

    fetch(body.url, body)
      .then(response => {
        this.setState({
          currentUser: response,
          isLoading: false,
          isAuthenticated: true,
        });
      })
      .catch(error => {
        this.setState({
          isLoading: false
        });
      });
  }

  componentWillMount() {
    this.__loadCurrentUser();
    console.log(this.state.currentUser);
  }

  render() {
    return (
      <div className="App" >
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Welcome to React</h1>
        </header>
        <p className="App-intro">
          To get started, edit <code>src/App.js</code> and save to reload.
        </p>
      </div>
    );
  }
}

export default App;
