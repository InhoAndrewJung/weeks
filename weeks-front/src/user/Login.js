// Import FirebaseAuth and firebase.
import React from 'react';
import StyledFirebaseAuth from 'react-firebaseui/StyledFirebaseAuth';
import firebase from 'firebase';
import Todo from '../todo/Todo';
// Configure Firebase.
const config = {
  apiKey: 'AIzaSyC5UiWtouQv6_SrLNLMa7niqCaRYyFM424',
  authDomain: 'weeks-34339.firebaseapp.com',
  // ...
};
firebase.initializeApp(config);

class SignInScreen extends React.Component {

  // The component's Local state.
  state = {
    isSignedIn: false // Local signed-in state.
  };

  // Configure FirebaseUI.
  uiConfig = {
    // Popup signin flow rather than redirect flow.
    signInFlow: 'popup',
    // We will display Google and Facebook as auth providers.
    signInOptions: [
      firebase.auth.GoogleAuthProvider.PROVIDER_ID,
      firebase.auth.FacebookAuthProvider.PROVIDER_ID
    ],
    callbacks: {
      // Avoid redirects after sign-in.
      signInSuccessWithAuthResult: () => false
    }
  };

  // Listen to the Firebase Auth state and set the local state.
  componentDidMount() {
    this.unregisterAuthObserver = firebase.auth().onAuthStateChanged(
        (user) => this.setState({isSignedIn: !!user})
    );
  }
  
  // Make sure we un-register Firebase observers when the component unmounts.
  componentWillUnmount() {
    this.unregisterAuthObserver();
  }

  
  render() {
    if (!this.state.isSignedIn) {
      return (
        <div>
        <h5 class="card-header">아래의 계정을 통해 로그인해주세요.</h5>
        <div class="card-body">
        <div>
          <StyledFirebaseAuth uiConfig={this.uiConfig} firebaseAuth={firebase.auth()}/>
        </div>
        </div>
        </div>
      );
    }
    if (this.state.isSignedIn) {
        fetch(`/user/signManagement`,{
          method: `POST`,
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
          body: JSON.stringify({uid : firebase.auth().currentUser.uid})
        }
      )
      .then(response => response.json())
      .then(json => console.log(json))
      .catch(error => console.log(error))
    }
    return (
      <Todo />
      // <div>
      //   <p>{firebase.auth().currentUser.uid}</p>
      //   <p>Welcome {firebase.auth().currentUser.displayName}! You are now signed-in!</p>
      //   <a onClick={() => firebase.auth().signOut()}>Sign-out</a>
      // </div>
    );
  }
}

export default SignInScreen