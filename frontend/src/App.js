import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ArtworkList from './ArtworkList';
import ArtworkEdit from "./ArtworkEdit";



// function App() {
//   return (
//     <div className="App">
//       <header className="App-header">
//         <img src={logo} className="App-logo" alt="logo" />
//         <p>
//           Edit <code>src/App.js</code> and save to reload.
//         </p>
//         <a
//           className="App-link"
//           href="https://reactjs.org"
//           target="_blank"
//           rel="noopener noreferrer"
//         >
//           Learn React
//         </a>
//       </header>
//     </div>
//   );
// }

//https://www.baeldung.com/spring-boot-react-crud -> rozdział 3.3 - wygląda trochę inaczej.....
// class App extends React.Component {
//   state = {
//     artworks: []
//   };

//   async componentDidMount() {
//     const response = await fetch('/artworks');
//     const body = await response.json();
//     this.setState({artworks: body});
//   }


//   render() {
//     const {artworks} = this.state;
//     return (
//         <div className="App">
//           <header className="App-header">
//             <img src={logo} className="App-logo" alt="logo" />
//             <div className="App-intro">
//               <h2>artworks</h2>
//               {artworks.map(artwork =>
//                   <div key={artwork.id}>
//                     {/* {client.name} ({client.email}) */}
//                     {artwork.title}, {artwork.author}
//                   </div>
//               )}
//             </div>
//           </header>
//         </div>
//     );
//   }
// }

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/artworks' exact={true} component={ArtworkList}/>
            <Route path='/artworks/:id' component={ArtworkEdit}/>
          </Switch>
        </Router>
    )
  }
}


export default App;
