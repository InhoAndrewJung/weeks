import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Login from './user/Login'

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
          <h1 className="App-title" style={{fontSize:50, fontWeight:600, paddingTop:5}}>WEEKS</h1>
        </header>
        <div className="card" style={{width:500, marginTop:50, marginLeft:'auto', marginRight:'auto'}}>
        <Login />
        </div>
      </div>
    );
  }
}

export default App;
